package Java_Homework.GLAB_303_10_4;

public class Triangle extends Shape implements Movable {
    private int x;
    private int y;

    public Triangle(String color) {
        super.color = color;
    }

    public Triangle(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void moveUp() {
        y++;
    }


    public void moveDown() {
        y--;
    }


    public void moveLeft() {
        x--;
    }


    public void moveRight() {
        x++;
    }


    public String getCoordinate() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public double getArea() {
        return 0.5*super.base * super.height;
    }
}
