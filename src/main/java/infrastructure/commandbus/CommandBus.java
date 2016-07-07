package infrastructure.commandbus;

import geo.colorpalette.commander.domain.command.Command;
import geo.colorpalette.commander.domain.command.CommandSubscriber;
import geo.colorpalette.commander.domain.query.QuerySubscriber;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by IONER on 03/07/2016.
 */
public class CommandBus {
    private PublishSubject<Command> subject;

    public CommandBus() {
        subject = PublishSubject.create();
    }

    public void dispatch(Command cmd) { subject.onNext(cmd);}

    public void addCommandSubscriber(CommandSubscriber subscriber) {
        subject.observeOn(Schedulers.computation()).subscribe(subscriber);
    }

    public void addQuerySubscriber(QuerySubscriber subscriber) {
        subject.observeOn(Schedulers.immediate()).subscribe(subscriber);
    }
}
