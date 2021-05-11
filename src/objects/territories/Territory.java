package objects.territories;


public class Territory {
    protected  Integer id;
    protected String name;
    protected String income;
    protected String recruit;
    protected String equipment;
    protected String special;
    protected int reputation;

    public Territory(Integer id,String name, String income, String recruit, String equipment, String special, int reputation) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.recruit = recruit;
        this.equipment = equipment;
        this.special = special;
        this.reputation = reputation;

    }


    @Override
    public String toString() {
        String result = "\n" + name + "\n";

        if (income != null) {
            result += "   Income            : " + income + "\n";
        }
        if (recruit != null){
            result += "   Recruits          : " + recruit + "\n";
        }
        if (equipment != null){
            result += "   Equipment         : " + equipment + "\n";
        }
        if (special != null){
            result+="   Special           : " + special + "\n";
        }
        if (reputation != 0){
            result+="   Reputation Gain   : " + reputation + "\n";
        }

        return result;
    }

    public String getName() {
        return name;
    }

}
