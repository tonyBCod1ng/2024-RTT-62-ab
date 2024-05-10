package Java_Homework.GLAB_303_10_4;

class Rectangle extends Shape implements Movable {
    private int x;
    private int y;

    public Rectangle(String color, int x, int y) {
        super.color = color;

    }

    public Rectangle(int x, int y) {

    }

    public Rectangle(String color, double width, double height, int x, int y) {
        super.height = height;
        super.width = width;
        super.color = color;
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
        return height * width;
    }
}
