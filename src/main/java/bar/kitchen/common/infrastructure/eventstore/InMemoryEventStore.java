package bar.kitchen.common.infrastructure.eventstore;

import bar.kitchen.common.domain.event.Event;
import bar.kitchen.common.domain.event.EventStore;
import rx.Observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IONER on 17/07/2016.
 */
public class InMemoryEventStore implements EventStore {

    private Map<UUID, List<Event>> registry;

    public InMemoryEventStore() {
        this.registry = new HashMap<>();
    }

    @Override
    public Observable<Event> LoadEventsFor(UUID id) {
        return Observable.from(registry.get(id));
    }

    @Override
    public void SaveEventsFor(UUID id, Observable<Event> newEvents) {
        LoadEventsFor(id)
                .onErrorResumeNext(Observable.empty())
                .concatWith(newEvents)
                .toList()
                .doOnNext(events -> registry.put(id, events))
                .toBlocking().first();
    }
}
