import com.sun.net.httpserver.Request;

import java.util.Queue;

public class SlidingWindowRateLimiter implements UserRatelimiter{
    private RateLimitingStrategy rateLimitingStrategy;
    private int userLimit;
    private int userWindowSize;

    public SlidingWindowRateLimiter(RateLimitingStrategy rateLimitingStrategy, int userLimit, int userWindowSize) {
        this.rateLimitingStrategy = rateLimitingStrategy;
        this.userLimit = userLimit;
        this.userWindowSize = userWindowSize;
    }

    @Override
    public boolean validate(URequest req) {
        return rateLimitingStrategy.validate(req);
    }
}
