package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;

public abstract class Amenagement implements ComposantParcelle {

    private ComposantParcelle composant;

    protected Amenagement (ComposantParcelle interne){
           this.composant = interne;
    }
    @Override
    public int getNombreDeBambous() {
        return bambouSupplementaire (composant.getNombreDeBambous());
    }
    protected abstract int bambouSupplementaire(int nbrDeBambous);
}
