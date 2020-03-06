package uqam.inf5153.game.plateau;

import uqam.inf5153.game.parcelle.*;

import java.util.Objects;

public class Irrigation {

    private Parcelle parcelle1;
    private Parcelle parcelle2;
    private static int nbrCanauxIrrigation = 20;

    public Irrigation (Parcelle p1, Parcelle p2)  {
        this.parcelle1 = p1;
        this.parcelle2 = p2;
        p1.setIrriguee(true);
        p2.setIrriguee(true);
    }

    public Parcelle getParcelle1 ()  {
        return parcelle1;
    }

    public Parcelle getParcelle2 ()   {
        return parcelle2;
    }

    public static int getNbrCanauxIrrigation() {
        return nbrCanauxIrrigation;
    }

    public static void setNbrCanauxIrrigation(int nbrCanauxIrrigationRestant) {
        Irrigation.nbrCanauxIrrigation = nbrCanauxIrrigationRestant;
    }

    @Override
    public boolean equals (Object obj)
    {

        if(this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Irrigation)) return false;

        Irrigation irr = (Irrigation) obj;

        return this.parcelle1.equals(irr.parcelle1) &&
                this.parcelle2.equals(irr.parcelle2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcelle1, parcelle2);
    }
}
