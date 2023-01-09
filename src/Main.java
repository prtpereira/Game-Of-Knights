import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String[] args) {

        int HP = 6;
        List<Knight> activeKnights = new ArrayList<>(Arrays.asList(new Knight("1",HP), new Knight("2",HP), new Knight("3",HP)));

        int nextIdx;
        int pointsToAttack;
        int leftHP;
        int round=1;

        for (int currentIdx=0 ; activeKnights.size() > 1 ; currentIdx++) {
            System.out.println("ROUND " + round++ + " | knights status: " + knightsInfo(activeKnights));

            Knight currentKnight = activeKnights.get(currentIdx);

            nextIdx = currentIdx + 1 ;
            if (nextIdx > activeKnights.size() - 1) nextIdx = 0;

            Knight nextKnight = activeKnights.get(nextIdx);

            pointsToAttack = rollDice();

            System.out.println("Knight '" + currentKnight.name + "' is attacking knight '" + nextKnight.name + "', with HP: " + pointsToAttack);

            leftHP = nextKnight.decreaseHP(pointsToAttack);
            if (leftHP <= 0 ) {
                activeKnights.remove(nextIdx);
                System.out.println("Knight '" + nextKnight.name + "' was killed");
            }

            System.out.println();
            if (currentIdx + 1 > activeKnights.size() - 1) currentIdx = -1;
        }

        System.out.println("Knight '" + activeKnights.get(0) + " won");
    }


    public static int rollDice(){
        SecureRandom rand = new SecureRandom();
        return rand.nextInt(6);
    }

    public static String knightsInfo(List<Knight> knights) {
        return knights.stream().map(Knight::toString).toList().toString();
    }
}
