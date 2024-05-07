package Class_Examples;

 class EnumEx {
    public static void main(String[] args) {
        Car car = Car.BMW;
        switch (car) {
            case BMW:
                System.out.println("BMW");
                break;
            case AUDI:
                System.out.println("Audi");
                break;
            case JEEP:
                System.out.println("Jeep");
                break;
            case VOLKSWAGON:
                System.out.println("Volkswagon");
                break;
            case NANO:
                System.out.println("Nano");
                break;
            case FIAT:
                System.out.println("Fiat");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    enum Car {
        BMW, AUDI, JEEP, VOLKSWAGON, NANO, FIAT
    }
}
