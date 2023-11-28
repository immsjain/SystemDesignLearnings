import java.util.*;

public class SnakeGame {
    private Cell currPos;
    private int width;
    private int height;
    private int foodIdx;
    private int score;
    private Queue<Cell>queue = new LinkedList<>();

    private List<Cell>foodidxs = new LinkedList<>();

    private Set<Cell> blocked = new HashSet<>();

    private SnakeGame(Cell currPos, int width, int height, List<Cell> foodidxs) {
        this.currPos = currPos;
        this.width = width;
        this.height = height;
        this.foodidxs = foodidxs;
        this.score = 0;
        this.foodIdx=0;
    }

    public static SnakeGameBuilder getBuilder(){
        return new SnakeGameBuilder();
    }

    public static class SnakeGameBuilder{
        private Cell currPos;
        private int width;
        private int height;

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

        public SnakeGame build(){
            SnakeGame snakeGame = new SnakeGame(this.currPos,this.width,this.height,new LinkedList<>());
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

    public boolean move(Direction dir){
        int r = currPos.getRow();
        int c = currPos.getCol();
        if(dir== Direction.DOWN){
            r++;
        }else if(dir==Direction.UP){
            r--;
        }else if(dir==Direction.LEFT){
            c--;
        }else if(dir==Direction.RIGHT){
            c++;
        }else{
            return false;
        }
        if(r<0 || r>=height || c<0 || c>=width){
            return false;
        }else if((foodIdx<foodidxs.size()) && foodidxs.get(foodIdx).getRow()==r && foodidxs.get(foodIdx).getCol()==c){
            this.score++;
            foodIdx++;
        }else{
            blocked.remove(queue.peek());
            queue.poll();
        }
        Cell cell = new Cell(r,c);
        queue.offer(cell);
        blocked.add(cell);
        currPos = cell;
        return true;
    }

    public boolean addFood(Cell cell){
        if(blocked.contains(cell)){
            return false;
        }
        foodidxs.add(cell);
        return true;
    }

}
