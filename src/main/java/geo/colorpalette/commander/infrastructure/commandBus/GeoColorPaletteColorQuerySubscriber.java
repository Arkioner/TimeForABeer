package geo.colorpalette.commander.infrastructure.commandBus;

import geo.colorpalette.commander.application.service.color.ColorQueryHandler;
import geo.colorpalette.commander.application.model.color.ColorQuery;
import geo.colorpalette.commander.domain.query.QuerySubscriber;
import rx.Observable;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by IONER on 05/07/2016.
 */
public class GeoColorPaletteColorQuerySubscriber extends QuerySubscriber<ColorQuery> {

    private ColorQueryHandler colorQueryHandler;

    public GeoColorPaletteColorQuerySubscriber(ColorQueryHandler colorQueryHandler) {
        this.colorQueryHandler = colorQueryHandler;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(ColorQuery cmd) {
        System.out.println(cmd.getClass().getCanonicalName());
        try {
            cmd.setResponse(((Observable<?>)(colorQueryHandler.getClass().getMethod("process", new Class[]{cmd.getClass()}).invoke(colorQueryHandler, cmd))));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            cmd.setResponse(Observable.error(e));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            cmd.setResponse(Observable.error(e));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            cmd.setResponse(Observable.error(e));
        }
    }
}
