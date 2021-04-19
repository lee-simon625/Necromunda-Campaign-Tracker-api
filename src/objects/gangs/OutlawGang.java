package objects.gangs;


public class OutlawGang extends Gang {


    public OutlawGang(String name, String gangType, int totalValue, int reputation, int totalWins) {
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.reputation = reputation;
        this.totalWins = totalWins;
    }


    public OutlawGang(String name, String gangType, int totalValue) {
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;
        this.setDefault();


    }

}
