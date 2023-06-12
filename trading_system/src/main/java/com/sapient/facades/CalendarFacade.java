package com.sapient.facades;

import com.sapient.models.Event;


public interface CalendarFacade {
    public boolean addEvent(Event event);
    public boolean editEvent(int id,Event event);
    public boolean deleteEvent(int id);
}
