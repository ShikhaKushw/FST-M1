package activities;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs= new HashSet<>();

        hs.add("Add");
        hs.add("Subtract");
        hs.add("Multiply");
        hs.add("Division");
        hs.add("Square");
        hs.add("Cube");
        System.out.println("Size of hashSets:  " + hs.size());
        hs.remove("Square");
        hs.remove("Integration");
        System.out.println("If Cube is present in HashSets " + hs.contains("Cube"));
        System.out.println("Update hashSets: " + hs);
    }
}
