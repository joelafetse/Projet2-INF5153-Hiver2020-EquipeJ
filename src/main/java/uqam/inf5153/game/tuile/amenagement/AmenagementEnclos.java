package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.amenagement.Amenagement;

public class AmenagementEnclos extends Amenagement {

    public AmenagementEnclos (Amenagement interne) {
        super(interne);
    }

    @Override
    protected  int BambouSupplementaire(int nbrDeBambous) {
        return nbrDeBambous;
    }

}
