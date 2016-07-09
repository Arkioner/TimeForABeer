package bar.kitchen.common.domain.query;

import rx.Observable;

/**
 * Created by IONER on 05/07/2016.
 */
public interface Query<T> {
    void setResponse(Observable<T> response);
}
