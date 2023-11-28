public interface UrlShortner {
    public ShortUrl getShortUrl(LongUrl lurl);

    public LongUrl getLongUrl(ShortUrl shortUrl);
}
