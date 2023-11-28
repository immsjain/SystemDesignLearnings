// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void test(URLShortner urlShortner, String str){
        LongUrl longUrl = new LongUrl("www.facebook.com");
        ShortUrl shortUrl = urlShortner.createShortUrl(longUrl);
        System.out.println(shortUrl.getUrl());
        LongUrl lurl = urlShortner.getLongUrl(shortUrl);
        System.out.println(lurl.getURL());
    }
    public static void main(String[] args) {

        URLShortner urlShortner = new KeyGenBasedURLShortner(new sixDigitLowerAlphaKeyGenerationStrategy());


        test(urlShortner,"www.facebook.com");
        test(urlShortner,"www.google.com");
        test(urlShortner,"www.yahoo.com");
        test(urlShortner,"www.swiggy.com");
        test(urlShortner,"www.atlassian.com");

    }
}