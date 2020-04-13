package uqam.inf5153.game.actions;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class DeplaceJardinierTest {

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
        Coordonnees c2 = new Coordonnees(4, 0);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(p1);
        assertFalse(jardinier.estDeplaceableSur(p2));
        Jeu jeu = new Jeu(2);
        Action dp = new DeplaceJardinier(jeu);
        ComposantParcelle cp = new ParcelleVerte();
        //assertFalse(dp.executer(1));



    }

}