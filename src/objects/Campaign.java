package objects;

import objects.gangs.Gang;
import objects.gangs.LawfulGang;
import java.util.HashMap;

public class Campaign {

    //private ArrayList<Territories> territories = new ArrayList<>();
    private HashMap<String, Gang> gangs = new HashMap<>();


    public void createGang(String name, String gangType, int totalValue) {
        gangs.put(name, new LawfulGang(name, gangType, totalValue));


    }

    public void removeGang(String name) {

        gangs.remove(name);

    }

    public int countGangs() {
        return gangs.size();
    }

    public String gangsToString() {
        String compiledString = "";


        for (Gang gang : gangs.values()) {
            compiledString += gang.toString();
        }


        return compiledString;

    }


}
    /*
todo campaign should print number of gangs and number of territories
todo also have a second fancy print for the whole campaign with status of each gang and what territories they have
todo make method that calls the constructors for both gangs and territories and adds it to the campaign list
todo change gangs hashmap to index on int then do territories the same way
todo
     */