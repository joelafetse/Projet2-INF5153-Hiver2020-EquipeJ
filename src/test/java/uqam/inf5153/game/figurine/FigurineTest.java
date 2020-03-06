package uqam.inf5153.game.figurine;

import org.junit.Test;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleVerte;
import uqam.inf5153.game.plateau.Coordonnees;

import static org.junit.Assert.*;

public class FigurineTest {

    @Test
    public void estDeplaceableSur1() {
        Coordonnees c1 = new Coordonnees(2, 1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(2, -1);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertTrue(jardinier.estDeplaceableSur(p2));
    }

    @Test
    public void estDeplaceableSur2() {
        Coordonnees c1 = new Coordonnees(0, 0);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(2, -1);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertTrue(jardinier.estDeplaceableSur(p2));
    }

    @Test
    public void estDeplaceableSur3() {
        Coordonnees c1 = new Coordonnees(2, -1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(0, -2);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertTrue(jardinier.estDeplaceableSur(p2));
    }

    @Test
    public void estDeplaceableSur4() {
        Coordonnees c1 = new Coordonnees(2, -1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(0, -2);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertTrue(jardinier.estDeplaceableSur(p2));
    }
    @Test
    public void estDeplaceableSur5() {
        Coordonnees c1 = new Coordonnees(0, 0);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(4, 0);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertFalse(jardinier.estDeplaceableSur(p2));
    }
}