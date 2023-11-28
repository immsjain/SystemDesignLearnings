import com.sun.net.httpserver.Request;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasedStrategy implements RateLimitingStrategy{
    private Queue<URequest>queue = new LinkedList<>();
    private int limit;
    private int windowSize;

    public QueueBasedStrategy(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
    }

    @Override
    public boolean validate(URequest req) {
        int time = req.getTimestamp();
        int startTime = time-windowSize+1;
        while (!queue.isEmpty() && queue.peek().getTimestamp()<startTime){
            queue.poll();
        }
        if(queue.size()>=limit){
            return false;
        }
        queue.offer(req);
        return true;
    }
}
