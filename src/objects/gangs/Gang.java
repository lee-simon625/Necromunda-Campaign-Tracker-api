package objects.gangs;

import java.util.ArrayList;

public class Gang {

    protected String player;
    protected String name;
    protected String gangType;
    protected int totalValue;
    protected int reputation;
    protected int totalWins;
    protected int territoryID;
    protected ArrayList<Integer> ownedTerritories;




    public Gang(String player, String name, String gangType, int totalValue) {
        this.player = player;
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.setDefault();
    }

    public void addTerritory(int territoryID){
        ownedTerritories.add(territoryID);
    }


    @Override
    public String toString() {
        return "\n" + player + "'s gang " + name + " are " + gangType + ". \n" +
                "   Total Value : " + totalValue + " Credits\n" +
                "   Reputation  : " + reputation + "\n" +
                "   Total Wins  : " + totalWins + "\n" +
                "   Territories : " + ownedTerritories.size();
    }

    public void setDefault() {
        this.reputation = 1;
        this.totalWins = 0;
        this.ownedTerritories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}

