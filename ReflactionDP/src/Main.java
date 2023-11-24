import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void printField(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                System.out.println("field name: " + field.getName());
                System.out.println("field value: "+ value);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args)  {
        Person person = new Person("Shubham",25);
        printField(person);
    }
}