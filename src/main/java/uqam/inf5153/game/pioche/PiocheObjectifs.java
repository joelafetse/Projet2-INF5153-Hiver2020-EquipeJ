package uqam.inf5153.game.pioche;

import uqam.inf5153.game.objectif.Objectif;

import java.util.List;

public class PiocheObjectifs extends Pioche<Objectif> {


    @Override
    public Objectif piocher(List<Objectif> objectifs) {
        return objectifs.get(0);
    }

    @Override
    public List<Objectif> piocher(int nbrAPiocher, List<Objectif> objectifs){
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher plusieurs objectifs à la fois.");
    }
}
