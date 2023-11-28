public interface URLShortner {
    static String BaseUrl = "www.shubham/";
    ShortUrl createShortUrl(LongUrl url);

    LongUrl getLongUrl(ShortUrl url);
}
