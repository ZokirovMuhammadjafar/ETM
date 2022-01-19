package uz.elmurodov.response;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.enums.HttpStatus;

import java.util.Objects;

/**
 * @param <D> response body type
 */

@Getter
@Setter
public class ResponseEntity<D> {
    private D body;
    private Integer status;

    public ResponseEntity() {
        this.status = HttpStatus.HTTP_200.getCode();
    }

    public ResponseEntity(D body) {
        this(body, HttpStatus.HTTP_200);
    }

    public ResponseEntity(D body, HttpStatus status) {
        this.body = body;
        this.status = status.getCode();
    }

    public ResponseEntity(D body, Integer code) {
        validateCode(code);
        this.body = body;
        this.status = code;
    }

    private void validateCode(Integer code) {
        HttpStatus status = HttpStatus.getStatusByCode(code);
        if (Objects.equals(status, HttpStatus.UNDEFINED)) {
            throw new RuntimeException("Code is invalid");
        }
    }
}
