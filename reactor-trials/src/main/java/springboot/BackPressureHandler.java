package springboot;

import org.reactivestreams.Subscription;

import java.util.List;

import reactor.core.publisher.BaseSubscriber;

public class BackPressureHandler extends BaseSubscriber<Integer> {

    List<Integer> result;
    List<Integer> buffer;

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        request(2);
    }

    @Override
    protected void hookOnNext(Integer value) {
        System.out.println("Received: " + value);
        request(2);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Completed");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("Error: " + throwable.getMessage());
    }
}