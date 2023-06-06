package activities;

import java.util.Arrays;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> colors = new HashMap<Integer, String>();
        colors.put(1, "Red");
        colors.put(2,"Yellow");
        colors.put(3,"Blue");
        colors.put(4,"Pink");
        colors.put(5,"Purple");
        System.out.println("Original Colors are: " + colors);
        colors.remove(4);
        System.out.println("Green color exist in HashMap-> " + colors.containsValue("Green"));
        System.out.println("Size of HaspMap= " + colors.size());


    }
}
