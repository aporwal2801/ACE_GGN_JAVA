package garbagecollection;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/19/16
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class SharedResource {
    SharedResource(int id, String name){
        this.id = id;
        this.name = name;
    }
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
