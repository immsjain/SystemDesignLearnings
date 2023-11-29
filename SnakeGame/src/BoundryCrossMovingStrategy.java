public class BoundryCrossMovingStrategy implements SnakeMovingStrategy{
    @Override
    public boolean move(Direction dir, SnakeGame game) {
        int r = game.getCurrPos().getRow();
        int c = game.getCurrPos().getCol();
        if(dir== Direction.DOWN){
            r  = (r+1)%game.getHeight();
        }else if(dir==Direction.UP){
            r = (r-1+game.getHeight())%game.getHeight();
        }else if(dir==Direction.LEFT){
            c = (c-1+game.getWidth())%game.getWidth();
        }else if(dir==Direction.RIGHT){
            c = (c+1)%game.getWidth();
        }else{
            return false;
        }
        if((game.getFoodIdx()<game.getFoodidxs().size()) && game.getFoodidxs().get(game.getFoodIdx()).getRow()==r && game.getFoodidxs().get(game.getFoodIdx()).getCol()==c){
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
