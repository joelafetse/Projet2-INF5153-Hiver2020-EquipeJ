package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.amenagement.Amenagement;

public class AmenagementBassin extends Amenagement {

    public AmenagementBassin (Amenagement interne) {
        super(interne);
    }

    @Override
    protected  int BambouSupplementaire(int nbrDeBambous) {
        return nbrDeBambous + 1;
    }
}
