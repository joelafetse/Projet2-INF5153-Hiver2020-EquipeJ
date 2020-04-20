package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;

import static org.junit.Assert.*;

public class ParcelleJauneTest {



    @Test
    public void setVoisins() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(0, 2);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(0, 2);
        pj2.setCoordonnees(cj2);
        pj1.setVoisins(pj2);
        assertEquals(pj1.getVoisins().get(0), pj2);
    }

    @Test
    public void setIrriguee() {
        Parcelle pj1 = new ParcelleJaune();
        pj1.setIrriguee(true);
        assertTrue(pj1.estIrriguee());
    }

    @Test
    public void testEquals() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(0, 2);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(0, 2);
        pj2.setCoordonnees(cj2);
        assertEquals(pj1, pj2);
    }

    @Test
    public void parcellesAdjacentes() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(0, 2);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(2, 1);
        pj2.setCoordonnees(cj2);
        assertTrue(pj1.estAdjacent(pj2));
    }

    @Test
    public void parcellesNonAdjacentes() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(0, 2);
        pj1.setCoordonnees(cj1);
        Parcelle pj2 = new ParcelleJaune();
        Coordonnees cj2 = new Coordonnees(0, -2);
        pj2.setCoordonnees(cj2);
        assertFalse(pj1.estAdjacent(pj2));
    }



    @Test
    public void getCouleur() {
        Parcelle pj = new ParcelleJaune();
        assertEquals(pj.getCouleur(), Couleur.JAUNE);
    }

    @Test
    public void getCoordonnees() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(4, 2);
        pj1.setCoordonnees(cj1);
        assertEquals(pj1.getCoordonnees(), cj1);
    }

    @Test
    public void estIrriguee() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(4, 2);
        pj1.setCoordonnees(cj1);
        pj1.setIrriguee(true);
        assertTrue(pj1.estIrriguee());
    }

    @Test
    public void setCoordonnees() {
        Parcelle pj1 = new ParcelleJaune();
        Coordonnees cj1 = new Coordonnees(4, 2);
        pj1.setCoordonnees(cj1);
        assertEquals(pj1.getCoordonnees(), cj1);
    }


}