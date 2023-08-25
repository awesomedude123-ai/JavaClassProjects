import java.time.Year;
import java.util.List;

public class Sedan extends Vehicle{
    public Sedan(String manufacturer, String country, List<Year> listOfYears, String model, double mpg) {
        super(manufacturer, country, listOfYears,model,mpg);
    }

    @Override
    public int numberOfWheels() {
        return 4;
    }

    @Override
    public double howFarWith(int numOfGallons) {
        return getMpg()*numOfGallons;
    }

    @Override
    public String toString() {
        return getManufacturer().toString()+" "+getModel().toString()+ ", mpg: "+this.getMpg();
    }
}
