import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Audi", "A7", new Kasutaja("Tarmo", "TarmoTõnn",
                "tarmotonn@gmail.com", "Tarmo", "Tõnn"));
        System.out.println(car.kasutaja.eesnimi);
        car.carUser();
        System.out.println(car.isNew);
        car.setCar();
    }
}
