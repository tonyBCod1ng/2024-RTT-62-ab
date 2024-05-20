package Java_Homework.GLAB_303_14_1;

 class NormalClass {
    /* Define an anonymous inner class implementing the interface.*/
    /*Construct an instance and invoke the method. */
    /* anonymous constructor one */
    Human hObjone = new Human() {
        @Override
        public void say(boolean status) {
            System.out.println("I'm a human");
        }
    };
    /* anonymous constructor two */
    Human hObjTwo = new Human() {
        @Override
        public void say(boolean status) {
            System.out.println("I'm a human");
        }
    };
}
