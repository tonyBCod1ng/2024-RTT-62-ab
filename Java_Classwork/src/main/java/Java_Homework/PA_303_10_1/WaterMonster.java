package Java_Homework.PA_303_10_1;

public class WaterMonster extends Monster {
    public WaterMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Water!";
    }
}
