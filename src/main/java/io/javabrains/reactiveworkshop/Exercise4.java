package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

import org.w3c.dom.events.Event;

public class Exercise4 {

    /**
     * Note, the key difference between Mono and Flux:
     * Mono - Async data of 0..1 items
     * Flux - Async data of 0..n
     */

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        //ReactiveSources.intNumberMono().subscribe(event -> System.out.println(event));

        // Get the value from the Mono into an integer variable
        // In this case I have to make sure to block the incoming Mono variable
        
        // --> Just using the block() method, does not account for mono returning Null <--
        // Integer monoVar = ReactiveSources.intNumberMono().block();
        // --> Instead using blockOptional() will be useful <--
        Optional<Integer> monoVar = ReactiveSources.intNumberMono()
                                                .blockOptional();

        System.out.println("Mono Var: " + monoVar);

        // Not needed due too blocking on line 30
        //System.out.println("Press a key to end");
        //System.in.read();
    }

}
