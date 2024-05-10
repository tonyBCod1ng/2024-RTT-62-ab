package Java_Homework.PA_303_10_1;

 class FireMonster extends Monster {
     FireMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Fire!";
    }
}
