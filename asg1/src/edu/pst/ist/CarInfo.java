package edu.pst.ist;


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Whichever car you choose to model, certain information about it will need to be input such as its make/model,
 * year released (must be a positive number), trim, MPG (must be positive),
 * and the type of car (restrict this to: Truck, Sedan, Coupe, Station Wagon, or Van).
 *
 *
 */

public class CarInfo {

    static public Scanner oldScanner=new Scanner(System.in);
    public static void main(String[] args) {
        //This variable will contain the model of the car
        String model="";
        //This variable will contain the year it was released
        int year=0;
        //This variable will contain the trim
        String[] trim= {};

        ///This variable will contain type of car
        String type="";

        //This variable will contain MPG
        int mpg=0;
        String combined="";

        boolean y=true;
        while(y==true){
            System.out.println();
            System.out.println("What operation would you like to do? R for Read, W for Write, C for Combine, M for Modify Car or Q for quit. If this is your first time, then press M to create/modify your car and then C, to combine!");
            String answer=oldScanner.nextLine();
            switch(answer.toUpperCase()){
                case "R":
                    read();
                    break;
                case "W":
                    write(combined);
                    break;
                case "C":
                    combined=combine(model,year,trim,type,mpg);
                    break;
                case "M":
                    model=getModel();
                    year=getYear();
                    trim=getTrim();
                    type=getType();
                    mpg=getMPG();
                    break;
                case "Q":
                    y=false;
                    break;
                default:
                    System.out.println("You entered an invalid answer. Please try again.");
            }
        }
        System.out.println("Thank you for playing. I hope you enjoyed!");
    }//end main method


    public static String getModel(){
        System.out.println("Please enter the model of your car: ");
        return oldScanner.nextLine();
    }

    public static int getYear(){
        boolean y=true;
        int carYear=0;
        while(y==true){
            System.out.println("Please enter the year your car was made: ");
            int year=oldScanner.nextInt();
            oldScanner.nextLine();
            if(year<=0){
                System.out.println("The year you entered is invalid.");
            }else{
                y=false;
                carYear=year;
            }
        }
        return carYear;
    }

    public static String[] getTrim(){
        System.out.println("Please enter the trim of your car. If you have multiple, please seperate each one with a , like (DX,LX,WRX)!");
        return oldScanner.nextLine().split(",");
    }


    //Types of Car that are valid:  Truck, Sedan, Coupe, Station Wagon, or Van
    public static String getType(){
        boolean y=true;
        String carType="";
        while(y==true){
            System.out.println("Please enter the type of your car: ");
            String type = oldScanner.nextLine();
            switch(type.toLowerCase()){
                case "truck":
                    carType="Truck";
                    y=false;
                    break;
                case "sedan":
                    carType="Sedan";
                    y=false;
                    break;
                case "coupe":
                    carType="Coupe";
                    y=false;
                    break;
                case "station wagon":
                    carType="Station Wagon";
                    y=false;
                    break;
                case "van":
                    carType="Van";
                    y=false;
                    break;
                default:
                    System.out.println("You entered an invalid car type!");

            }
        }
        return carType;
    }//end method

    public static int getMPG(){
        boolean y=true;
        int carMPG=0;
        while(y==true){
            System.out.println("Please enter your car's MPG or Miles per Gallon: ");
            int mpg=oldScanner.nextInt();
            oldScanner.nextLine();
            if(mpg<=0){
                System.out.println("The MPG you entered is invalid.");
            }else{
                y=false;
                carMPG=mpg;
            }
        }
        return carMPG;
    }


    public static String combine(String model, int year, String[] trim, String type, int mpg){
        String answer="Car Model: "+model+"\nYear Made: "+year;
        if(trim.length==1){
            answer+="\nTrim: "+trim[0];
        }else{
            String listOfTrim=trim[0];
            for(int i=1;i<trim.length;i++){
                listOfTrim+=(", "+trim[i]);
            }
            answer+="\nTrim: "+listOfTrim;
        }
        answer+="\nCar Type: "+type+"\nCar MPG: "+mpg;
        return answer;
    }

    public static void write(String combined){
        try(FileWriter fw=new FileWriter(new File("car.txt"))){
            fw.write(combined);
        }catch(Exception e){
            System.err.println("the file you are trying to write it into does not exist");
        }

    }

    public static void read(){
        try(Scanner s=new Scanner(new File("car.txt"))){
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
        }catch(Exception e){
            System.err.println("Cannot find the file car.txt. Try writing something to it first!");
        }
    }


}//end public class
