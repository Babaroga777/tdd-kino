package at.itkolleg.ase.tdd.kino;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Dieses Beispiel stammt aus https://training.cherriz.de/cherriz-training/1.0.0/testen/junit5.html
 */
public class App 
{
    public static void main( String[] args )
    {

        //Saal anlegen
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',10);
        map.put('C',15);
        KinoSaal ks = new KinoSaal("Kinosaal1",map);

        //Platz prüfen
        System.out.println(ks.pruefePlatz('A',11));
        System.out.println(ks.pruefePlatz('A',10));
        System.out.println(ks.pruefePlatz('B',10));
        System.out.println(ks.pruefePlatz('C',14));

        //Vorstellung anlegen
        Vorstellung inception = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, 03, 25), "Inception", 10F);

        //Verwaltung anlegen
        KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
        kinoVerwaltung.einplanenVorstellung(inception);
        System.out.println("Vorstellungen: " + kinoVerwaltung);

        //Vorstellung prüfen
        System.out.println(inception.getSaal());
        System.out.println(inception.getFilm());
        System.out.println(inception.getDatum());
        System.out.println(inception.getZeitfenster());

        //Ticket kaufen
        Ticket ticket1 = inception.kaufeTicket('A', 1, 10F);
        System.out.println("Kinoticket: " + ticket1);

    }
}
