import objects.Campaign;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Campaign campaign = new Campaign();
        boolean whileloop = true;

        System.out.println("Necromunda Campaign Tracker");

        while (whileloop) {

            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            System.out.println("1)  Campaign Info");
            System.out.println("2)  Territory Info");
            System.out.println("3)  Create Territory");
            System.out.println("4)  Remove Territory");
            System.out.println("5)  Gang Info");
            System.out.println("6)  Create Gang");
            System.out.println("7)  Remove Gang");
            System.out.println("8)  Add Territory to Gang");
            System.out.println("Press Any Other key to Quit");

            System.out.print("\nWhich option:   ");

            int option = userInputMenu(keyboard);
            System.out.println();
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            switch (option) {
                case 1 -> campaign.campaignInfo();
                case 2 -> campaign.territoryInfo();
                case 3 -> createTerritory(keyboard, campaign);
                case 4 -> removeTerritory(keyboard, campaign);
                case 5 -> campaign.gangInfo();
                case 6 -> createGang(keyboard, campaign);
                case 7 -> removeGang(keyboard, campaign);

                //                   campaign.addTerritoryToGang(keyboard);
                default -> whileloop = false;
            }

        }

    }

    private static void createTerritory(Scanner keyboard, Campaign campaign) {

        System.out.println("Enter territories name:    ");
        String name = keyboard.nextLine();
        System.out.println("Enter the income: ");
        String income = keyboard.nextLine();
        System.out.println("Enter what it can recruit:  ");
        String recruit = keyboard.nextLine();
        System.out.println("Enter any equipment it gives: ");
        String equipment = keyboard.nextLine();
        System.out.println("Enter any special bonuses it provides: ");
        String special = keyboard.nextLine();
        System.out.println("Enter any reputation it can give: ");
        int reputation = userIntInput(keyboard);

        campaign.createTerritory(name, income, recruit, equipment, special, reputation);
    }

    private static void removeTerritory(Scanner keyboard, Campaign campaign) {
        System.out.print(("Enter the ID of the territory to delete:  "));
        int id = userIntInput(keyboard);
        campaign.removeTerritory(id);
    }

    private static void createGang(Scanner keyboard, Campaign campaign) {
        System.out.println("Enter player's name:    ");
        String player = keyboard.nextLine();
        System.out.println("Enter the gang's name: ");
        String name = keyboard.nextLine();
        System.out.println("Enter what type of gang it is:  ");
        String gangType = keyboard.nextLine();
        System.out.println("Enter the gangs total vale: ");
        int totalValue = userIntInput(keyboard);

        campaign.createGang(player, name, gangType, totalValue);
    }

    private static void removeGang(Scanner keyboard, Campaign campaign) {
        System.out.print(("Enter the ID of the gang to delete:  "));
        int id = userIntInput(keyboard);
        campaign.removeGang(id);
    }

    /*private static void addTerritoryToGang() {

    }*/

    private static Integer userInputMenu(Scanner keyboard) {

        int input = 0;
        try {
            input = Integer.parseInt(keyboard.nextLine());

        } catch (Exception e) {
            System.out.println("Exiting");
            System.exit(0);
        }
        return input;
    }

    private static Integer userIntInput(Scanner keyboard) {

        int input;

        try {
            input = Integer.parseInt(keyboard.nextLine());
            return input;
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
        return userIntInput(keyboard);
    }
}




