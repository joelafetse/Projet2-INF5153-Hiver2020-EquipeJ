package uqam.inf5153.game.objectif;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.parcelle.ParcelleVerte;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.PlateauDeJeuTest;

import static org.junit.Assert.*;

public class ObjectifParcelleTest {

    @Test
    public void testAppliquerObjectif1() {
        PlateauDeJeu plateau =new PlateauDeJeu();
        ParcelleVerte p1=new ParcelleVerte();
        p1.setIrriguee(true);
        ParcelleVerte p2=new ParcelleVerte();
        p2.setIrriguee(true);
        ParcelleVerte p3=new ParcelleVerte();
        Joueur joueur =new Joueur();
        joueur.placerParcelleDansPlateau(plateau,p1,2,1);
        joueur.placerParcelleDansPlateau(plateau,p2,0,2);
        joueur.placerParcelleDansPlateau(plateau,p3,2,3);
        ObjectifParcelle objectif =new ObjectifParcelle(1);
        assertEquals(objectif.appliquerObjectif(plateau), 2);

    }

    @Test
    public void testAppliquerObjectif2() {
        PlateauDeJeu plateau =new PlateauDeJeu();
        ObjectifParcelle objectif =new ObjectifParcelle(16);
        assertEquals(objectif.appliquerObjectif(plateau), 0);

    }



}