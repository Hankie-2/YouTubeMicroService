package kg.charginov.videoservice.exception;

public class VideoNotFoundException extends RuntimeException{
    private Integer status;

    public VideoNotFoundException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
