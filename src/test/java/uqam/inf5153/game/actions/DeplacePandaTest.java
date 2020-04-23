package uqam.inf5153.game.actions;

import org.junit.Test;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Panda;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class DeplacePandaTest {

    @Test
    public void pandaEstDeplaceableSur1() {
        Coordonnees c1 = new Coordonnees(0, 0);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(4, 0);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertFalse(panda.estDeplaceableSur(p2));
    }

    @Test
    public void pandaEstDeplaceableSur2() {
        Coordonnees c1 = new Coordonnees(2, -1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(0, -2);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertTrue(panda.estDeplaceableSur(p2));
    }

    @Test
    public void pandaEstDeplaceableSur3() {
        Coordonnees c1 = new Coordonnees(0, 0);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(-4, 0);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertFalse(panda.estDeplaceableSur(p2));
    }

    @Test
    public void pandaEstDeplaceableSur4() {
        Coordonnees c1 = new Coordonnees(-6, 1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(-2, -1);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertTrue(panda.estDeplaceableSur(p2));
    }

    @Test
    public void pandaEstDeplaceableSur5() {
        Coordonnees c1 = new Coordonnees(-4, 2);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(6, -1);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertTrue(panda.estDeplaceableSur(p2));
    }

    @Test
    public void pandaEstDeplaceableSur6() {
        Coordonnees c1 = new Coordonnees(-4, -2);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(0, -4);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine panda = new Panda(p1);
        assertTrue(panda.estDeplaceableSur(p2));
    }



}