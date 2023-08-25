import java.time.Year;
import java.util.List;

public class AutoModel {
    private String name;
    private boolean isInProduction;
    private List<Year> listOfYears;

    public AutoModel(String name, boolean isInProduction, List<Year> listOfYears){
        if(listOfYears.isEmpty()){
            throw new IllegalArgumentException("You entered an invalid list of years.");
        }//end if statement
        this.name=name;
        this.isInProduction=isInProduction;
        this.listOfYears=listOfYears;
    }//end constructor

    @Override
    public String toString() {
        return this.name+", in production = "+isInProduction+", release year: "+listOfYears.get(0);
    }

    public List<Year> getListOfYears() {
        return listOfYears;
    }
}
