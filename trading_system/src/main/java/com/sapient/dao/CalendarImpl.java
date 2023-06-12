package com.sapient.dao;

import com.sapient.facades.CalendarFacade;
import com.sapient.models.Calendar;
import com.sapient.models.Event;

import java.util.List;

public class CalendarImpl implements CalendarFacade {
    private Calendar calendar;

    public CalendarImpl(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public boolean addEvent(Event event) {
        this.calendar.getEvents().add(event);
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
        return true;
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
        return true;
    }
}
