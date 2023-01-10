package kg.charginov.userservice.exception;

public class UserNotFoundException extends RuntimeException {
    private Integer status;
    public UserNotFoundException(String message,Integer status){
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
