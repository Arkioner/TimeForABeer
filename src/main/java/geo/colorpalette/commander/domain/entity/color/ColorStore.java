package geo.colorpalette.commander.domain.entity.color;

import rx.Observable;

/**
 * Created by IONER on 03/07/2016.
 */
public interface ColorStore {
    Observable<Color> save(Color color);
    Observable<Color> find(String name);
}
