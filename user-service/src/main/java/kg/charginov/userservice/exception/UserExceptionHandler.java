package kg.charginov.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> notFoundException(
            UserNotFoundException exception){
        IncorrectData e = new IncorrectData();
        e.setMessage(exception.getMessage());
        e.setStatus(exception.getStatus());

        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

}
