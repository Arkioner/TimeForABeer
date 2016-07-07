package geo.colorpalette.commander.application.service.color.register;

import geo.colorpalette.commander.domain.entity.color.Color;
import geo.colorpalette.commander.domain.entity.color.ColorStore;
import rx.Observable;

/**
 * Created by IONER on 03/07/2016.
 */
public class RegisterColorUseCase {

    private ColorStore colorStore;

    public RegisterColorUseCase(ColorStore colorStore) {
        this.colorStore = colorStore;
    }

    public Observable<Color> toObservable(RegisterColorCommand registerColorCommand) {
        return Observable.fromCallable(() -> registerColorCommand)
                .flatMap(this::instantiateColor)
                .flatMap(colorStore::save)
                ;
    }

    private Observable<Color> instantiateColor(RegisterColorCommand registerColorCommand) {
        return Observable.fromCallable(() ->
                new Color(
                        registerColorCommand.name(),
                        registerColorCommand.red(),
                        registerColorCommand.green(),
                        registerColorCommand.blue()
                )
        );
    }
}
