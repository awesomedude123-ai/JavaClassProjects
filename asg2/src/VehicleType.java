public class VehicleType {
    enum Kind{
        Truck, Car, Coupe, Station_Wagon, Van;
    }//end enum
    private Kind carKind;
    private int wheels;
    public VehicleType(int wheels,Kind carKind) throws IllegalAccessException {
        if(wheels>2&&wheels<6){
            this.wheels=wheels;
            this.carKind=carKind;
        }else{
            throw new IllegalAccessException("invalid number of wheels");
        }
    }

    public String toString(){
        return carKind.toString()+", wheels: "+wheels;
    }
}
