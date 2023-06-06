package activities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Harry");
        myList.add("Ron");
        myList.add("Harmoine");
        myList.add("Dumbledore");
        myList.add("voldemort");

        System.out.println("3rd name of list" + myList.get(2));
        if (myList.contains("Dumbledore")) {
            System.out.println("List contains");
        } else {
            System.out.println("List not contains");
        }

        for (int i=0; i< myList.size();i++){
            System.out.println(myList.get(i));
        }

        myList.remove("voldemort");
        System.out.println("New size of List: " + myList.size());


    }
}
