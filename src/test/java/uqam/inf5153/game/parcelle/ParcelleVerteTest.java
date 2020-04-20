package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class ParcelleVerteTest {



    @Test
    public void setVoisins() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0, 2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(2, 1);
        p2.setCoordonnees(c2);
        p1.setVoisins(p2);
        assertEquals(p1.getVoisins().get(0), p2);
    }

    @Test
    public void setIrriguee() {
        Parcelle p1 = new ParcelleVerte();
        p1.setIrriguee(true);
        assertTrue(p1.estIrriguee());
    }

    @Test
    public void testEquals() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0, 2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(0, 2);
        p2.setCoordonnees(c2);
        assertEquals(p1, p2);
    }

    @Test
    public void parcellesAdjacentes() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(2, -1);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(4, 0);
        p2.setCoordonnees(c2);
        assertTrue(p1.estAdjacent(p2));
    }

    @Test
    public void parcellesNonAdjacentes() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0, 2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(-2, -1);
        p2.setCoordonnees(c2);
        assertFalse(p1.estAdjacent(p2));
    }



    @Test
    public void getCouleur() {
        Parcelle p = new ParcelleVerte();
        assertEquals(p.getCouleur(), Couleur.VERT);
    }

    @Test
    public void getCoordonnees() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        assertEquals(p1.getCoordonnees(), c1);
    }

    @Test
    public void estIrriguee() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        p1.setIrriguee(true);
        assertTrue(p1.estIrriguee());
    }

    @Test
    public void setCoordonnees() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(4, 2);
        p1.setCoordonnees(c1);
        assertEquals(p1.getCoordonnees(), c1);
    }


}