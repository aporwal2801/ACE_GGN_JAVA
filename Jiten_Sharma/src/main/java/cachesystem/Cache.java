package cachesystem;

/**
 * Created by jsha22 on 11/16/2016.
 *
 * should be implemented by all cache implementations
 * in case other methods need to be added, can be added using future methods.
 */
public interface Cache {

    public void put(String key, Object value);
    public Object get(String key);
    public void cleanup();//eviction
    public int size();
    public void remove(String key);
}
