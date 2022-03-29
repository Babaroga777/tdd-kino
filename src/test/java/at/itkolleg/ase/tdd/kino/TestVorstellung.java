package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class TestVorstellung {

    private Vorstellung vorstellung;
    private KinoSaal kinosaal;
    private Map<Character, Integer> map = new HashMap<>();

    @Mock
    private Vorstellung vorstellungMock;

    //Saal und Vorstellung anlegen
    @BeforeEach
    void anlegen() {
        map.put('A', 15);
        map.put('B', 20);
        map.put('C', 30);
        kinosaal = new KinoSaal("Kinosaal1", map);
        vorstellung = new Vorstellung(kinosaal, Zeitfenster.ABEND, LocalDate.of(
                2022, 03, 25), "Inception", 10F);
    }

    @Test
    void testVorstellungNamen() {
        assertEquals("Inception", vorstellung.getFilm(), "Name fehlerhaft!");
    }

    @Test
    void testVorstellungNamenMock() {
        Mockito.when(vorstellungMock.getFilm()).thenReturn("Inception");
        assertEquals("Inception", vorstellungMock.getFilm());

    }


    @Test
    void testVorstellungGetZeitfenster() {
        assertEquals(Zeitfenster.ABEND, vorstellung.getZeitfenster(), "Zeitfensterfehler!");
    }

    @Test
    void testVorstellungGetDatum() {
        assertEquals(LocalDate.of(2022, 03, 25), vorstellung.getDatum(), "Datumfehler!");

    }

    @Test
    void testVorstellungGetSaal() {
        map.put('A', 15);
        map.put('B', 20);
        map.put('C', 30);
        kinosaal = new KinoSaal("Kinosaal1", map);
        assertEquals("Kinosaal1", vorstellung.getSaal().getName());
    }

    @Test
    void testVorstellungGetSaalMock() {
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaal = new KinoSaal("Kinosaal1", map);
        Mockito.when(vorstellungMock.getSaal()).thenReturn(kinosaal);
        assertEquals(vorstellungMock.getSaal().getName(), vorstellung.getSaal().getName());
    }

    @Test
    void testKaufeTicket() {
        Assertions.assertThrows(IllegalArgumentException.class, ()
                -> vorstellung.kaufeTicket('A', 1, 1F), "Ticketfehler!");
    }
}
