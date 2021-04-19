import objects.Campaign;


public class Main {
    public static void main(String[] args) {


        Campaign campaign = new Campaign();


        campaign.createGang("Dom's Gang", "Delaque", 1000);
        campaign.createGang("Tom's Gang", "Escher", 1005);
        campaign.createGang("Phil's Gang", "Bounty Hunters", 985);
        campaign.createGang("Simon's Gang", "Genestealer Cult", 1000);
        campaign.createGang("David's Gang", "Corpse Grinder", 1000);



//        Territories oldRuin = new Territories("Old Ruin", "D3x10 +10 per Dome Runner", "None", "None", "None", 0);
//        Territories settlement = new Territories("Settlement", "D6x10", "Roll 2D6, One 6 = Juve, Two 6 = Ganger", "None", "None", 1);



        System.out.println(campaign.gangsToString());
//        System.out.println(listOfTerritories);
//        System.out.println("There are "+listOfTerritories.toArray().length+ " territories");
          System.out.println("There are "+ campaign.countGangs()+ " gangs");

    }

}
/*

update the toString for each object



 */