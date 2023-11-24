import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowUserRateLimiter implements UserRateLimiter{
    Queue<Request>queue = new LinkedList<>();
    private int reqLimit;
    private int windowSize;
    public SlidingWindowUserRateLimiter(int reqLimit, int windowSize) {
        this.reqLimit = reqLimit;
        this.windowSize = windowSize;
    }

    @Override
    public boolean validate(Request req) {
        int allowedTimes = req.getTimestamp()-windowSize+1;
        while (!queue.isEmpty()  && (queue.peek().getTimestamp() < allowedTimes)){
            queue.poll();
        }
        if(queue.size()>=reqLimit){
            return false;
        }
        queue.offer(req);
        return  true;
    }
}
