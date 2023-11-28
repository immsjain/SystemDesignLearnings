import java.util.HashMap;
import java.util.Map;

public class KeyGenBasedURLShortner implements URLShortner{
    private KeyGenerationStrategy keyGenerationStrategy;
    Map<ShortUrl,LongUrl> map = new HashMap<>();
    Map<LongUrl,ShortUrl> smap = new HashMap<>();

    public KeyGenBasedURLShortner(KeyGenerationStrategy keyGenerationStrategy) {
        this.keyGenerationStrategy = keyGenerationStrategy;
    }

    @Override
    public ShortUrl createShortUrl(LongUrl url) {
        if(smap.containsKey(url)){
            return smap.get(url);
        }
        String key = keyGenerationStrategy.getKey();
        System.out.println("key: "+ key);
        String surl  = URLShortner.BaseUrl+key;
        ShortUrl shortUrl = new ShortUrl(surl);
        map.put(shortUrl,url);
        smap.put(url,shortUrl);
        return shortUrl;
    }

    @Override
    public LongUrl getLongUrl(ShortUrl url) {
        if(map.containsKey(url)){
            return map.get(url);
        }
        return null;
    }
}
