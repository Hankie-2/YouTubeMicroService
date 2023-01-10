package kg.charginov.channelservice.exception;

public class ChannelIsExistsException extends RuntimeException{
    private Integer status;
    public ChannelIsExistsException(String message,Integer status){
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
