public class URequest {
    int id;
    String data;
    int timestamp;

    User user;

    public URequest(int id, String data, int timestamp, User user) {
        this.id = id;
        this.data = data;
        this.timestamp = timestamp;
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
