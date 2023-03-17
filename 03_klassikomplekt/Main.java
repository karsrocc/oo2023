import java.util.ArrayList;
import java.util.Random;

public class Car {
    Kasutaja kasutaja;
    String mark;
    String model;
    int power;
    int mileage;
    boolean isNew;
    public Car(String mark, String model, Kasutaja kasutaja){
        this.mark = mark;
        this.model = model;
        this.isNew = false;
        this.kasutaja = kasutaja;
    }
    public void setCar() {
        Random random = new Random();
        this.power = random.nextInt(300);
        this.mileage = random.nextInt(100000);
        if (this.mileage < 1000) this.isNew = true;
        System.out.println("New car's power: " + this.power);
        System.out.println("New car's milaage: " + this.mileage);
        if (this.power > 400){
            carCool();
        }
    }

    public void carUser(){
        System.out.println(this.kasutaja.eesnimi + " " + this.kasutaja.perenimi);
    }

    private void carCool(){
        System.out.println("Cool powerful car");
    }
}
