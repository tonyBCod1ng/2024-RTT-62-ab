package Java_Homework.GLAB_303_10_3;

 class Circle extends Shape {
    protected double radius;
    private final double PI = Math.PI;

     Circle(double radius) {
        this.radius = radius;
    }

     Circle(double radius, double height) {
        this.radius = radius;
        super.height = height;
    }
    public double getArea() {
        //double area = PI * this.radius * this.radius;
        double area = PI * Math.pow(this.radius, 2); // initializing value in parent class variable
        return area; //reference to  parent class variable
    }
    @Override
    public void displayShapeName() {
        System.out.println("Drawing a Circle of radius " + this.radius);
    }
    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Circle[ radius = " + radius + super.toString() + "]";
    }


}
