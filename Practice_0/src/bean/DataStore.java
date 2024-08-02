package bean;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static List<Event> events = new ArrayList<Event>();
    private static List<Registration> registrations = new ArrayList<Registration>();
    
    //add multiple events and registrations for those events

    public static List<Event> getEvents() {
        return events;
    }

    public static List<Registration> getRegistrations() {
        return registrations;
    }
}