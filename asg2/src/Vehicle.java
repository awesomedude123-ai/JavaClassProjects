public class Vehicle {
    private Model model;
    private Manufacturer manufacturer;
    private VehicleType vehicleType;
    private int mpg;
    private int odometerMileage;

    public Vehicle(Model model,Manufacturer manufacturer, VehicleType vehicleType, int mpg, int odometerMileage){
        this.manufacturer=manufacturer;
        this.model=model;
        this.vehicleType=vehicleType;
        this.mpg=mpg;
        this.odometerMileage=odometerMileage;
    }

    public Model getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getMpg() {
        return mpg;
    }

    public int getOdometerMileage() {
        return odometerMileage;
    }

    public String toString(){
        return "Model: "+model.toString()+"\nManufacturer: "+manufacturer.toString()+"\nVehicle Type: "+vehicleType+"\n"+"MPG: "+this.mpg+"\nOdometer Mileage: "+this.odometerMileage;
    }
}
