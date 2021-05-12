package objects.territories;


public class Territory {
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
    protected int gangReputation;

    public Territory(Integer id, String name, String income, String recruit, String equipment, String special, int reputation, String gangIncome, String gangRecruit, String gangEquipment, String gangSpecial, int gangReputation) {
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
        if (gangReputation != 0) {
            result += "   Reputation Gain   : " + gangReputation + "\n";
        }

        return result;
    }

    public String getName() {
        return name;
    }

}
