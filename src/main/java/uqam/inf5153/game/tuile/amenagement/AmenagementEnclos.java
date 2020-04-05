package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.Amenagement;

public class AmenagementEnclos extends Amenagement {

    public AmenagementEnclos (Amenagement interne) {
        super(interne);
    }


    @Override
    protected void fairePousserBambouAmenagement(ComposantParcelle com){
        com.fairePousserBambou();
    }

}
