package kg.charginov.videoservice.exception;

public class VideoIsExistsException extends RuntimeException{
    private Integer status;
    public VideoIsExistsException(String message,Integer status){
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
