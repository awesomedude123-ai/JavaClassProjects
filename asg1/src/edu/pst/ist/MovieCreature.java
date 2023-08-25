package edu.pst.ist;

public class MovieCreature {
    enum CreatureSize {SMALL, MEDIUM, LARGE}
    private String name;
    private int dateOfBirth;
    private int dateOfDeath;
    CreatureSize size;


    public MovieCreature(String name, int dateOfBirth, int dateOfDeath,CreatureSize size){
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.dateOfDeath=dateOfDeath;
        this.size=size;
    }

    public MovieCreature(String name, int dateOfBirth,CreatureSize size){
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        dateOfDeath=-1;
        this.size=size;
    }//end

    public CreatureSize getSize(){
        return this.size;
    }

    public String getName(){
        return this.name;
    }

    public int getDeathYear(){
        return this.dateOfDeath;
    }

    public void setDeathYear(int dateOfDeath){
        this.dateOfDeath=dateOfDeath;
    }

    public boolean isAlive(){
        if(dateOfDeath>=0){
            return false;
        }else{
            return true;
        }
    }//end method

    public String toString(){
        return "creature: "+this.name+", "+this.size+", ("+this.dateOfBirth+"), still around today? "+isAlive();
    }

}
