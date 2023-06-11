package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns

        // -> In this case count returns a Mono that we can subscribe too when the Flux
        // -> encounters a terminal events
        // ReactiveSources.intNumbersFlux().count().subscribe(num -> System.out.println(num));

        // Collect all items of intNumbersFlux into a single list and print it
        // ReactiveSources.intNumbersFlux().collectList().subscribe(num -> System.out.println(num));

        // Transform to a sequence of sums of adjacent two numbers
        // The buffer operator is such ->    flux.buffer(n) every n events in flux results in 1 event from buffer

        ReactiveSources.intNumbersFlux().buffer(2)
                        .map(lst -> lst.get(0) + lst.get(1))
                        .subscribe(num -> System.out.println(num));
        
        System.out.println("Press a key to end");
        System.in.read();
    }

}
