package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("--- P1 ---");
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));
        
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("--- P2 ---");
        StreamSources.intNumbersStream().filter(num -> num < 5)
                                        .forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("--- P3 ---");
        StreamSources.intNumbersStream().filter(num -> num > 5)
                                        .skip(1)
                                        .limit(2)
                                        .forEach(num -> System.out.println(num));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("--- P4 ---");
        Integer first_num = StreamSources.intNumbersStream().filter(num -> num > 5)
                                        .findFirst()
                                        .orElse(-1);
        System.out.println(first_num);

        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("--- P5 ---");
        StreamSources.userStream().forEach(user_val -> System.out.println(user_val.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("--- P6 ---");
        StreamSources.intNumbersStream()
                    .flatMap(num -> StreamSources.userStream().filter(usr -> num == usr.getId()))
                    .forEach(user -> System.out.println(user));

    }

}
