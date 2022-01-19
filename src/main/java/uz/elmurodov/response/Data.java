package uz.elmurodov.response;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @param <B> Body
 */
@Getter
@ToString
public class Data<B extends Serializable> {
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
