package objects.gangs;

public class BaseGang {

    protected Integer id;
    protected String gangType;

    public BaseGang(Integer id, String gangType) {
        this.id = id;
        this.gangType = gangType;
    }


    @Override
    public String toString() {
        return "\n" + id + " : " + gangType;
    }
}

