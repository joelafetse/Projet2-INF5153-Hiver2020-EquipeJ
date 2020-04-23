package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;

import static org.junit.Assert.*;

public class ParcelleTest {

    @Test
    public void parcellesNonAdjacentes() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(2, -3);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(-2, 3);
        pj2.setCoordonnees(cj2);
        assertFalse(pj1.estAdjacent(pj2));
    }

    @Test
    public void parcellesAdjacentes1() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(-2, -3);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(-4, -4);
        pj2.setCoordonnees(cj2);
        assertTrue(pj1.estAdjacent(pj2));
    }

    @Test
    public void parcellesAdjacentes2() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(0, -4);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(-2, -5);
        pj2.setCoordonnees(cj2);
        assertTrue(pj1.estAdjacent(pj2));
    }

    @Test
    public void getCoordonnees() {
    }

    @Test
    public void estIrriguee() {
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
    public void getCouleur() {
    }

    @Test
    public void getParcelleId() {
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
    public void testToString() {
    }


}