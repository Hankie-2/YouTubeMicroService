package kg.charginov.channelservice.exception;

public class IncorrectData {

    private String message;

    private Integer status;

    public IncorrectData(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
