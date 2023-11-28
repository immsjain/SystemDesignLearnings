// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"Shubham");
        User user2 = new User(2,"Shishir");

        UrlShortner urlShortner = UrlShortner1.getInstance(new StandardUrlShortingStrategy());

        LongUrl lurl = new LongUrl("https://www.preplaced.in/dashboard");

        ShortUrl shortUrl = user1.getShortUrl(lurl, urlShortner );

        System.out.printf(shortUrl.toString());
    }

}