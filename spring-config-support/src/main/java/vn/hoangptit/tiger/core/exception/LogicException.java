package vn.hoangptit.tiger.core.exception;

/**
 * Create file LogicException
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
public class LogicException extends RuntimeException{
    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
