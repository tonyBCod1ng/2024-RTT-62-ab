package Class_Examples.SBAPrax2;

import java.text.DecimalFormat;
import java.util.Arrays;

interface Sport {
    void calculateAvgAge(int[] age);

    void retirePlayer(int id);
}

class Main {
    static Cricket cricket4 = new Cricket();
    static FootBall footBall4 = new FootBall();

    public static void main(String[] args) {
        int[] ageArray = {23, 32, 54, 67, 78, 40, 33};

        cricket4.retirePlayer(3);
        cricket4.calculateAvgAge(ageArray);
        cricket4.retirePlayer(4);
        cricket4.retirePlayer(4);
        footBall4.retirePlayer(3);
        footBall4.playerTransfer(300, 3);
        footBall4.playerTransfer(300, 3);
        footBall4.retirePlayer(3);


    }
}

class Cricket implements Sport {
    private final int[] playerIds;

    Cricket() {
        playerIds = new int[11];

        for (int player = 1; player < playerIds.length; player++) {
            playerIds[player] = 1;
        }
        System.out.println("A new team has formed");
    }

    @Override
    public void calculateAvgAge(int[] age) {
        int result = 0;
        for (int player = 0; player < age.length; player++) {
            result += age[player];
        }
        double avg = (double) result / (double) age.length;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("The average age of the team is " + decimalFormat.format(avg));
    }

    @Override
    public void retirePlayer(int id) {

        if (playerIds[id - 1] == -1) {
            System.out.println("Player " + id + " has already retired");
        } else {

            System.out.println("Player " + id + " has been retired");
            playerIds[id - 1] = -1;
        }

    }

}

class FootBall implements Sport {
    private final int[] playerIds;

    FootBall() {
        playerIds = new int[11];
        for (int player = 0; player < playerIds.length; player++) {
            playerIds[player] = 1;
        }
        System.out.println("new football team has formed");
    }
    @Override
    public void calculateAvgAge(int[] age) {
        int result = 0;
        for (int player = 0; player < age.length; player++) {
            result += age[player];
        }
        double avg = (double) result / (double) age.length;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("The average age of the team is " + decimalFormat.format(avg));
    };
    @Override
    public void retirePlayer(int id) {

        if (playerIds[id - 1] == -1) {
            System.out.println("Player " + id + " has already retired");
        } else {

            System.out.println("Player " + id + " has been retired");
            playerIds[id - 1] = -1;
        }

    };
    public void playerTransfer(int fee, int id) {
        System.out.println(Arrays.toString(playerIds));
        if (playerIds[id - 1] == -1) {
            System.out.println("Player " + id + " is already retired");

        } else {
            System.out.println("Player with id " + id + " has been transferred for a fee of " + fee);
            playerIds[id - 1] = -1;
        }
    }

}

