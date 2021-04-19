package objects.gangs;


public class Gang {

    protected String name;
    protected String gangType;
    protected int totalValue;
    protected int reputation;
    protected int totalWins;


    @Override
    public String toString() {
        return "\n" + name + " is a " + gangType + " \n" +
                "   Total Value : " + totalValue + " Credits\n" +
                "   Reputation  : " + reputation + "\n" +
                "   Total Wins  : " + totalWins + "\n";
    }

    public void setDefault() {
        this.reputation = 1;
        this.totalWins = 0;
    }

    public String getName(){
        return name;
    }
}
/*
todo Gangs to have a arraylist of Territories

 */