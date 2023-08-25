import java.time.Year;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) throws IllegalAccessException {
        //Ford F150
        ArrayList<Year> listOfYears=new ArrayList<>();
        listOfYears.add(Year.of(1950));
        listOfYears.add(Year.of(2000));
        Model fModel=new Model("F150",true ,listOfYears);
        Manufacturer fManufacturer=new Manufacturer("Ford","USA");
        VehicleType fVehicleType=new VehicleType(4,VehicleType.Kind.Truck);
        Vehicle fVehicle=new Vehicle(fModel,fManufacturer,fVehicleType,60,10000);
        System.out.println(fVehicle.toString());

        System.out.println("----------------");
        //Honda Civic
        listOfYears.clear();
        listOfYears.add(Year.of(1996));
        listOfYears.add(Year.of(2003));
        Model hModel=new Model("Civic",false ,listOfYears);
        Manufacturer hManufacturer=new Manufacturer("Honda","Japan");
        VehicleType hVehicleType=new VehicleType(4,VehicleType.Kind.Coupe);
        Vehicle hVehicle=new Vehicle(hModel,hManufacturer,hVehicleType,90,8000);
        System.out.println(hVehicle.toString());
        System.out.println("----------------");
        // BMW M3
        listOfYears.clear();
        listOfYears.add(Year.of(2022));
        Model bModel=new Model("M3",true ,listOfYears);
        Manufacturer bManufacturer=new Manufacturer("BMW","Germany");
        VehicleType bVehicleType=new VehicleType(4,VehicleType.Kind.Car);
        Vehicle bVehicle=new Vehicle(bModel,bManufacturer,bVehicleType,50,20000);
        System.out.println(bVehicle.toString());
    }
}