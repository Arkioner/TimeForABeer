package bar.kitchen.common.infrastructure.commandbus;

import bar.kitchen.common.domain.command.Command;
import bar.kitchen.common.domain.command.CommandBus;
import bar.kitchen.common.domain.command.CommandSubscriber;
import bar.kitchen.common.domain.event.EventSubscriber;
import bar.kitchen.common.domain.query.QuerySubscriber;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by IONER on 03/07/2016.
 */
public class InMemoryCommandBus implements CommandBus{
    private PublishSubject<Command> subject;

    public InMemoryCommandBus() {
        subject = PublishSubject.create();
    }

    public void dispatch(Command cmd) { subject.onNext(cmd);}

    public CommandBus addCommandSubscriber(CommandSubscriber subscriber) {
        subject.observeOn(Schedulers.immediate()).subscribe(subscriber);
        return this;
    }

}
