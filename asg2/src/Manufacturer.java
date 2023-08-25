public class Manufacturer {
    /*
    With the project open in the IDE, create a new java class named Manufacturer. Your class should store as fields the name of the manufacturer and
    the country it’s based in (e.g., Mercedes and Germany). The class should include getters and
    setter methods for each field of the object and appropriate constructors.

Be sure to also override the toString() method so users can print a string representation of the object.
In this case, the string you return should be of the form:

<name>, <country>

(where anything in <..> is replaced by its corresponding field).

For example, if the manufacturer is Mercedes and the country of origin is Germany, then your toString() method should return a string that looks like:

Mercedes, Germany
     */
    private String manufacturerName;
    private String country;


    public Manufacturer(String manufacturerName,String country){
        this.manufacturerName=manufacturerName;
        this.country=country;
    }

    public String getManufacturerName(){
        return this.manufacturerName;
    }

    public void setManufacturerName(String manufacturerName){
        this.manufacturerName=manufacturerName;
    }

    public String getCountry(){
        return this.country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String toString(){
        return this.manufacturerName+", "+this.country;
    }
}
