package vn.hoangptit.tiger.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import vn.hoangptit.tiger.message.ErrorMessage;

/**
 * Create file ApiExceptionHandler
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    // Exception sẽ được handler khi trên @RestController có throw ra exception IndexOutOfBoundsException
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage indexOutOfBound(Exception ex, WebRequest wr) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
