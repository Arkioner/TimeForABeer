package bar.kitchen.common.domain.event;

import rx.Observable;

import java.util.UUID;

/**
 * Created by IONER on 17/07/2016.
 */
public interface EventStore {
    Observable<Event> LoadEventsFor(UUID id);
    void SaveEventsFor(UUID id, Observable<Event> newEvents);
}
