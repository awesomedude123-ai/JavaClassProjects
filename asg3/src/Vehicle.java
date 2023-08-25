import java.time.Year;
import java.util.List;

public abstract class Vehicle implements Comparable<Vehicle>{
    private double mpg;

    private String country;

    private Manufacturer manufacturer;

    private AutoModel model;

    public Vehicle(String manufacturer, String country, List<Year> listOfYears, String model, double mpg){
        this.manufacturer=new Manufacturer(manufacturer,country);
        boolean inProduction=true;
        if(listOfYears.get(listOfYears.size()-1).isBefore(Year.now())){
            inProduction=false;
        }
        this.model=new AutoModel(model,inProduction,listOfYears);
        this.mpg=mpg;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public AutoModel getModel() {
        return model;
    }

    public double getMpg() {
        return mpg;
    }

    public Year getYear(){
        return model.getListOfYears().get(0);
    }

    public abstract int numberOfWheels();

    public abstract double howFarWith(int numOfGallons);

    @Override
    public int compareTo(Vehicle o){
        if(o.getYear().isBefore(this.getYear())){
            return 1;
        }else if(o.getYear().isAfter(this.getYear())){
            return -1;
        }else{
            return 0;
        }
    }
}
