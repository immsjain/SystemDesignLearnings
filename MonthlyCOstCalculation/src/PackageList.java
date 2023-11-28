import java.util.List;

public class PackageList {
    private List<Package>packages;

    public PackageList(List<Package> packages) {
        this.packages = packages;
    }

    public void addPackage(Package p){
        packages.add(p);
    }

    public List<Package> getAllPackages(){
        return packages;
    }
}
