package Java_Homework.PA_303_10_1;

public class StoneMonster extends Monster {
    public StoneMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Stone!";
    }
}
