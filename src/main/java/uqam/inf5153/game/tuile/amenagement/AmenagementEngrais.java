package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.amenagement.Amenagement;

public class AmenagementEngrais extends Amenagement {

    public AmenagementEngrais (Amenagement interne) {
        super(interne);
    }

    @Override
    protected  int bambouSupplementaire(int nbrDeBambous) {
        return nbrDeBambous + 2;
    }
}
