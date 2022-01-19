package uz.elmurodov.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @param <B> Body
 */
@Getter
@ToString
public class Data<B> {
    public B data;
    public Long total;

    public Data(B data) {
        this(data, 0L);
    }

    public Data(B data, Long total) {
        this.data = data;
        this.total = total;
    }
}
