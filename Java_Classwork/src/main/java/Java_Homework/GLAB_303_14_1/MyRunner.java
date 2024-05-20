package Java_Homework.GLAB_303_14_1;

 class MyRunner {
     public static void main(String[] args) {
         NormalClass mObj = new NormalClass();
         mObj.hObjone.say(true);
         mObj.hObjTwo.say(true);
         mObj.hObjone.sleep();
         mObj.hObjTwo.sleep();
         Human hmnBng = status -> System.out.println(status ? "I'm up!! *Lambda*" : "I'm not up!! *Lambda*");
         hmnBng.say(true);
         //lambda with one parameter
         Human hmnBng2 = status -> System.out.println(status ? "I'm up Too!! *Lambda*" : "I'm not up Too!! *Lambda*");
         hmnBng2.say(false);

     }
}
