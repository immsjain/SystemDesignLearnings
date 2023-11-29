import java.util.*;

public class SnakeGame {
    private Cell currPos;
    private int width;
    private int height;
    private int foodIdx;
    private int score;

    private SnakeMovingStrategy snakeMovingStrategy;
    private Queue<Cell>queue = new LinkedList<>();

    private List<Cell>foodidxs = new LinkedList<>();

    private Set<Cell> blocked = new HashSet<>();

    private SnakeGame(Cell currPos, int width, int height, List<Cell> foodidxs, SnakeMovingStrategy snakeMovingStrategy) {
        this.currPos = currPos;
        this.width = width;
        this.height = height;
        this.foodidxs = foodidxs;
        this.score = 0;
        this.foodIdx=0;
        this.snakeMovingStrategy = snakeMovingStrategy;
    }

    public static SnakeGameBuilder getBuilder(){
        return new SnakeGameBuilder();
    }

    public static class SnakeGameBuilder{
        private Cell currPos;
        private int width;
        private int height;
        private SnakeMovingStrategy snakeMovingStrategy;

        public SnakeGameBuilder addCurrentPos(int row,int col){
            Cell cell = new Cell(row,col);
            currPos = cell;
            return this;
        }

        public SnakeGameBuilder addWidht(int widht){
            this.width = widht;
            return this;
        }

        public SnakeGameBuilder addHeight(int h){
            this.height = h;
            return this;
        }

        public SnakeGameBuilder setStrategy(SnakeMovingStrategy strategy){
            this.snakeMovingStrategy = strategy;
            return this;
        }

        public SnakeGame build(){
            SnakeGame snakeGame = new SnakeGame(this.currPos,this.width,this.height,new LinkedList<>(),snakeMovingStrategy);
            return snakeGame;
        }

    }

    public Cell getCurrPos() {
        return currPos;
    }

    public void setCurrPos(Cell currPos) {
        this.currPos = currPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getFoodIdx() {
        return foodIdx;
    }

    public void setFoodIdx(int foodIdx) {
        this.foodIdx = foodIdx;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Queue<Cell> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Cell> queue) {
        this.queue = queue;
    }

    public List<Cell> getFoodidxs() {
        return foodidxs;
    }

    public void setFoodidxs(List<Cell> foodidxs) {
        this.foodidxs = foodidxs;
    }

    public Set<Cell> getBlocked() {
        return blocked;
    }

    public void setBlocked(Set<Cell> blocked) {
        this.blocked = blocked;
    }

    public synchronized boolean move(Direction dir){
        return snakeMovingStrategy.move(dir,this);
    }

    public boolean addFood(Cell cell){
        if(blocked.contains(cell)){
            return false;
        }
        foodidxs.add(cell);
        return true;
    }

}
