import java.time.Year;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Truck ford=new Truck("Ford","USA", List.of(Year.of(2020),Year.of(2021),Year.of(2022)),"F150",20.00,true);
        Sedan civic=new Sedan("Honda","Japan",List.of(Year.of(1996),Year.of(1997),Year.of(1998)),"Civic LX",28.00);
        Sedan bmw=new Sedan("BMW","Germany",List.of(Year.of(2015),Year.of(2016),Year.of(2017),Year.of(2018)),"M# Limited",30.00);
        Truck tundra=new Truck("Toyota","Japan",List.of(Year.of(1987),Year.of(1988)),"Tundra",30.00);
        Garage g=new Garage();
        g.addVehicle(ford);
        g.addVehicle(civic);
        g.addVehicle(bmw);
        g.addVehicle(tundra);

        System.out.println("Before Sorting:  ");
        System.out.println(g.toString());

        g.sortByReleaseYear();

        System.out.println("\nAfter Sorting:  ");
        System.out.println(g.toString());
    }
}
