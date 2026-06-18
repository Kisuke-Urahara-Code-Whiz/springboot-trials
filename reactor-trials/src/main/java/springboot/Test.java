package springboot;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Main.sendFlux().subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));

        Main.sendFlux().subscribe(
                new BackPressureHandler()
        );

        Thread.sleep(12000);

    }



}
