package io.pivotal.pal.tracker;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    HashMap<Object, TimeEntry> timeEntryHashMap = new HashMap<>();
    long counter = 0;

    @Override
    public void delete(long id) {
        timeEntryHashMap.remove(id);
    }

    @Override
    public TimeEntry find(long id) {
        TimeEntry entry = timeEntryHashMap.get(id);
        return entry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntryHashMap.get(id)!=null) {
            TimeEntry newEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            timeEntryHashMap.put(id, newEntry);
            return newEntry;
        } else {
            return null;
        }

    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        counter = counter+1;
        TimeEntry newEntry=new TimeEntry(counter, timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryHashMap.put(counter,newEntry);
        return newEntry;
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryList = new ArrayList<TimeEntry>();
        for (long i=1; i<=timeEntryHashMap.size();i++) {
            timeEntryList.add(timeEntryHashMap.get(i));
        }
        return timeEntryList;
    }
}
