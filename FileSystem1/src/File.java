public class File extends Children{
    private Data data;

    public File(String name, Data data) {
        super(name,"");
        this.data = data;
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
