package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.Amenagement;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

public class AmenagementEnclos extends Amenagement {

    public AmenagementEnclos (Parcelle interne) {
        super(interne);
    }


    @Override
    protected void fairePousserBambouAmenagement(Parcelle com){
        com.fairePousserBambou();
    }

    @Override
    protected Bambou mangerBambouAmenagement(Parcelle com){
        return null;
    }

}
