import java.util.ArrayList;
import java.util.Collections;

public class Garage {
    private ArrayList<Vehicle> vehicles=new ArrayList<>();


    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public void emptyGarage(){
        vehicles.clear();
    }

    public void sortByReleaseYear(){
        Collections.sort(vehicles);
    }

    @Override
    public String toString() {
        String answer="";
        for(Vehicle i: vehicles){
            answer+=i.toString()+"\n";
        }
        return answer;
    }
}
