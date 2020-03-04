package uqam.inf5153.game.plateau;

import org.junit.Test;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleEtang;
import uqam.inf5153.game.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class PlateauDeJeuTest {


    @Test
    public void testNbreDeParcelles() {
    PlateauDeJeu plateau = new PlateauDeJeu();
    assertEquals(plateau.nbreDeParcelles(),1);
    }

    @Test
    public void ajouterParcelle() {
        PlateauDeJeu plateau = new PlateauDeJeu();
        ParcelleVerte p =new ParcelleVerte();
        plateau.ajouterParcelle(p);
        assertEquals(plateau.nbreDeParcelles(),2);
    }

    @Test
    public void testPositionOccupee() {
        PlateauDeJeu plateau = new PlateauDeJeu();
        Coordonnees c=new Coordonnees(0,0);
        assertEquals(plateau.estPositionOccupee(c), true);
    }

    @Test
    public void testPositionParcelle() {
        PlateauDeJeu plateau =new PlateauDeJeu();
        assertEquals(plateau.positionParcelle(0,0),0);
    }

    @Test
    public void testMettreAjourListePosiDisp() {
        PlateauDeJeu plateau =new PlateauDeJeu();
        Coordonnees c = new Coordonnees(0,0);
        plateau.mettreAjourListePosiDisp(c);
        assertEquals(plateau.getPositionsDisponibles().size(),6);
    }

    @Test
    public void testNombreVoisinsOccupes() {
        PlateauDeJeu plateau = new PlateauDeJeu();
        Coordonnees c= new Coordonnees(0,0);
        assertEquals(plateau.nombreVoisinsOccupes(c), 2);

    }
}