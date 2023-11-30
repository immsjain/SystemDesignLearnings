import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RoutingService routingService = new RoutingService();
        routingService.addValue("www/shubham/company","Microsoft");
        routingService.addValue("www/shubham/","Human");
        List<String> lst = routingService.search("www/*");
        System.out.println(lst);

    }
}