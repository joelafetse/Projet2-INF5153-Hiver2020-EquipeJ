package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleRose;

import static org.junit.Assert.*;

public class ParcelleRoseTest {



    @Test
    public void setVoisins() {
        Parcelle pr1 = new ParcelleRose();
        Coordonnees cr1 = new Coordonnees(0, 2);
        pr1.setCoordonnees(cr1);
        Parcelle pr2 = new ParcelleRose();
        Coordonnees cr2 = new Coordonnees(-2, 1);
        pr2.setCoordonnees(cr2);
        pr1.setVoisins(pr2);
        assertEquals(pr1.getVoisins().get(0), pr2);
    }

    @Test
    public void setIrriguee() {
        Parcelle pr1 = new ParcelleRose();
        pr1.setIrriguee(true);
        assertTrue(pr1.estIrriguee());
    }

    @Test
    public void testEquals() {
        Parcelle pr1 = new ParcelleRose();
        Coordonnees cr1 = new Coordonnees(0, 2);
        pr1.setCoordonnees(cr1);
        Parcelle pr2 = new ParcelleRose();
        Coordonnees cr2 = new Coordonnees(0, 2);
        pr2.setCoordonnees(cr2);
        assertEquals(pr1, pr2);
    }

    @Test
    public void parcellesAdjacentes() {
        Parcelle p1 = new ParcelleRose();
        Coordonnees c1 = new Coordonnees(2, -1);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleRose();
        Coordonnees c2 = new Coordonnees(0, -2);
        p2.setCoordonnees(c2);
        assertTrue(p1.estAdjacent(p2));
    }

    @Test
    public void parcellesNonAdjacentes() {
        Parcelle p1 = new ParcelleRose();
        Coordonnees c1 = new Coordonnees(0, 2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleRose();
        Coordonnees c2 = new Coordonnees(0, -2);
        p2.setCoordonnees(c2);
        assertFalse(p1.estAdjacent(p2));
    }



    @Test
    public void getCouleur() {
        Parcelle p = new ParcelleRose();
        assertEquals(p.getCouleur(), Couleur.ROSE);
    }

    @Test
    public void getCoordonnees() {
        Parcelle p1 = new ParcelleRose();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        assertEquals(p1.getCoordonnees(), c1);
    }

    @Test
    public void estIrriguee() {
        Parcelle p1 = new ParcelleRose();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        p1.setIrriguee(true);
        assertTrue(p1.estIrriguee());
    }

    @Test
    public void setCoordonnees() {
        Parcelle p1 = new ParcelleRose();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        assertEquals(p1.getCoordonnees(), c1);
    }


}