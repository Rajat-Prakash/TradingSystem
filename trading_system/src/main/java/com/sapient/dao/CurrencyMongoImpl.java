package com.sapient.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import com.sapient.facades.CurrencyFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Currency;
import org.bson.Document;

import java.io.IOException;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class CurrencyMongoImpl implements CurrencyFacade {

    private MongoClient mongoClient;
    private ResourceBundle resourceBundle;
    private MongoCollection mongoCollection;
    private Boolean status;
    private Gson gson;
    public CurrencyMongoImpl() {
        resourceBundle= ResourceBundle.getBundle("db");
        mongoClient= MongoDBHelper.getConnection();
        //creating db
        var database= mongoClient
                .getDatabase(resourceBundle.getString("dbname"));
        var collectionName=resourceBundle.getString("currencyCollection");
        if(database.getCollection(collectionName)==null)
            database.createCollection(collectionName);
        mongoCollection= database.getCollection(collectionName);
        // one variable normal index 2 variable compound index
        mongoCollection.createIndex(Indexes.ascending("currencyId"));
        gson=new Gson();
    }

    @Override
    public boolean addCurrency(Currency currency) throws IOException {
        Document document= Document.parse(gson.toJson(currency));
        mongoCollection.insertOne(document);
        status=true;
        return true;
    }

    @Override
    public boolean editCurrency(int id, Currency currency) throws IOException {
        Document document= Document.parse(gson.toJson(currency));
        mongoCollection.updateOne(new Document("currencyId",id),
                new Document("$set",document));
        status=true;
        return status;
    }

    @Override
    public boolean deleteCurrency(int currencyId) throws IOException {
        mongoCollection.deleteOne(eq("currencyId",currencyId));
        status = true;
        return status;
    }
}
