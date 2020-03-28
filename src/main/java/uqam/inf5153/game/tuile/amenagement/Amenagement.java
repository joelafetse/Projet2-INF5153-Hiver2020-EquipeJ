package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;

public abstract class Amenagement implements ComposantParcelle {

    private ComposantParcelle composant;

    protected Amenagement (ComposantParcelle interne){
           this.composant = interne;
    }


    /*
     * pour appliquer le pattern Decorateur
     */
    @Override
    public int getNombreDeBambous() {
        return bambouSupplementaire (composant.getNombreDeBambous());
    }

    /*
     * pour appliquer le pattern Decorateur
     */
    protected abstract int bambouSupplementaire(int nbrDeBambous);

}
