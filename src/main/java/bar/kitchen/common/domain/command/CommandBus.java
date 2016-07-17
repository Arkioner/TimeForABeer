package bar.kitchen.common.domain.command;

import bar.kitchen.common.domain.event.EventSubscriber;
import bar.kitchen.common.domain.query.QuerySubscriber;

/**
 * Created by IONER on 17/07/2016.
 */
public interface CommandBus {
    void dispatch(Command cmd);

    public void addCommandSubscriber(CommandSubscriber subscriber);

    public void addQuerySubscriber(QuerySubscriber subscriber);

    public void addEventSubscriber(EventSubscriber subscriber);
}
