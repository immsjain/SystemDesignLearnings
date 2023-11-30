// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // user can pick any color
        // when user pick color some events can occur

        ColorPicker colorPicker = new ColorPicker();
        Lisner boundry = new BoundryColor(Color.BLACK);
        Lisner area = new InsideArea(Color.RED);
        colorPicker.addLisner(boundry,Color.ORANGE);
        colorPicker.addLisner(area,Color.GREEN);
        colorPicker.pickColor(Color.ORANGE);
        colorPicker.pickColor(Color.GREEN);

    }
}