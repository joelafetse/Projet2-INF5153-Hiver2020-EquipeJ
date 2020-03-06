package uqam.inf5153.game.plateau;

import org.junit.Test;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleVerte;

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
    public void getParcelle2() {
    }

    @Test
    public void getNbrCanauxIrrigation() {
    }

    @Test
    public void setNbrCanauxIrrigation() {

    }

    @Test
    public void testEquals() {
        Parcelle p1 = new ParcelleVerte();
        Parcelle p2 = new ParcelleVerte();
        Irrigation irr1 = new Irrigation(p1, p2);
        Irrigation irr2 = new Irrigation(p1, p2);
        assertTrue(irr1.equals(irr2));
    }

    @Test
    public void testHashCode() {
    }
}