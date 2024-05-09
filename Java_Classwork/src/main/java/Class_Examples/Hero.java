package Class_Examples;

class Hero implements PerimeterInterface {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.calculatePerimeter();
    }

    @Override
    public double calculatePerimeter() {
        System.out.println("Hello World!");
        return 0;
    }
}
