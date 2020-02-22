package uqam.inf5153.game;

import uqam.inf5153.game.parcelle.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Irrigation {

    private int id;
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

    public void setParcelle1 (Parcelle parcelle1) {
        this.parcelle1 = parcelle1;
    }

    public Parcelle getParcelle2 ()   {
        return parcelle2;
    }

    public void setParcelle2 (Parcelle parcelle2)  {
        this.parcelle2 = parcelle2;
    }

    private Set<Parcelle> getParcelles ()  {
        return new HashSet<>(Arrays.asList(this.parcelle1, this.parcelle2));
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null || !(obj instanceof Irrigation)) return false;

        Irrigation irr = (Irrigation) obj;

        return this.getParcelles().equals(irr.getParcelles());
    }

}
