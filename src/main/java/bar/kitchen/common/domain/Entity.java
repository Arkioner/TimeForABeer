package bar.kitchen.common.domain;

import java.util.UUID;

/**
 * Created by IONER on 17/07/2016.
 */
public abstract class Entity {
    private UUID id;

    public Entity(UUID id) {
        this.id = id != null ? id : UUID.randomUUID();
    }

    public UUID id() {
        return id;
    }
}
