import objects.Campaign;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Campaign campaign = new Campaign();


        System.out.println("Necromunda Campaign Tracker");

        while (true) {

            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            System.out.println("1)  Campaign Info");
            System.out.println("2)  Territory Info");
            System.out.println("3)  Create Territory");
            System.out.println("4)  Remove Territory");
            System.out.println("5)  Gang Info");
            System.out.println("6)  Create Gang");
            System.out.println("7)  Remove Gang");
            System.out.println("8) Quit");

            System.out.print("\nWhich option:   ");

            int option = keyboard.nextInt();
            System.out.println();

            if (option == 1) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                campaign.campaignInfo();

            } else if (option == 2) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                campaign.territoryInfo();

            } else if (option == 3) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

                System.out.println("Enter territories name:    ");
                String usless = keyboard.nextLine();
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
                int reputation = keyboard.nextInt();

                campaign.createTerritory(name, income, recruit, equipment, special, reputation);

            } else if (option == 4) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                System.out.print(("Enter the ID of the territory to delete:  "));
                int id = keyboard.nextInt();
                campaign.removeTerritory(id);

            } else if (option == 5) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                campaign.gangInfo();

            } else if (option == 6) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

                System.out.println("Enter player's name:    ");
                String useless = keyboard.nextLine();
                String player = keyboard.nextLine();
                System.out.println("Enter the gang's name: ");
                String name = keyboard.nextLine();
                System.out.println("Enter what type of gang it is:  ");
                String gangType = keyboard.nextLine();
                System.out.println("Enter the gangs total vale: ");
                int totalValue = keyboard.nextInt();

                campaign.createGang(player, name, gangType, totalValue);

            } else if (option == 7) {

                System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                System.out.print(("Enter the ID of the gang to delete:  "));
                int id = keyboard.nextInt();
                campaign.removeGang(id);

            } else if (option == 8) {

                break;

            }


        }


    }


}


