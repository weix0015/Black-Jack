import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {

        String input;
        int playerKort = 0;
        int magicnumber = 21;
        int playerPoint = 0;
        boolean keepPlaying = true;
        int dealersKort = 0;
        int dealersPoint = 0;
        int runde = 1;

        Random random = new Random();
        Scanner sc = new Scanner(System.in);


        while (keepPlaying) {
            System.out.print("Vil du trække et kort (Skriv ja/nej): ");
            input = sc.nextLine();
            int previousValue = playerPoint;
            //System.out.println("Previous Value "+previousValue);

            if (input.equalsIgnoreCase("ja")) {
                playerKort = random.nextInt(13) + 1;
                if (playerKort >= 10) {
                    playerPoint = 10;
                }
                else if (playerKort < 10) {
                    playerPoint = playerKort;
                }
                if(runde > 1){
                    playerPoint += previousValue;
                }
                runde++;
                System.out.println("runde "+ runde);
                System.out.println("Players har trukket: " + playerKort);

                dealersKort = random.nextInt(13) + 1;
                if (dealersKort > 10) {
                    dealersPoint = 10;
                }
                else if (dealersKort < 10) {
                    dealersPoint = dealersKort;
                }
                if(runde > 1) {
                    dealersPoint += previousValue;
                }
                else if (dealersPoint >= 15 || dealersPoint >= 21) {
                    keepPlaying = false;
                }
                runde++;
                //System.out.println("runde" + runde);
                System.out.println("Computer har trukket: " + dealersKort);
                System.out.println( "din samlet score er: " + playerPoint);
                System.out.println( "computerens samlet score er: " + dealersPoint);
                if (playerPoint > magicnumber) {
                    System.out.println("player du har tabt: ");
                    keepPlaying = false;
                }
                else if (dealersPoint > magicnumber) {
                    System.out.println("player du har vundet");
                    keepPlaying = false;
                }
                if (dealersPoint == magicnumber) {
                    System.out.println("dealer du har vundet ");
                    keepPlaying = false;
                }
            }
            else if (input.equalsIgnoreCase("nej")) {
                if (playerPoint > dealersPoint) {
                    System.out.println("player du har vundet");
                } else if (playerPoint < dealersPoint) {
                    System.out.println("player du har tabt");
                } else if (playerPoint == 21 && dealersPoint == 21) {
                    System.out.println("I har begge vundet <3");
                    keepPlaying = false;
                }
                keepPlaying = false;
            }
            else {
                System.out.println("You are banned from this game! You did not follow the rules!");
                keepPlaying = false;
            }
        }
    }
}
