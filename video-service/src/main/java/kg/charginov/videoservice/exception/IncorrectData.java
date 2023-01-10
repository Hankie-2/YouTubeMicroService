package kg.charginov.videoservice.exception;

public class IncorrectData {

    private String message;
    private Integer status;

    public IncorrectData() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
