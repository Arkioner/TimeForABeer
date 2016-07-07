package geo.colorpalette.commander.domain.entity.color;

/**
 * Created by IONER on 03/07/2016.
 */
public class InvalidColorException extends RuntimeException {
    public InvalidColorException(String message) {
        super(message);
    }
}
