package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.Amenagement;

public class AmenagementEngrais extends Amenagement {

    public AmenagementEngrais (Amenagement interne) {
        super(interne);
    }


    @Override
    protected void fairePousserBambouAmenagement(ComposantParcelle com){
        com.fairePousserBambou();
        com.fairePousserBambou();
        com.fairePousserBambou();
    }
}
