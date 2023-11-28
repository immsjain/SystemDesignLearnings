import com.sun.net.httpserver.Request;

public interface RateLimitingStrategy {

    boolean validate(URequest req);
}
