public class File implements Entity{
    private String name;
    private String data;
    private int size;

    public File(String name, String data,int size) {
        this.name = name;
        this.data = data;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
