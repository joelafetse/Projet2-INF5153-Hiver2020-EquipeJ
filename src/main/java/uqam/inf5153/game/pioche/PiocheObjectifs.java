package uqam.inf5153.game.pioche;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Parcelle;

import java.util.List;

public class PiocheObjectifs extends Pioche<Objectif> {


    @Override
    public Objectif piocher() {
        return objetsAPiocher.get(0);
    }

    @Override
    public List<Objectif> piocher(int nbrAPiocher){
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher plusieurs objectifs à la fois.");
    }


}
