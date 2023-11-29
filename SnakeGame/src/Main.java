import java.util.LinkedList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SnakeGame snakeGame = SnakeGame.getBuilder().addCurrentPos(0,0)
                .setStrategy(new BoundryCrossMovingStrategy())
                .addHeight(5)
                .addWidht(5)
                .build();
        if(snakeGame.addFood(new Cell(2,3))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }

        if(snakeGame.addFood(new Cell(1,1))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }

        if(snakeGame.addFood(new Cell(3,4))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }

        if(snakeGame.addFood(new Cell(4,4))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }

        if(snakeGame.addFood(new Cell(2,4))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }

        if(snakeGame.addFood(new Cell(3,2))){
            System.out.println("food is added successfully");
        }else{
            System.out.println("food cant be added");
        }
        Direction lastMoveDir= Direction.RIGHT;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println(snakeGame.getQueue());
            System.out.println("Current Position: " + snakeGame.getCurrPos().getRow() + ", "+ snakeGame.getCurrPos().getCol());
            System.out.print("Enter Direction : ");
            String userInput = scanner.nextLine();
            System.out.println("You entered direction: " + userInput);
            if(userInput.equals("L")){
                lastMoveDir = Direction.LEFT;
            }else if(userInput.equals("R")){
                lastMoveDir = Direction.RIGHT;
            }else if(userInput.equals("U")){
                lastMoveDir = Direction.UP;
            }else if(userInput.equals("D")){
                lastMoveDir = Direction.DOWN;
            }


        }while (snakeGame.move(lastMoveDir));
        scanner.close();

        System.out.println("your score: " + snakeGame.getScore());

    }
}