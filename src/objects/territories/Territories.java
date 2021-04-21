package objects.territories;


public class Territories {

    protected String name;
    protected String income;
    protected String recruit;
    protected String equipment;
    protected String special;
    protected int reputation;

    public Territories(String name, String income, String recruit, String equipment, String special, int reputation) {
        this.name = name;
        this.income = income;
        this.recruit = recruit;
        this.equipment = equipment;
        this.special = special;
        this.reputation = reputation;

    }


    @Override
    public String toString() {
        return "\n" + name + "\n" +
                "   Income            : " + income + "\n" +
                "   Recruits          : " + recruit + "\n" +
                "   Equipment         : " + equipment + "\n" +
                "   Special           : " + special + "\n" +
                "   Reputation Gain   : " + reputation + "\n";


    }


}
