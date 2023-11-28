import java.util.Date;

public class Subscription {
    private Package aPackage;
    private Date timestamp;

    public Subscription(Package aPackage, Date timestamp) {
        this.aPackage = aPackage;
        this.timestamp = timestamp;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
