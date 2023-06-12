package com.sapient.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import com.sapient.facades.CalendarFacade;
import com.sapient.facades.CurrencyFacade;
import com.sapient.helpers.MongoDBHelper;
import com.sapient.models.Calendar;
import com.sapient.models.Currency;
import com.sapient.models.Event;
import org.bson.Document;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static com.mongodb.client.model.Filters.eq;

public class CalendarMongoImpl implements CalendarFacade {

    private Calendar calendar;
    private MongoClient mongoClient;
    private ResourceBundle resourceBundle;
    private MongoCollection mongoCollection;
    private Boolean status;
    private Gson gson;
    public CalendarMongoImpl(Calendar calendar) {
        this.calendar = calendar;
        resourceBundle= ResourceBundle.getBundle("db");
        mongoClient= MongoDBHelper.getConnection();
        //creating db
        var database= mongoClient
                .getDatabase(resourceBundle.getString("dbname"));
        var collectionName=resourceBundle.getString("calendarCollection");
        if(database.getCollection(collectionName)==null)
            database.createCollection(collectionName);
        mongoCollection= database.getCollection(collectionName);
        // one variable normal index 2 variable compound index
//        mongoCollection.createIndex(Indexes.ascending("currencyId"));
        gson=new Gson();
    }

    @Override
    public boolean addEvent(Event event) {
        this.calendar.getEvents().add(event);
        Document document= Document.parse(gson.toJson(this.calendar));
        mongoCollection.insertOne(document);
        status=true;
        return true;
    }

    @Override
    public boolean editEvent(int id, Event event) {
        List<Event> eventList =  this.calendar.getEvents();
        for(int i=0; i<eventList.size(); i++){
            if(eventList.get(i).getId() == id){
                eventList.set(i,event);
            }
        }
        this.calendar.setEvents(eventList);
        Document document= Document.parse(gson.toJson(calendar));
        mongoCollection.updateOne(new Document("calendarId",this.calendar.getCalendarId()),
                new Document("$set",calendar));
        status=true;
        return status;
    }

    @Override
    public boolean deleteEvent(int id) {
        List<Event> eventList =  this.calendar.getEvents();
        for(int i=0; i<eventList.size(); i++){
            if(eventList.get(i).getId() == id){
                eventList.remove(i);
                break;
            }
        }
        this.calendar.setEvents(eventList);
        mongoCollection.updateOne(new Document("calendarId",this.calendar.getCalendarId()),
                new Document("$set",calendar));
        status=true;
        return status;
    }
}

