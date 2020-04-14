package uqam.inf5153.game.objectif;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.actions.PlaceParcelle;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.AmenagementBassin;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class ObjectifJardinierTest {

        @Test
        public void testAppliquerObjectif_1() {
            //4 bambous jaunes sur une parcelle jaune avec amenagement bassain point=5
            PlateauDeJeu plateau =new PlateauDeJeu();
            ComposantParcelle p1=new AmenagementBassin(new ParcelleJaune());
            Jeu jeu=new Jeu(2);
            PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
            placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
            p1.getComposant().setIrriguee(true);
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            ObjectifJardinier objectif =new ObjectifJardinier(16);
            assertEquals(objectif.appliquerObjectif(plateau), 5);

        }

}