package bar.kitchen.common.infrastructure.repository;

import bar.kitchen.common.domain.entity.tab.event.TabOpened;
import bar.kitchen.common.domain.entity.waiter.Waiter;
import bar.kitchen.common.domain.entity.waiter.WaiterRepository;
import bar.kitchen.common.domain.entity.waiter.event.WaiterHired;
import bar.kitchen.common.domain.event.Event;
import bar.kitchen.common.domain.event.EventStore;
import rx.Observable;

import java.util.List;
import java.util.UUID;

public class EventStoreWaiterRepository implements WaiterRepository{

    private EventStore eventStore;

    public EventStoreWaiterRepository(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public Observable<Waiter> getById(UUID id) {
        return eventStore.LoadEventsFor(id)
                .reduce(new Waiter(), (waiter, event) -> {
                    if (event instanceof WaiterHired) {
                        waiter.apply((WaiterHired) event);
                    } else {
                        waiter.apply((TabOpened) event);
                    }
                    return waiter;
                });
    }

    @Override
    public void save(UUID id, List<Event> handle) {
        eventStore.SaveEventsFor(id, Observable.from(handle));
    }
}
