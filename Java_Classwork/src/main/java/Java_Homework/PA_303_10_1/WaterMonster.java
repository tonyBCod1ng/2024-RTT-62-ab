package Java_Homework.PA_303_10_1;

 class WaterMonster extends Monster {
     WaterMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Water!";
    }
}
