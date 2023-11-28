import com.sun.net.httpserver.Request;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private int limit;
    private int windowSize;

    private static RateLimiter instance = null;
    private Map<User,UserRatelimiter>map = new HashMap<>();

    private RateLimiter(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }

    public static RateLimiter getInstance(int limit,int windowSize){
        if(instance==null){
            synchronized (RateLimiter.class){
                if(instance==null){
                    instance = new RateLimiter(limit,windowSize);
                }
            }
        }
        return instance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public boolean validate(URequest request){
        User user = request.getUser();
        if(!map.containsKey(user)){
            addNewUser(user);
        }
        UserRatelimiter userRatelimiter = map.get(user);
        return userRatelimiter.validate(request);
    }

    public void addNewUser(User user){
        UserRatelimiter userRatelimiter = new SlidingWindowRateLimiter(new QueueBasedCounterStrategy(limit,windowSize),limit,windowSize);
        map.put(user,userRatelimiter);
        return;
    }
}
