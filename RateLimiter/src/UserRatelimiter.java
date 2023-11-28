import com.sun.net.httpserver.Request;

public interface UserRatelimiter {
    boolean validate(URequest req);
}
