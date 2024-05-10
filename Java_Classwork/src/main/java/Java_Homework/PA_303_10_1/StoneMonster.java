package Java_Homework.PA_303_10_1;

 class StoneMonster extends Monster {
     StoneMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Stone!";
    }
}
