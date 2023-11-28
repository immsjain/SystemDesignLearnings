import java.util.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //user can subscribe for a package
        //we can get users monthly spend of a year

        User user = new User(1,"Shubham");
        Package aPackage = new Package(1000,"hotstar");
        PackageList packageList = new PackageList(List.of(new Package[]{aPackage}));
        System.out.println(packageList.getAllPackages());
        user.Subscribe(packageList.getAllPackages().get(0),new Date(2023,3,12));
        int spend = user.getMonthSpend(6,new Date(2023,7,4));
        System.out.println(spend);
    }
}