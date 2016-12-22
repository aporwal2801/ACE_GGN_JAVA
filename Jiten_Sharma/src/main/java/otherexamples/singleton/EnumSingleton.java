package otherexamples.singleton;

/**
 * Created with IntelliJ IDEA.
 * User: jsha22
 * Date: 12/14/16
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public enum EnumSingleton {
    INSTANCE;
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

    public static void main(String[] args) {
        System.out.println("hello");
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.setId(1);
        System.out.println(singleton.getId());
    }
}
