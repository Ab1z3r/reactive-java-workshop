package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.concurrent.Flow.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
            next -> {
                System.out.println(next + " recieved");
                //
            },
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Completed")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

// Implementation of a custom Subscriber is invaluable when you need control of the flow
// In a sense you have control of backpressure 
class MySubscriber<T> extends BaseSubscriber<T>{
    public void hookOnSubscribe(Subscription sub){
        System.out.println("Subscribed");
        request(1);
    }
    public void hookOnNext(T val){
        System.out.println(val + " recieved");
        request(1);
    }
    public void hookOnError(Throwable throwable){
        System.out.println(throwable.getMessage());
    }
     public void hookOnComplete(){
        System.out.println("Complete");
    }
}