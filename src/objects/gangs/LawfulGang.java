package objects.gangs;


import java.util.ArrayList;

public class LawfulGang extends Gang {


    public LawfulGang(String name, String gangType, int totalValue, int reputation, int totalWins) {
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.reputation = reputation;
        this.totalWins = totalWins;
    }


    public LawfulGang(String name, String gangType, int totalValue) {
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.setDefault();
       // private hashmap<ownedTerritories> ownedterritories = new ArrayList<>();
    }

}
