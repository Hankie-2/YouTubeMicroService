package kg.charginov.userservice.exception;

public class IncorrectData {
    private String message;
    private Integer status;

    public IncorrectData() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
