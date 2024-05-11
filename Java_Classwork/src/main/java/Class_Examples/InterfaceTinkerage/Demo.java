package Class_Examples.InterfaceTinkerage;

class Demo  {
    //defines a anonymous inner class
    FunctionalInterfaceDemo daFif = new FunctionalInterfaceDemo() {
        @Override
        public void say() {
            System.out.println("Sup, I'm a human.");
        }
    };
    FunctionalInterfaceDemo daForf = new FunctionalInterfaceDemo() {
        @Override

        public void say() {
            System.out.println("Sup, I'm another human.");
        }

    };


}

