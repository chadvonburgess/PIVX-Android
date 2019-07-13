package pivx.org.pivxwallet.rate;

/**
 * Created by furszy on 7/5/17.
 */
public class RequestN8VRateException extends Exception {
    public RequestN8VRateException(String message) {
        super(message);
    }

    public RequestN8VRateException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestN8VRateException(Exception e) {
        super(e);
    }
}
