package kg.charginov.channelservice.exception;

public class ChannelNotFoundException extends RuntimeException{
    private Integer status;
    public ChannelNotFoundException(String message,Integer status){
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
