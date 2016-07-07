package geo.colorpalette.commander.application.service.color;

import geo.colorpalette.commander.application.service.color.register.RegisterColorUseCase;
import geo.colorpalette.commander.application.service.color.register.RegisterColorCommand;
import geo.colorpalette.commander.domain.entity.color.Color;
import rx.Observable;

/**
 * Created by IONER on 03/07/2016.
 */
public class ColorCommandHandler {
    private RegisterColorUseCase registerColorUseCase;

    public ColorCommandHandler(RegisterColorUseCase registerColorUseCase) {
        this.registerColorUseCase = registerColorUseCase;
    }

    public Observable<Color> process(RegisterColorCommand registerColorCommand) {
        return registerColorUseCase.toObservable(registerColorCommand);
    }
}
