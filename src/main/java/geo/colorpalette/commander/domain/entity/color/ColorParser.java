package geo.colorpalette.commander.domain.entity.color;

import rx.Observable;

/**
 * Created by IONER on 03/07/2016.
 */
public interface ColorParser<T> {
    public Observable<T> encodeColor(Color color);
    public Observable<Color> decodeColor(T colorInfo, String name);
}
