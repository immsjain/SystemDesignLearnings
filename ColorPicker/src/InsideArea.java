public class InsideArea implements Lisner{
    private Color color;

    public InsideArea(Color color) {
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
        System.out.println("Inside area in now: " + color);
    }
}
