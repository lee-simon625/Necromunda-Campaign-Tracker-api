package objects;

import objects.gangs.Gang;
import objects.territories.Territories;

import java.util.ArrayList;
import java.util.HashMap;

public class Campaign {

    private HashMap<Integer, Territories> territories = new HashMap();
    private HashMap<Integer, Gang> gangs = new HashMap<>();
    private ArrayList<Integer> gangID = new ArrayList<Integer>();
    private ArrayList<Integer> territoryID = new ArrayList<Integer>();


    public int createGang(String player, String name, String gangType, int totalValue) {
        int id = gangID.size() + 1;
        gangID.add(id);
        gangs.put(id, new Gang(player, name, gangType, totalValue));
        System.out.println("New gang Created with ID " + id);
        return id;


    }

    public void removeGang(int id) {

        gangs.remove(id);

    }

    public int countGangs() {

        return gangs.size();
    }

    public String gangsToString() {
        String compiledString = "";


        for (int gangID : gangs.keySet()) {
            compiledString += gangs.get(gangID).toString();

        }


        return compiledString;

    }

    public String gangsIdName() {
        String compiledString = "";


        for (int gangID : gangs.keySet()) {
            compiledString += "\n" + gangID + " : " + gangs.get(gangID).getName();

        }


        return compiledString;

    }

    public int createTerritory(String name, String income, String recruit, String equipment, String special, int reputation) {
        int id = territoryID.size() + 1;
        territoryID.add(id);
        territories.put(id, new Territories(name, income, recruit, equipment, special, reputation));
        System.out.println("New territory Created with ID " + id);
        return id;

    }

    public void removeTerritory(int id) {

        territories.remove(id);

    }

    public int countTerritories() {

        return territories.size();

    }

    public String territoriesToString() {
        String compiledString = "";

        for (int territoryID : territories.keySet()) {
            compiledString += territories.get(territoryID).toString();
        }

        return compiledString;
    }

    public String territoryIdName() {
        String compiledString = "";


        for (int territoryID : territories.keySet()) {
            compiledString += "\n" + territoryID + " : " + territories.get(territoryID).getName();

        }


        return compiledString;

    }

    public void campaignInfo() {
        System.out.println("There are :\n " + "  " + countGangs() + " gangs \n" +
                "   " + countTerritories() + " territories");
    }

    public void gangInfo() {
        System.out.println(gangsToString());
    }

    public void territoryInfo() {
        System.out.println(territoriesToString());
    }

    public void addTerritoryToGang(int gangID, int territoryID) {
        gangs.get(gangID).addTerritory(territoryID);

    }
}
    /*
todo also have a second fancy print for the whole campaign with status of each gang and what territories they have
     */