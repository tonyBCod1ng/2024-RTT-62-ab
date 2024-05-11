package Class_Examples.InterfaceTinkerage;

 class MyRunner {
     public static void main(String[] args) {
         Demo demo = new Demo();
         demo.daFif.say();
         demo.daForf.say();
         demo.daForf.sleep();
         demo.daFif.sleep();

         //any static method can be called without instantiation
         FunctionalInterfaceDemo.sayHello();
     }
}
