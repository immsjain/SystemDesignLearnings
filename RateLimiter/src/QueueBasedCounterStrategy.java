import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class QueueBasedCounterStrategy implements RateLimitingStrategy{
    private Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();

    private class Pair<T,U>{
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond(U second) {
            this.second = second;
        }
    }

    private int limit;
    private int windowSize;

    private int frameSize;
    private int frameLimit;


    public int getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }

    public int getFrameLimit() {
        return frameLimit;
    }

    public void setFrameLimit(int frameLimit) {
        this.frameLimit = frameLimit;
    }


    public QueueBasedCounterStrategy(int limit, int windowSize) {
        this.limit = limit;
        this.windowSize = windowSize;
        setFrameLimit(limit/10);
        setFrameSize(windowSize/10);
    }

    @Override
    public boolean validate(URequest req) {
        int time = req.getTimestamp();
        int startTime = time-windowSize+1;
        while (!queue.isEmpty() && queue.peek().getSecond()<startTime){
            queue.poll();
        }
        int fstarttime = time-frameSize+1;

        if(!queue.isEmpty() && queue.getLast().getSecond()>=fstarttime){
            if(queue.getLast().getFirst()>=frameLimit){
                return false;
            }
            queue.getLast().setFirst(queue.getLast().getFirst()+1);
        }else{
            Pair<Integer,Integer>pair = new Pair<>(1,time);
            queue.offer(pair);
        }
        return true;
    }
}
