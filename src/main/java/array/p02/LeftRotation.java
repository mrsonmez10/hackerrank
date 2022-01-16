package array.p02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftRotation{

    public static List<Integer> rotLeft(List<Integer> a, int d){
        int sizeOfa = a.size();
        List<Integer> nTimesShiftedList = new ArrayList<>(); // giving size is not must for arraylists
        for (int i = 0; i < a.size(); i++) {
            nTimesShiftedList.add(0);
        }
        if(isShiftable(a)){
            for(int i = 0; i < sizeOfa; i++){
                int diff = i - d;
                if(diff >= 0){
                    nTimesShiftedList.set(diff, a.get(i));
                } else{
                    int index = diff + sizeOfa;
                    nTimesShiftedList.set(index, a.get(i));
                }
            }
        }
        return nTimesShiftedList;
    }

    public static boolean isShiftable(List<Integer> a){
        if(a.size() == 1 || a.isEmpty()){
            return false;
        }
        return true;
    }

}
