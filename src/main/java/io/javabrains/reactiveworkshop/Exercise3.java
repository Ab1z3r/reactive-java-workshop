package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        // Note that by converting Flux -> Stream we are essentially creating a blocking line
         List<Integer> list = ReactiveSources.intNumbersFlux()
                                        .toStream()
                                        .toList();
        System.out.println("List is: " + list);
        System.out.println("Len(list): " + list.size());

        // Not needed due too blocking on line 18
        //System.out.println("Press a key to end");
        //System.in.read();
    }
}
