package vn.hoangptit.tiger.message;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create file ErrorMessage
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
}
