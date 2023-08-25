import java.time.Year;
import java.util.ArrayList;

public class Model {
    private String name;
    private ArrayList<Year> productionYear;
    private ArrayList<String> trims;
    private boolean isProduced;

    public Model(String name, boolean isProduced, ArrayList<Year> productionYear) throws IllegalAccessException {
        this.name=name;
        this.isProduced=isProduced;
        if(productionYear.size()<=0){
            throw new IllegalAccessException("a car model must have at least one production year");
        }else{
            this.productionYear=productionYear;
        }
        trims=new ArrayList<>();
    }//end constructor

    public String getName() {
        return name;
    }

    public ArrayList<Year> getProductionYear() {
        return productionYear;
    }

    public ArrayList<String> getTrims() {
        return trims;
    }

    public boolean isProduced() {
        return isProduced;
    }

    public void addTrim(String trims){
        this.trims.add(trims);
    }

    public String toString(){
        return this.name+", in production = "+isProduced+", "+productionYear.get(0);
    }
}
