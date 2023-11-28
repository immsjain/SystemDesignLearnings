public interface UrlShortnerStrategy {
    public ShortUrl getShortUrl(LongUrl lu);

    public LongUrl getLongUrl(ShortUrl shortUrl);
}
