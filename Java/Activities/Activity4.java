package activities;

import java.util.Arrays;

public class Activity4 {
    static void Sort (int[] num){
        int size = num.length, temp;
        int i,j;
        for (j=0; j<size; j++){
            for (i=j+1; i<size; i++){
                if (num[j]>num[i]){
                    temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,10,12,1,5,6};
        System.out.println(Arrays.toString(arr));
       Sort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));

    }
}
