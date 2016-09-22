package bar.kitchen.common.domain.entity.waiter.event;

import bar.kitchen.common.domain.event.Event;

import java.util.UUID;

public class WaiterHired implements Event{

    private final UUID id;
    private final String name;

    public WaiterHired(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }
}
