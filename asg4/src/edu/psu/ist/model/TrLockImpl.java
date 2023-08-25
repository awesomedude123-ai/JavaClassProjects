package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.List;

public class TrLockImpl implements IDialLock{

    private int maxTicks,s1,s2,s3,currentTick;
    private List<Turn> moves;

    public TrLockImpl(int maxTicks, int s1, int s2, int s3){
        if(maxTicks<0 || s1<0||s2<0||s3<0){
            throw new IllegalArgumentException("secret digits cannot be negative");
        }

        this.maxTicks=maxTicks+1;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        moves=new ArrayList<>();
        String y="";
    }


    @Override
    public void reset() {
        currentTick=0;
        moves.clear();
    }

    @Override
    public void left(int t) {

        if(currentTick-t<0){
            currentTick=maxTicks-t;
        }else{
            currentTick=currentTick-t;
        }
        Turn x=new Turn(Turn.Direction.L,currentTick);
        moves.add(x);

    }

    @Override
    public void right(int t) {
        currentTick=(currentTick+t)%maxTicks;
        Turn x=new Turn(Turn.Direction.R,currentTick);
        moves.add(x);
    }

    @Override
    public int currentTick() {
        return currentTick;
    }

    @Override
    public boolean pull() {
        if(moves.size()==0){
            return false;
        }
        List<Turn> firstRight =new ArrayList<>();
        List<Turn> secondLeft=new ArrayList<>();
        List<Turn> thirdRight=new ArrayList<>();
        boolean z=true,y=true;
        for(int i=0;i<moves.size();i++){
            Turn t=moves.get(i);
            if(y==true && z==true){
                if(t.dir== Turn.Direction.R){
                    firstRight.add(t);
                }else{
                    y=false;
                    secondLeft.add(t);
                }
            }else if(y==false && z==true){
                if(t.dir== Turn.Direction.L){
                    secondLeft.add(t);
                }else{
                    z=false;
                    thirdRight.add(t);
                }
            }else{
                thirdRight.add(t);
            }
        }//end for loop
        if(firstRight.isEmpty() || secondLeft.isEmpty()|| thirdRight.isEmpty()) {
            return false;
        }else if(firstRight.size()+secondLeft.size()+thirdRight.size()!=moves.size()){
            return false;
        }else{
            if(firstRight.get(firstRight.size()-1).stopDigit==s1){
                if(secondLeft.get(secondLeft.size()-1).stopDigit==s2){
                    if(thirdRight.get(thirdRight.size()-1).stopDigit==s3){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }//end if statement
    }//end pull method

    @Override
    public String toString() {
        return "Secret digits: (" +
                s1 +
                ", " + s2 +
                ", " + s3 +
                ')';
    }
}
