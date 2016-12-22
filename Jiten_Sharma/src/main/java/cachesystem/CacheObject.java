package cachesystem;

/**
 * Created by jsha22 on 11/16/2016.
 *
 * It will contain "value" (provided by user) and other data used for eviction.
 */
public class CacheObject {

    private final Object value;
    private final Long expiration;
    private Long lastUseTime;

    public CacheObject(Object value, Long expiration) {
        this.value = value;
        this.expiration = expiration;
        this.lastUseTime = System.currentTimeMillis();
    }

    public boolean isExpired() {
        return (lastUseTime + expiration) < System.currentTimeMillis();
    }

    public Object getValue() {

        return this.value;
    }

    public void updateUseTime() {

        this.lastUseTime = System.currentTimeMillis();
    }

    public Long getExpiration() {
        return expiration;
    }

    public Long getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime(Long lastUseTime) {
        this.lastUseTime = lastUseTime;
    }
}
