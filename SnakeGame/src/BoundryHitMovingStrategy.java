public class BoundryHitMovingStrategy implements SnakeMovingStrategy{


    @Override
    public boolean move(Direction dir, SnakeGame game) {
        int r = game.getCurrPos().getRow();
        int c = game.getCurrPos().getCol();
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
        if(r<0 || r>= game.getHeight() || c<0 || c>= game.getWidth()){
            return false;
        }else if((game.getFoodIdx()<game.getFoodidxs().size()) && game.getFoodidxs().get(game.getFoodIdx()).getRow()==r && game.getFoodidxs().get(game.getFoodIdx()).getCol()==c){
            game.setScore(game.getScore()+1);
            game.setFoodIdx(game.getFoodIdx()+1);
            System.out.println("Got food ");
            System.out.println("Score: " + game.getScore());
        }else{
            game.getBlocked().remove(game.getQueue().peek());
            game.getQueue().poll();
        }

        Cell cell = new Cell(r,c);
        if(game.getBlocked().contains(cell)){
            return false;
        }
        game.getQueue().offer(cell);
        game.getBlocked().add(cell);
        game.setCurrPos(cell);
        return true;
    }
}
