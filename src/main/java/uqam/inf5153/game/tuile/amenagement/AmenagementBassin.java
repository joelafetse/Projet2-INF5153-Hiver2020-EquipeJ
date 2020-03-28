package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.tuile.amenagement.Amenagement;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.List;

public class AmenagementBassin extends Amenagement {

    public AmenagementBassin (Amenagement interne) {
        super(interne);
    }

    @Override
    protected  int bambouSupplementaire(int nbrDeBambous) {

        return nbrDeBambous + 1;
    }

    /*@Override
    public void setBambous() {

    }*/
}
