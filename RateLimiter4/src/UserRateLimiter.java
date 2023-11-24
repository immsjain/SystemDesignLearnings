public interface UserRateLimiter {
    boolean validate(Request req);
}
