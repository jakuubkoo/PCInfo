package me.jakub.pcinfo.Utils;

public class NumberUtils {

    public boolean isItNumber(String potentialNum){
        try {
            Integer.parseInt(potentialNum);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
