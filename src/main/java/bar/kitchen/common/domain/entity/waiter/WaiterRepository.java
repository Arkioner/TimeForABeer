package bar.kitchen.common.domain.entity.waiter;

import bar.kitchen.common.domain.event.Event;
import rx.Observable;

import java.util.List;
import java.util.UUID;

public interface WaiterRepository {
    public Observable<Waiter> getById(UUID id);

    void save(UUID id, List<Event> handle);
}
