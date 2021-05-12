package objects;

import objects.gangs.Gang;
import objects.territories.Territory;

import java.util.HashMap;
import java.util.Set;

public class Campaign {

    private HashMap<Integer, Territory> territories = new HashMap();
    private HashMap<Integer, Integer> territoriesInPlay = new HashMap();
    private HashMap<Integer, Gang> gangs = new HashMap<>();


    /*public void initialiseTerritories() {
        createTerritory("Old Ruins", "D3x10 + 10 per Dome Runner", "-", "-", "-", 0);
        createTerritory("Settlement", "D6x10", "Roll 2D6. One die rolls a 6: Juve. Both roll 6: Ganger (instead)", "-", "-", 0);
        createTerritory("Rogue Doc Shop", "-", "Rogue Doc", "-", "-", 0);
        createTerritory("Promethium Cache", "-", "-", "3 fighters gain Incendiary charges", "Re-roll any Ammo checks for Blaze weapons", 0);
        createTerritory("Wastes", "-", "-", "-", "If challenged in the Phase 1, choose which Territory is at stake.\n       If challenged in the Phase 3 for a Resource already controlled by the gang,\n      the Leader can try to pass an Intelligence check to play as Attacker on the Ambush scenario instead of rolling.", 0);

    }*/

    public int createGang(String player, String name, String gangType, int totalValue) {
        int id = 1;
        for (int gangID : gangs.keySet()) {
            if (gangID >= id) {
                id = gangID + 1;
            }
        }
        gangs.put(id, new Gang(id, player, name, gangType, totalValue));
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

/*
    public int createTerritory(String name, String income, String recruit, String equipment, String special, int reputation) {
        int id = 1;
        for (int territoryID : territories.keySet()) {
            if (territoryID >= 1) {
                id = territoryID + 1;
            }
        }
        territories.put(id, new Territory(name, income, recruit, equipment, special, reputation));
        System.out.println("New territory Created with ID " + id);
        return id;
    }
*/

    public int addTerritoryToCampaign(int territoryID) {
        int id = 1;
        for (int newID : territoriesInPlay.keySet()) {
            if (newID >= 1) {
                id = newID + 1;
            }
        }

        territoriesInPlay.put(id, territoryID);
        System.out.println("New territory Created with ID " + id);
        return id;
    }

    public void removeTerritory(int id) {

        territories.remove(id);

    }

    public int countTerritories() {

        return territoriesInPlay.size();

    }

    public String territoriesToString() {
        String compiledString = "";

        for (int territoryID : territories.keySet()) {
            territories.get(territoryID).toString();
        }

        return compiledString;
    }

    public String territoriesInPlayToString() {
        String compiledString = "";

        for (int ownedID : territoriesInPlay.values()) {
            compiledString +=  territories.get(ownedID);
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

    public String territoriesInPlayIdName() {
        String compiledString = "";

        for (int territoryID : territoriesInPlay.keySet()) {
            compiledString += "\n" + territoryID + " : " + territories.get(territoriesInPlay.get(territoryID)).getName();

        }

        return compiledString;

    }

    public String ownedTerritoryIdName(int gangID) {
        String compiledString = "";
        Set<Integer> territoryList = gangs.get(gangID).ownedTerritories;
        for (int territoryID :  territoryList){
            compiledString += "\n" + territoryID + " : " + territories.get(territoriesInPlay.get(territoryID));
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
        System.out.println(territoriesInPlayToString());
    }

    public void addTerritoryToGang(int gangID, int territoryID) {
        gangs.get(gangID).addTerritory(territoryID);

    }

    public void removeTerritoryFromGang(int gangID, int territoryID) {
        gangs.get(gangID).removeTerritory(territoryID);

    }

}
