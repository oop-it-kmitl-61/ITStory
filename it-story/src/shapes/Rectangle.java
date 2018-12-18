package shapes;

public class Rectangle extends Shape implements Selectable {

    // properties
    private int width, height;
    private boolean selected;

    // constructors
    public Rectangle(int width, int height) {

        this.width = width;
        this.height = height;
        selected = false;
    }

    public Rectangle(int x, int y, int width, int height) {

    }

    @Override
    public boolean getSelected() {

        return selected;
    }

    @Override
    public void setSelected(boolean selected) {

        this.selected = selected;
    }

    @Override
    public Shape contains(int x, int y) {

        if (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height) {
            return this;
        }
        return null;
    }

    @Override
    double getArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
