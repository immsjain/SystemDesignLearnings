import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoutingService {
    private RouteElement root;

    public RoutingService() {
        this.root = new RouteElement("#");
    }

    public RouteElement getRoot() {
        return root;
    }

    public void setRoot(RouteElement root) {
        this.root = root;
    }

    private List<String>parser(String str){
        List<String>list = new ArrayList<>();
        int sz = str.length();
        String t="";
        for(int i=0;i<sz;i++){
            if(str.charAt(i)=='/'){
                if(!t.isEmpty()){
                    list.add(t);
                }
               t="";
            }else{
                t+=str.charAt(i);
            }
        }
        if(!t.isEmpty()){
            list.add(t);
        }
        return list;
    }
    private void valueAdd(List<String>list,int idx,String val,RouteElement ele){
        if(idx==list.size()){
            ele.setValue(val);
            return;
        }
        String str = list.get(idx);
        Map<String,RouteElement> map = ele.getMap();
        if(str.equals("*")){
            for(Map.Entry<String,RouteElement> e : map.entrySet()){
                valueAdd(list,idx+1,val,e.getValue());
            }
        }else if(!map.containsKey(str)){
            map.put(str,new RouteElement(null));
            ele = map.get(str);
            valueAdd(list,idx+1,val,ele);
        }
        return;
    }

    private List<String> searchValue(List<String>list,int idx,RouteElement ele){
        List<String>ans = new ArrayList<>();
        if(idx==list.size()){
            ans.add(ele.getValue());
            return ans;
        }
        String str = list.get(idx);
        Map<String,RouteElement> map = ele.getMap();
        if(str.equals("*")){
            for(Map.Entry<String,RouteElement> e : map.entrySet()){
                ans.addAll(searchValue(list,idx+1,e.getValue()));
            }
        }else if(map.containsKey(str)){
            ele = map.get(str);
            ans.addAll(searchValue(list,idx+1,ele));
        }
        return ans;
    }

    public void addValue(String route, String val){
            List<String>list = parser(route);
            valueAdd(list,0,val,root);
    }

    public List<String> search(String route){
        List<String>list = parser(route);
        List<String>values = searchValue(list,0,root);
        return values;
    }

}
