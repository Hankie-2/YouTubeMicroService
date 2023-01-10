package kg.charginov.channelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChannelExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> notFoundException(
            ChannelNotFoundException exception){
        IncorrectData e = new IncorrectData();
        e.setMessage(exception.getMessage());
        e.setStatus(exception.getStatus());

        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> isExistsException(
            ChannelIsExistsException exception){
        IncorrectData e = new IncorrectData();
        e.setMessage(exception.getMessage());
        e.setStatus(exception.getStatus());

        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

}
