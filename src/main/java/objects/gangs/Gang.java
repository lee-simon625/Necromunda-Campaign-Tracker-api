package objects.gangs;

import java.util.HashSet;
import java.util.Set;

public class Gang {






    protected Integer campaignID;




    protected Integer gangTypeID;
    protected Integer id;
    protected String player;
    protected String name;
    protected String gangType;
    protected int totalValue;
    protected int reputation;
    protected int totalWins;


    public Gang(Integer id, String player, String name, String gangType, int totalValue) {
        this.id = id;
        this.player = player;
        this.name = name;
        this.gangType = gangType;
        this.totalValue = totalValue;

    }

        public Gang(String player, String name, Integer gangTypeID, int campaignID) {
        this.player = player;
        this.name = name;
        this.gangTypeID = gangTypeID;
        this.campaignID = campaignID;

    }


    public void setCampaignID(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public void setGangTypeID(Integer gangTypeID) {
        this.gangTypeID = gangTypeID;
    }

    public void setGangType(String gangType) {
        this.gangType = gangType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public Integer getCampaignID() {
        return campaignID;
    }

    public Integer getGangTypeID() {
        return gangTypeID;
    }

    public String getGangType() {
        return gangType;
    }

    public Integer getId() {
        return id;
    }

    public String getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getReputation() {
        return reputation;
    }

    public int getTotalWins() {
        return totalWins;
    }



    @Override
    public String toString() {
        return "\n" + player + "'s gang " + name + " are " + gangType + ". \n" +
                "   Total Value : " + totalValue + " Credits\n" +
                "   Reputation  : " + reputation + "\n" +
                "   Total Wins  : " + totalWins + "\n";
    }

    public void setDefault() {
        this.reputation = 1;
        this.totalWins = 0;
    }


}

