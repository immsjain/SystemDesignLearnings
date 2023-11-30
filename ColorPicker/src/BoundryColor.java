public class BoundryColor implements Lisner{
    private Color color;

    public BoundryColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void listen(Color color) {
        this.color = color;
        System.out.println("All boundries are now: " + color.toString());
        return;
    }
}
