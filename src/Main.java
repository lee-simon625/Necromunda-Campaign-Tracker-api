import objects.Campaign;


import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Campaign campaign = new Campaign();
        boolean whileLoop = true;

        System.out.println("Necromunda Campaign Tracker");
        campaign.initialiseTerritories();
        campaign.createGang("Simon", "Three Arms", "Genestealer Cult", 1000);
        campaign.createGang("Dom", "Gangsters", "Delaque", 1000);

        while (whileLoop) {

            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            System.out.println("1)  Campaign Info");
            System.out.println("2)  Territory Info");
            System.out.println("3)  Create Territory");
            System.out.println("4)  Remove Territory");
            System.out.println("5)  Gang Info");
            System.out.println("6)  Create Gang");
            System.out.println("7)  Remove Gang");
            System.out.println("8)  Add Territory to Gang");
            System.out.println("9)  Move Territory to Gang");
            System.out.println("Press Any Other key to Quit");

            System.out.print("\nWhich option:   ");

            int option = userInputMenu(keyboard);
            System.out.println();
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
            switch (option) {
                case 1 -> campaign.campaignInfo();
                case 2 -> campaign.territoryInfo();
                case 3 -> addTerritoryToCampaign(keyboard, campaign);
                case 4 -> removeTerritory(keyboard, campaign);
                case 5 -> campaign.gangInfo();
                case 6 -> createGang(keyboard, campaign);
                case 7 -> removeGang(keyboard, campaign);
                case 8 -> addTerritoryToGang(keyboard, campaign);
                case 9 -> moveTerritory(keyboard, campaign);
                default -> whileLoop = false;
            }

        }

    }

    private static int createTerritory(Scanner keyboard, Campaign campaign) {

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

        return campaign.createTerritory(name, income, recruit, equipment, special, reputation);
    }

    private static void removeTerritory(Scanner keyboard, Campaign campaign) {
        System.out.print(("Enter the ID of the territory to delete:  "));
        System.out.println(campaign.territoryIdName());
        int id = userIntInput(keyboard);
        campaign.removeTerritory(id);
    }

    private static int createGang(Scanner keyboard, Campaign campaign) {
        System.out.println("Enter player's name:    ");
        String player = keyboard.nextLine();
        System.out.println("Enter the gang's name: ");
        String name = keyboard.nextLine();
        System.out.println("Enter what type of gang it is:  ");
        String gangType = keyboard.nextLine();
        System.out.println("Enter the gangs total vale: ");
        int totalValue = userIntInput(keyboard);
        return (campaign.createGang(player, name, gangType, totalValue));
    }

    private static void removeGang(Scanner keyboard, Campaign campaign) {
        System.out.print(("Enter the ID of the gang to delete:  "));
        System.out.println(campaign.gangsIdName());
        int id = userIntInput(keyboard);
        campaign.removeGang(id);
    }

    private static void addTerritoryToGang(Scanner keyboard, Campaign campaign) {

        System.out.println("Please select the gang you wish to add it to : \n");
        System.out.println(campaign.gangsIdName());
        System.out.println("0 : New Gang");

        int gangOption = userIntInput(keyboard);
        int gangID;

        if (gangOption == 0) {
            gangID = (createGang(keyboard, campaign));
        } else {
            gangID = gangOption;
        }

        System.out.println("Please select the territory you wish to add to them : \n");
        System.out.println(campaign.territoriesInPlayIdName());
        System.out.println("0 : New Territory");

        int territoryOption = userIntInput(keyboard);
        int territoryID;

        if (territoryOption == 0) {
            territoryID = (addTerritoryToCampaign(keyboard, campaign));
        } else {
            territoryID = territoryOption;
        }
        campaign.addTerritoryToGang(gangID, territoryID);
        System.out.println("Press 1 if you wish to add another, or 2 to return to the menu : ");
        int again = userIntInput(keyboard);
        if (again == 1) {
            addTerritoryToGang(keyboard, campaign);
        }
    }

    private static int addTerritoryToCampaign(Scanner keyboard, Campaign campaign) {
        System.out.println("Please select the territory you wish to add : \n");
        System.out.println(campaign.territoryIdName());
        int territoryOption = userIntInput(keyboard);
        return campaign.addTerritoryToCampaign(territoryOption);
    }

    private static void moveTerritory(Scanner keyboard, Campaign campaign) {
        System.out.println("Please select the gang you wish move it from : \n");
        System.out.println(campaign.gangsIdName());

        int gangOneID = userIntInput(keyboard);

        System.out.println("Please select the territory you wish to move : \n");
        System.out.println(campaign.ownedTerritoryIdName(gangOneID));

        int territoryID = userIntInput(keyboard);

        System.out.println("Please select the gang you wish move it to : \n");
        System.out.println(campaign.gangsIdName());

        int gangTwoID = userIntInput(keyboard);


        campaign.removeTerritoryFromGang(gangOneID, territoryID);

        campaign.addTerritoryToGang(gangTwoID, territoryID);

    }



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




