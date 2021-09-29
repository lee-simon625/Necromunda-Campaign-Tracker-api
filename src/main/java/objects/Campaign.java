package objects;

import objects.gangs.Gang;
import objects.territories.Territory;

import java.util.HashMap;
import java.util.Set;

public class Campaign {

    protected Integer id;
    protected String name;
    protected String notes;
    protected String password;

    public Campaign(Integer id, String name, String notes, String password) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.password = password;
    }

    public Campaign(Integer id, String name, String notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;

    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "ID : " + id + "\n" +
                "Name : " + name + "\n" +
                "Notes :" + notes + "\n"+
                "Password :" + password + "\n";
    }

}
