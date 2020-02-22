package uqam.inf5153.game.plateau;

import uqam.inf5153.game.parcelle.*;

public class Irrigation {

    private Parcelle parcelle1;
    private Parcelle parcelle2;

    public Irrigation () {

    }

    public Irrigation (Parcelle p1, Parcelle p2)  {
        this.parcelle1 = p1;
        this.parcelle2 = p2;
    }

    public Parcelle getParcelle1 ()  {
        return parcelle1;
    }

    public Parcelle getParcelle2 ()   {
        return parcelle2;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null || !(obj instanceof Irrigation)) return false;

        Irrigation irr = (Irrigation) obj;

        return this.parcelle1.equals(irr.parcelle1) &&
                this.parcelle2.equals(irr.parcelle2);
    }

}
