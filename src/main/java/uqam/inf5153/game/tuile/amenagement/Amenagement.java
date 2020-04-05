package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;

public abstract class Amenagement implements ComposantParcelle {

    private ComposantParcelle composant;

    protected Amenagement (ComposantParcelle interne){
           this.composant = interne;
    }


    @Override
    public int getNombreDeBambous() {
        return composant.getNombreDeBambous();
    }

    /*
     * pour appliquer le pattern Decorateur
     */
    @Override
    public void fairePousserBambou(){
        fairePousserBambouAmenagement(composant);
    }


    protected abstract void fairePousserBambouAmenagement(ComposantParcelle com);
}
