import org.testng.annotations.Test;

import java.util.*;

public class Collections2 {

    @Test
    public void List() {
        /*ArrayList<String> cars = new ArrayList<>();   Same as below*/
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add(2, "Chevrolet");
        System.out.println("Object Chevrolet added");
        System.out.println(cars);
        cars.remove(2);
        System.out.println("Object Chevrolet removed");
        System.out.println(cars);
        System.out.println(cars.size()); //total number of elements
        String c =(cars.contains("Volvo")) ? "Volvo is in array" : "Volvo is not in array";
        System.out.println(c);
        cars.clear(); //clears everything from array
    }

    @Test
    public void Set(){
        Set<String> cars = new TreeSet();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);

        Set<String> cars2 = new TreeSet();
        cars2.add("Volvo");
        cars2.add("BMW");
        cars2.add("Ford");
        cars2.add("Mazda");

        System.out.println(cars2);
        System.out.println(cars.equals(cars2));

        System.out.println(cars2.size());
        cars2.remove("BMW");
    }

    @Test
    public void Iterator(){
            List<String> cars = new ArrayList<>();
            cars.add("Volvo");
            cars.add("BMW");
            cars.add("Ford");
            cars.add("Mazda");
            System.out.println(cars);

        Iterator it = cars.iterator();

        while(it.hasNext()) {
            Object car = it.next();
            System.out.println("Value : " + car);
        }

    }
}
