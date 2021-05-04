package objects.gangs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Gangs {


    protected String player;
    protected String name;
    protected String gangType;
    protected int totalValue;
    protected int reputation;
    protected int totalWins;
    public Set<Integer> ownedTerritories;


    public Gangs(String player, String name, String gangType, int totalValue) {
        this.player = player;
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.setDefault();
    }

    public void addTerritory(int territoryID) {
        ownedTerritories.add(territoryID);
    }

    public void removeTerritory(int territoryID) {
        ownedTerritories.remove(territoryID);
    }


    @Override
    public String toString() {
        return "\n" + player + "'s gang " + name + " are " + gangType + ". \n" +
                "   Total Value : " + totalValue + " Credits\n" +
                "   Reputation  : " + reputation + "\n" +
                "   Total Wins  : " + totalWins + "\n" +
                "   Territories : " + ownedTerritories.size() + "\n";
    }

    public void setDefault() {
        this.reputation = 1;
        this.totalWins = 0;
        this.ownedTerritories = new HashSet<>();
    }

    public String getName() {
        return player;
    }
}

