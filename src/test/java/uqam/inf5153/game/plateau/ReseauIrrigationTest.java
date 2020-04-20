package uqam.inf5153.game.plateau;

import org.junit.Test;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import java.util.List;

import static org.junit.Assert.*;

public class ReseauIrrigationTest {

    @Test
    public void ajouterIrragtionAuReseau_1() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0,2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(2,1);
        p2.setCoordonnees(c2);
        Irrigation irr = new Irrigation(p1, p2);
        ReseauIrrigation ri = new ReseauIrrigation(irr);
        ri.ajouterIrragtionAuReseau(irr);
        List<Irrigation> listeIrr =  ri.getIrrigations();
        assertEquals(irr, listeIrr.get(0));

    }

    @Test
    public void ajouterIrragtionAuReseau_2() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0,2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(2,3);
        p2.setCoordonnees(c2);
        Irrigation irr = new Irrigation(p1, p2);
        ReseauIrrigation ri = new ReseauIrrigation(irr);
        ri.ajouterIrragtionAuReseau(irr);
        List<Irrigation> listeIrr =  ri.getIrrigations();
        assertEquals(irr, listeIrr.get(0));

    }


    @Test
    public void ajouterIrragtionAuReseau_3() {
        Parcelle p1 = new ParcelleVerte();
        Coordonnees c1 = new Coordonnees(0,2);
        p1.setCoordonnees(c1);
        Parcelle p2 = new ParcelleVerte();
        Coordonnees c2 = new Coordonnees(2,1);
        p2.setCoordonnees(c2);
        Parcelle p3 = new ParcelleVerte();
        Coordonnees c3 = new Coordonnees(2,3);
        p2.setCoordonnees(c3);
        Irrigation irr = new Irrigation(p1, p2);
        Irrigation irr2 = new Irrigation(p2, p3);
        ReseauIrrigation ri = new ReseauIrrigation(irr);
        ri.ajouterIrragtionAuReseau(irr);
        ri.ajouterIrragtionAuReseau(irr2);
        List<Irrigation> listeIrr =  ri.getIrrigations();
        assertEquals(irr, listeIrr.get(0));

    }

}