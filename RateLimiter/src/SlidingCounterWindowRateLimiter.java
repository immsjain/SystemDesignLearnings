public class SlidingCounterWindowRateLimiter implements UserRatelimiter{

    RateLimitingStrategy rateLimitingStrategy;

    public SlidingCounterWindowRateLimiter(RateLimitingStrategy rateLimitingStrategy) {
        this.rateLimitingStrategy = rateLimitingStrategy;
    }

    @Override
    public boolean validate(URequest req) {
        return rateLimitingStrategy.validate(req);
    }
}
