package cachesystem;

/**
 * Created by jsha22 on 11/16/2016.
 *
 * further implementations for cache will be provided here and it will return appropriate cache on demand.
 */
public class CacheManager {

    public static Cache getInstance(CacheType cacheType, long expirationTime, int maxElements){
        if(cacheType == null || expirationTime < 0 || maxElements < 1){
            System.out.println("can not continue !!!, please provide valid inputs");
        }
        if(cacheType.equals(CacheType.TIME_BASED)){
            return new TimeBasedCache(expirationTime);
        }else if(cacheType.equals(CacheType.SIZE_BASED)){
            return new SizeBasedCache(maxElements);
        }else{
            System.out.println("not supported");
            return null;
        }
    }
}
