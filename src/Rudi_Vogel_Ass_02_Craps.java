import java.util.Random;
import java.util.Scanner;

public class Rudi_Vogel_Ass_02_Craps {
    public static void main(String[] args) {
        String NewGame = "";
        boolean rollAgain = true;
        boolean blockVal = true;
        boolean PlayAgain = true;
        int firstDie = 0;
        int secondDie = 0;
        int puckVal = 0;
        int pointOne = 0;
        int pointTwo = 0;
        int playerRoll = 0;
        Random roll = new Random();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Do you want to play Craps? [Y/N]");
            if (in.hasNextLine()) {
                NewGame = (in.nextLine());
                if (NewGame.equalsIgnoreCase("Y")) {
                    blockVal = true;
                }
                else if (NewGame.equalsIgnoreCase("N")) {
                    System.out.println("Okay. Maybe Next Time");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid Entry. Please Select [Y/N]");
                    blockVal = false;
                }
            }
        }
        while (!blockVal);
        do {
            System.out.println("Lets go! You are the shooter. Press [R] to shoot the Come Out Roll.");
            do {
                if (in.hasNextLine()) {
                    NewGame = (in.nextLine());
                    if (NewGame.equalsIgnoreCase("R")) {
                        blockVal = true;
                    }
                    else {
                        System.out.println("Invalid Entry. Please Select [R] to roll.");
                        blockVal = false;
                    }
                }
            }
            while (!blockVal);
            firstDie = roll.nextInt(6) + 1;
            secondDie = roll.nextInt(6) + 1;
            puckVal = firstDie + secondDie;
            switch (puckVal) {
                case (2), (3), (12) -> {
                    System.out.println("You rolled a " + firstDie + " and a " + secondDie + ". Your roll is a " + puckVal + " That is Craps. You lose!");
                    puckVal = 13;
                }
                case (7), (11) -> {
                    System.out.println("You rolled a " + firstDie + " and a " + secondDie + ". Your roll is a Natural " + puckVal + " You win!");
                    puckVal = 13;
                }
                default ->
                        System.out.println("You rolled a " + firstDie + " and a " + secondDie + ". The Point is now " + puckVal + ".");
            }
            do {
                if (puckVal <= 12) {
                    System.out.println("Press [R] to roll for the Point.");
                    do {
                        if (in.hasNextLine()) {
                            NewGame = (in.nextLine());
                            if (NewGame.equalsIgnoreCase("R")) {
                                blockVal = true;
                            }
                        else {
                                System.out.println("Invalid Entry. Please Select [R] to roll.");
                                blockVal = false;
                            }
                        }
                    }
                    while (!blockVal);
                    pointOne = roll.nextInt(6) + 1;
                    pointTwo = roll.nextInt(6) + 1;
                    playerRoll = pointOne + pointTwo;
                    if (playerRoll == puckVal) {
                        System.out.println("You rolled a " + pointOne + " and a " + pointTwo + ". Your roll hit the Point " + playerRoll + ". You win!");
                        puckVal = 13;
                        rollAgain = true;
                    }
                    else if (playerRoll == 7) {
                        System.out.println("You rolled a " + pointOne + " and a " + pointTwo + ". You rolled a " + playerRoll + ". You lose!");
                        puckVal = 13;
                        rollAgain = true;
                    }
                    else {
                        System.out.println("You rolled a " + pointOne + " and a " + pointTwo + ". Your roll is a " + playerRoll + ". The Point is " + puckVal +  ".");
                        rollAgain = false;
                    }
                }
            }
            while (!rollAgain);
            System.out.println("Do you want to play again? [Y/N]");
            do {
                if (in.hasNextLine()) {
                    NewGame = (in.nextLine());
                    if (NewGame.equalsIgnoreCase("Y")) {
                        blockVal = true;
                        PlayAgain = false;
                        }
                    else if (NewGame.equalsIgnoreCase("N")) {
                        System.out.println("Okay. Maybe Next Time");
                        System.exit(0);
                        }
                    else {
                        System.out.println("Invalid Entry. Please Select [Y/N]");
                        blockVal = false;
                        }
                    }
                }
                while (!blockVal);
        }
        while (!PlayAgain);
    }
}

