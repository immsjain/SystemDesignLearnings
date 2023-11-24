public class Request {
    private int id;
    private Data data;
    private User user;
    private int timestamp;

    public Request(int id, Data data, User user, int timestamp) {
        this.id = id;
        this.data = data;
        this.user = user;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void process(){
        System.out.println("Process");
    }

    public void fail(){
        System.out.println("Fail");
    }
}
