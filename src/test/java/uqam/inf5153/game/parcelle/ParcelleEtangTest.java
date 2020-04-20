package uqam.inf5153.game.parcelle;

import org.junit.Test;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleEtang;

import static org.junit.Assert.*;

public class ParcelleEtangTest {

    @Test
    public void getCoordonnees() {
        Coordonnees c0 = new Coordonnees(0,0);
        Parcelle pe = new ParcelleEtang(c0);
        assertEquals(pe.getCoordonnees(), c0);
    }

    @Test
    public void estIrriguee() {
        Coordonnees c0 = new Coordonnees(0, 0);
        Parcelle pe = new ParcelleEtang(c0);
        pe.setIrriguee(true);
        assertTrue(pe.estIrriguee());
    }

    @Test
    public void getCouleur() {
        Coordonnees c0 = new Coordonnees(0,0);
        Parcelle pe = new ParcelleEtang(c0);
        assertEquals(pe.getCouleur(), Couleur.NONE);
    }


}