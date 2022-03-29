package at.itkolleg.ase.tdd.kino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)

public class TestKinoSaal {

    private KinoSaal kinosaalOriginal;
    private Map<Character, Integer> map = new HashMap<>();
    private Object KinoSaal;

    @Mock
    private KinoSaal kinosaalMock;

    //Saal anlegen
    @BeforeEach
    void anlegen() {
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaalOriginal = new KinoSaal("Kinosaal1", map);
    }

    @Test
    void testKinosaalSitzplätze() {
        assertTrue(kinosaalOriginal.pruefePlatz('A', 10));
        assertTrue(kinosaalOriginal.pruefePlatz('B', 10));
        assertTrue(kinosaalOriginal.pruefePlatz('C', 14));
        assertFalse(kinosaalOriginal.pruefePlatz('A', 11));
    }

    @Test
    void testKinosaalName() {
        assertEquals("Kinosaal1", kinosaalOriginal.getName());
    }

    @Test
    void testKinosaalNameMock() {
        Mockito.when(kinosaalMock.getName()).thenReturn("Kinosaal1");
        assertEquals("Kinosaal1", kinosaalMock.getName());
        Mockito.verify(kinosaalMock).getName();
    }

    @Test
    void testKinosaal() {
        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        KinoSaal = new KinoSaal("Kinosaal1", map);
        kinosaalOriginal.equals(KinoSaal);
    }

    @Test
    void testKinosaalMock() {

        map.put('A', 10);
        map.put('B', 10);
        map.put('C', 15);
        kinosaalMock = new KinoSaal("Kinosaal2", map);
        kinosaalOriginal.equals(kinosaalMock); //vergleicht Kinosaal mit Kinosaalmock
    }
}
