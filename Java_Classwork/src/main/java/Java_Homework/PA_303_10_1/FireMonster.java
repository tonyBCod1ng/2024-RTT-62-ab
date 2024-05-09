package Java_Homework.PA_303_10_1;

public class FireMonster extends Monster {
    public FireMonster(String idNum) {
        super(idNum);
    }

    @Override
    String attack(){
        return "Attack with Fire!";
    }
}
