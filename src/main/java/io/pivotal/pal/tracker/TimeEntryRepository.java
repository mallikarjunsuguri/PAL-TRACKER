package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {

    void delete(long id);

    TimeEntry find(long id);

    TimeEntry update(long id, TimeEntry timeEntry);

    TimeEntry create(TimeEntry timeEntry);

    List<TimeEntry> list();
}
