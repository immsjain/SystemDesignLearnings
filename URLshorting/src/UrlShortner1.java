public class UrlShortner1 implements UrlShortner{
    UrlShortnerStrategy urlShortnerStrategy;
    private static UrlShortner instance=null;

    private  UrlShortner1(UrlShortnerStrategy urlShortnerStrategy) {
        this.urlShortnerStrategy = urlShortnerStrategy;
    }

    public  static UrlShortner getInstance(UrlShortnerStrategy urlShortnerStrategy){
        if(instance==null){
            instance =  new UrlShortner1(urlShortnerStrategy);
        }
        return instance;
    }

    @Override
    public ShortUrl getShortUrl(LongUrl lurl) {
        return  urlShortnerStrategy.getShortUrl(lurl);
    }

    public LongUrl getLongUrl(ShortUrl shortUrl){
        return urlShortnerStrategy.getLongUrl(shortUrl);
    }
}
