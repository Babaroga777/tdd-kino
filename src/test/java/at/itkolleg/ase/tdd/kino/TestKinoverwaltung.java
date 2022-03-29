package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestKinoverwaltung {
    private Vorstellung vorstellung;
    private KinoVerwaltung kinoVerwaltung = new KinoVerwaltung();
    private KinoSaal ks;

    @BeforeEach
    void anlegen() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 20);
        map.put('C', 15);
        ks = new KinoSaal("Kinosaal1", map);
        vorstellung = new Vorstellung(ks, Zeitfenster.ABEND, LocalDate.of(2022, 10, 26), "Inception", 10F);
        kinoVerwaltung.einplanenVorstellung(vorstellung);
    }

    @Test
    void testVorstellungEinplanen() {
        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> kinoVerwaltung.einplanenVorstellung(vorstellung));
    }

    @Test
    void testTicketKaufen() {
        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> kinoVerwaltung.kaufeTicket(vorstellung, 'P', 8, 10F));

    }

}
