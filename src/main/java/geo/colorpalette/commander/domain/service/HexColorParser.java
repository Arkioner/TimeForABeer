package geo.colorpalette.commander.domain.service;


import geo.colorpalette.commander.domain.entity.color.Color;
import geo.colorpalette.commander.domain.entity.color.ColorParser;
import rx.Observable;

/**
 * Created by IONER on 03/07/2016.
 */
public class HexColorParser implements ColorParser<String> {
    public Observable<String> encodeColor(Color color) {
        return Observable.create(subscriber -> {
            String redHex = Integer.toString(color.red(), 16);
            String greenHex = Integer.toString(color.green(), 16);
            String blueHex = Integer.toString(color.blue(), 16);
            subscriber.onNext(redHex + greenHex + blueHex);
            subscriber.onCompleted();
        });
    }

    public Observable<Color> decodeColor(String colorInfo, String name) {
        return Observable.create(subscriber -> {
            Color color = new Color(
                    name, Integer.valueOf(colorInfo.substring(1, 3), 16),
                    Integer.valueOf(colorInfo.substring(3, 5), 16),
                    Integer.valueOf(colorInfo.substring(5, 7), 16)
            );
            subscriber.onNext(color);
            subscriber.onCompleted();
        });

    }
}
