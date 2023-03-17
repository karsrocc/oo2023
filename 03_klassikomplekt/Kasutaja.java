import javax.xml.crypto.Data;
import java.util.Date;

public class Kasutaja {
    String kasutajanimi;
    String parool;
    String email;
    String eesnimi;
    String perenimi;
    boolean aktiivne;
    Date loomisaeg;
    Date kustutamisAeg;

    public Kasutaja(String kasutajanimi, String parool, String email, String eesnimi, String perenimi){
        this.kasutajanimi = kasutajanimi;
        this.parool = parool;
        this.email = email;
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.aktiivne = true;
        this.loomisaeg = new Date();
        this.kustutamisAeg = null;
    }

    public String kustutaKasutaja(){
        this.aktiivne = false;
        this.kustutamisAeg = new Date();
        return "Kasutaja kustutatud."; 

    public void muudaParool(String uusParool){
        this.parool= parool;
        System.out.println("Parool muudetud!");;
    }
}
