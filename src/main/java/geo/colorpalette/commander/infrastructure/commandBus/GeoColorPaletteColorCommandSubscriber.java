package geo.colorpalette.commander.infrastructure.commandBus;

import geo.colorpalette.commander.application.service.color.ColorCommandHandler;
import geo.colorpalette.commander.domain.command.CommandSubscriber;
import geo.colorpalette.commander.domain.command.color.ColorCommand;
import rx.Observable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by IONER on 05/07/2016.
 */
public class GeoColorPaletteColorCommandSubscriber extends CommandSubscriber<ColorCommand> {

    private ColorCommandHandler colorCommandHandler;

    public GeoColorPaletteColorCommandSubscriber(ColorCommandHandler colorCommandHandler) {
        this.colorCommandHandler = colorCommandHandler;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(ColorCommand cmd) {
        System.out.println(cmd.getClass().getCanonicalName());
        try {
            ((Observable<Void>)(colorCommandHandler.getClass().getMethod("process", new Class[]{cmd.getClass()}).invoke(colorCommandHandler, cmd)))
                    .subscribe();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
