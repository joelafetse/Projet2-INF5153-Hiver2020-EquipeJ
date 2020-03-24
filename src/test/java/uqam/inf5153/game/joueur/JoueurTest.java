package uqam.inf5153.game.joueur;

import org.junit.Test;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.PlateauDeJeu;

import static org.junit.Assert.*;

public class JoueurTest {

    @Test
    public void getPlateauDeJoueur() {

    }

    @Test
    public void placerParcelleDansPlateau() {
        PlateauDeJeu plateau = new PlateauDeJeu();
        Coordonnees c2 = new Coordonnees(2, -1);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Joueur joueur = new Joueur();
        assertTrue(joueur.placerParcelleDansPlateau(plateau, p2, 2, -1));
    }

    @Test
    public void prendreIrrigation() {


    }

    @Test
    public void prendreObjectif() {
    }

    @Test
    public void remplirObjectif() {
    }

    @Test
    public void placerIrrigation() {
    }

    @Test
    public void deplacerJardinier() {
        Coordonnees c1 = new Coordonnees(2, 1);
        Parcelle pDepart = new ParcelleVerte();
        pDepart.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(2, -1);
        Parcelle pDest = new ParcelleVerte();
        pDest.setCoordonnees(c2);
        Figurine jardinier = new Jardinier(pDepart);
        Joueur j = new Joueur();
        j.deplacerJardinier(jardinier, pDest);
        assertTrue(jardinier.getParcelleDepart().equals(pDest));

    }
}