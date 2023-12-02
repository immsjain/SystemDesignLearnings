import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileSystem {

    Trie trie = new Trie();
    private class Node{
        private String name ;
        private int value;

        Map<String,Node>map;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Map<String, Node> getMap() {
            return map;
        }

        public void setMap(Map<String, Node> map) {
            this.map = map;
        }
    }
    public class Trie{
        private Node root;

        public Trie(){
            root.setName("/");
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }

        private List<String> parse(String str){
            int sz = str.length();
            List<String>ans = new ArrayList<>();
            StringBuilder t= new StringBuilder();
            for(int i=0;i<sz;i++){
                if(str.charAt(i)=='/'){
                    if(!t.isEmpty()) {
                        ans.add(t.toString());
                        t.setLength(0);
                    }
                }else{
                    t.append(str.charAt(i));
                }
            }
            return ans;
        }

        public boolean addValue(String path, int value){
                List<String>list = parse(path);
                int sz = list.size();
                Node itr = trie.getRoot();
                for(int i=0;i<sz;i++){
                    String s = list.get(i);
                    if(!itr.getMap().containsKey(s) && i<sz-1){
                        return false;
                    }
                    if(!itr.getMap().containsKey(s)){
                        itr.getMap().put(s,new Node(s));
                    }
                    itr = itr.getMap().get(s);
                }
                itr.setValue(value);
                return true;
        }

        public int getValue(String path){
            List<String>list = parse(path);
            int sz = list.size();
            Node itr = trie.getRoot();
            for(int i=0;i<sz;i++){
                String s = list.get(i);

                if(!itr.getMap().containsKey(s)){
                    return -1;
                }
                itr = itr.getMap().get(s);
            }
            return itr.getValue();
        }

    }
    public FileSystem() {

    }

    public boolean createPath(String path, int value) {
        return trie.addValue(path,value);
    }

    public int get(String path) {
        return trie.getValue(path);
    }
}