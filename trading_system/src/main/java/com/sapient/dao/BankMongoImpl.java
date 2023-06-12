package com.sapient.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import com.sapient.exceptions.BankNameException;
import com.sapient.facades.BankFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Bank;
import org.bson.Document;

import java.io.IOException;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class BankMongoImpl implements BankFacade {
    private MongoClient mongoClient;
    private ResourceBundle resourceBundle;
    private MongoCollection mongoCollection;
    private Boolean status;
    private Gson gson;

    public BankMongoImpl() {
        resourceBundle= ResourceBundle.getBundle("db");
        mongoClient= MongoDBHelper.getConnection();
        //creating db
        var database= mongoClient
                .getDatabase(resourceBundle.getString("dbname"));
        var collectionName=resourceBundle.getString("bankCollection");
        if(database.getCollection(collectionName)==null)
            database.createCollection(collectionName);
        mongoCollection= database.getCollection(collectionName);
        // one variable normal index 2 variable compound index
        mongoCollection.createIndex(Indexes.ascending("bankName"));
        gson=new Gson();
    }

    @Override
    public boolean addBank(Bank bank) throws IOException {
        Document document= Document.parse(gson.toJson(bank));
        mongoCollection.insertOne(document);
        status=true;
        return true;
    }

    @Override
    public boolean editBank(Bank bank, String bankName) throws BankNameException, IOException {
        Document document= Document.parse(gson.toJson(bank));
        mongoCollection.updateOne(new Document("bankName",bankName),
                new Document("$set",document));
        status=true;
        return status;
    }

    @Override
    public boolean deleteBank(String bankName) throws IOException {
        mongoCollection.deleteOne(eq("bankName",bankName));
        status = true;
        return status;
    }
}
