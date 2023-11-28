import java.util.List;

public class User {
    int id;
    String name;
    List<URequest> ls;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public URequest createReq(int id,String data, int time){
        URequest request = new URequest(id,data,time,this);
        return request;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
