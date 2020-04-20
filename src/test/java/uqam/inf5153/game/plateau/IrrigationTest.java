package uqam.inf5153.game.plateau;

import org.junit.Test;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class IrrigationTest {



    @Test
    public void estIrriguee() {
        Parcelle p1 = new ParcelleVerte();
        Parcelle p2 = new ParcelleVerte();
        Irrigation ir = new Irrigation(p1, p2);
        assertTrue(ir.getParcelle1().estIrriguee());
    }

    @Test
    public void testEquals() {
        Coordonnees c1 = new Coordonnees(2, 1);
        Parcelle p1 = new ParcelleVerte();
        p1.setCoordonnees(c1);
        Coordonnees c2 = new Coordonnees(0, 2);
        Parcelle p2 = new ParcelleVerte();
        p2.setCoordonnees(c2);
        Irrigation irr1 = new Irrigation(p1, p2);
        Irrigation irr2 = new Irrigation(p1, p2);
        assertEquals(irr1, irr2);
    }


}