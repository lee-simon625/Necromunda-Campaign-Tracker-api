package objects.territories;


import com.j256.ormlite.stmt.query.In;

public class Territory {



    protected Integer baseTerritoryID;
    protected Integer campaignID;
    protected Integer gangID;
    protected Integer id;
    protected String name;
    protected String income;
    protected String recruit;
    protected String equipment;
    protected String special;
    protected int reputation;
    protected String gangIncome;
    protected String gangRecruit;
    protected String gangEquipment;
    protected String gangSpecial;
    protected String gangReputation;
    protected boolean isDefault;

    public Territory(Integer id, String name, String income, String recruit, String equipment, String special, int reputation, String gangIncome, String gangRecruit, String gangEquipment, String gangSpecial, String gangReputation, boolean isDefault) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.recruit = recruit;
        this.equipment = equipment;
        this.special = special;
        this.reputation = reputation;
        this.gangIncome = gangIncome;
        this.gangRecruit = gangRecruit;
        this.gangEquipment = gangEquipment;
        this.gangSpecial = gangSpecial;
        this.gangReputation = gangReputation;
        this.isDefault = isDefault;


    }
       public Territory(Integer campaignID, Integer gangID, Integer id, String name, String income, String recruit, String equipment, String special, int reputation, String gangIncome, String gangRecruit, String gangEquipment, String gangSpecial, String gangReputation, boolean isDefault) {
        this.campaignID = campaignID;
        this.gangID = gangID;
        this.id = id;
        this.name = name;
        this.income = income;
        this.recruit = recruit;
        this.equipment = equipment;
        this.special = special;
        this.reputation = reputation;
        this.gangIncome = gangIncome;
        this.gangRecruit = gangRecruit;
        this.gangEquipment = gangEquipment;
        this.gangSpecial = gangSpecial;
        this.gangReputation = gangReputation;
        this.isDefault = isDefault;
    }

    public void setBaseTerritoryID(Integer baseTerritory) {
        this.baseTerritoryID = baseTerritory;
    }

    public void setCampaignID(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public void setGangID(Integer gangID) {
        this.gangID = gangID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public void setRecruit(String recruit) {
        this.recruit = recruit;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setGangIncome(String gangIncome) {
        this.gangIncome = gangIncome;
    }

    public void setGangRecruit(String gangRecruit) {
        this.gangRecruit = gangRecruit;
    }

    public void setGangEquipment(String gangEquipment) {
        this.gangEquipment = gangEquipment;
    }

    public void setGangSpecial(String gangSpecial) {
        this.gangSpecial = gangSpecial;
    }

    public void setGangReputation(String gangReputation) {
        this.gangReputation = gangReputation;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getBaseTerritoryID() {
        return baseTerritoryID;
    }

    public Integer getCampaignID() {
        return campaignID;
    }

    public Integer getGangID() {
        return gangID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIncome() {
        return income;
    }

    public String getRecruit() {
        return recruit;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getSpecial() {
        return special;
    }

    public int getReputation() {
        return reputation;
    }

    public String getGangIncome() {
        return gangIncome;
    }

    public String getGangRecruit() {
        return gangRecruit;
    }

    public String getGangEquipment() {
        return gangEquipment;
    }

    public String getGangSpecial() {
        return gangSpecial;
    }

    public String getGangReputation() {
        return gangReputation;
    }

    public boolean isDefault() {
        return isDefault;
    }





    @Override
    public String toString() {
        String result = "\n" + name + "\n";

        if (income != null) {
            result += "   Income            : " + income + "\n";
        }
        if (recruit != null) {
            result += "   Recruits          : " + recruit + "\n";
        }
        if (equipment != null) {
            result += "   Equipment         : " + equipment + "\n";
        }
        if (special != null) {
            result += "   Special           : " + special + "\n";
        }
        if (reputation != 0) {
            result += "   Reputation Gain   : " + reputation + "\n";
        }
        if (gangIncome != null) {
            result += "   Income            : " + gangIncome + "\n";
        }
        if (gangRecruit != null) {
            result += "   Recruits          : " + gangRecruit + "\n";
        }
        if (gangEquipment != null) {
            result += "   Equipment         : " + gangEquipment + "\n";
        }
        if (gangSpecial != null) {
            result += "   Special           : " + gangSpecial + "\n";
        }
        if (gangReputation != null) {
            result += "   Reputation Gain   : " + gangReputation + "\n";
        }

        return result;
    }


}
