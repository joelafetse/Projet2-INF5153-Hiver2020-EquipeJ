package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class ParcelleVerteTest {

    @Test
    public void getCoordonnees() {
        Parcelle p = new ParcelleVerte();
        Coordonnees c = new Coordonnees(2,0);
        p.setCoordonnees(c);
        assertEquals(2, p.getCoordonnees().getX());
        assertEquals(0, p.getCoordonnees().getY());
    }

    @Test
    public void estIrriguee() {
        Parcelle p = new ParcelleVerte();
        p.setIrriguee(true);
        assertTrue(p.estIrriguee());
    }

    @Test
    public void setCoordonnees() {
    }

    @Test
    public void setVoisins() {
    }

    @Test
    public void setIrriguee() {
    }

    @Test
    public void testEquals() {
    }

    @Test
    public void testHashCode() {
    }

    @Test
    public void estAdjacent() {
    }

    @Test
    public void parcellesAdjacentes() {
    }

    @Test
    public void testToString() {
    }

    @Test
    public void getCouleur() {
    }

    @Test
    public void getParcelleId() {
    }

}