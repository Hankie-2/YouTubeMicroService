package kg.charginov.videoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VideoExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> notFoundException(
            VideoNotFoundException exception){
        IncorrectData data = new IncorrectData();
        data.setMessage(exception.getMessage());
        data.setStatus(exception.getStatus());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> isExistsException(
            VideoIsExistsException exception){
        IncorrectData data = new IncorrectData();
        data.setMessage(exception.getMessage());
        data.setStatus(exception.getStatus());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

}
