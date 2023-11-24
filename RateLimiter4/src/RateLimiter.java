import java.util.HashMap;

public class RateLimiter {
    private HashMap<User,UserRateLimiter>map = new HashMap<>();
    private static RateLimiter instance=null;
    private int defaultLimit;
    private int defaultWindowSize;

    private RateLimiter(int defaultLimit, int defaultWindowSize) {
        this.defaultLimit = defaultLimit;
        this.defaultWindowSize = defaultWindowSize;
    }

    public static RateLimiter getInstance(int limit,int ws){
        if(instance==null){
            synchronized(RateLimiter.class) {
                if (instance == null) {
                    instance = new RateLimiter(limit, ws);
                }
            }
        }
        return instance;
    }

    public boolean validate(Request req){
        User user = req.getUser();
        if(!map.containsKey(user)){
            addNewUser(user);
        }
        UserRateLimiter userRateLimiter = map.get(user);
        return userRateLimiter.validate(req);
    }

    public void addNewUser(User user){
        map.put(user, new SlidingWindowUserRateLimiter(defaultLimit,defaultWindowSize));
    }

}
