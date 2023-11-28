public class ShortnerFactory {
    public UrlShortner getShortnerFactory(String name){
        if(name.equals("Shorner1")){
            return UrlShortner1.getInstance(new StandardUrlShortingStrategy());
        }else{
            return null;
        }
    }


}
