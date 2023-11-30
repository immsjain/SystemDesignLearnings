import java.util.*;

public class ColorPicker {
    private Color selectedColor;
    Map<Color, List<Lisner>>map;

    public ColorPicker() {
        this.selectedColor = Color.BLACK;
        map = new HashMap<>();
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    public Map<Color, List<Lisner>> getMap() {
        return map;
    }

    public void setMap(Map<Color, List<Lisner>> map) {
        this.map = map;
    }

    public void pickColor(Color color){
        selectedColor = color;
        if(map.containsKey(color)){
            List<Lisner> list = map.get(color);
            for (Lisner l:list) {
                l.listen(color);
            }
        }
    }

    public void addLisner(Lisner lisner, Color color){
        if(!map.containsKey(color)){
            map.put(color,new ArrayList<>());
        }
        if(!map.get(color).contains(lisner)){
            map.get(color).add(lisner);
        }
    }

    public void removeLisner(Lisner lisner, Color color){
        if(map.containsKey(color) && map.get(color).contains(lisner)){
            map.get(color).remove(lisner);
            if(map.get(color).isEmpty()){
                map.remove(color);
            }
        }
    }

}
