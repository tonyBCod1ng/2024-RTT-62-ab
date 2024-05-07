package Class_Examples;

import org.w3c.dom.ranges.Range;

 class SwitchGears {
    static int num = 3;

    public static void main(String[] args) {
        switchBlade();
    }

    public static void switchBlade() {

        switch (num) {
            case 0:
                System.out.println("Bladerunner");
                break;
            case 1:
                System.out.println("Switch foot");
                break;
            case 2:
                System.out.println("Blade Trinity");
                break;
            default:
                System.out.println("No blade found");
        }
    }
}
