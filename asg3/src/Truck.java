import java.time.Year;
import java.util.List;

public class Truck extends Vehicle{
    private boolean isDually;
    public Truck(String manufacturer, String country, List<Year> listOfYears, String model, double mpg, boolean isDually) {
        this(manufacturer, country, listOfYears, model, mpg);
        this.isDually=isDually;
    }

    public Truck(String manufacturer, String country, List<Year> listOfYears, String model, double mpg) {
        super(manufacturer, country, listOfYears, model, mpg);
        this.isDually=false;
    }

    @Override
    public int numberOfWheels() {
        if(isDually==true){
            return 6;
        }else{
            return 4;
        }
    }

    @Override
    public double howFarWith(int numOfGallons) {
        return getMpg()*numOfGallons;
    }

    @Override
    public String toString() {
        return getManufacturer().toString()+" "+getModel().toString()+ ", mpg: "+this.getMpg()+", is-dually = "+this.isDually;
    }
}
