package uqam.inf5153.game.tuile.amenagement;

import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

public abstract class Amenagement implements ComposantParcelle {

    private Parcelle composant;

    protected Amenagement (Parcelle interne){
           this.composant = interne;
    }


    @Override
    public int getNombreDeBambous() {
        return composant.getNombreDeBambous();
    }
    
    public Parcelle getComposant() {
        return composant;
    }

    /*
     * pour appliquer le pattern Decorateur
     */
    @Override
    public void fairePousserBambou(){
        fairePousserBambouAmenagement(composant);
    }


    protected abstract void fairePousserBambouAmenagement(Parcelle com);




    @Override
    public String toString(){
        return "Parcelle de couleur "+ this.composant.getCouleur()+  " Avec " + this.getClass().getSimpleName()+
                ", nombre de bambous: "+ getNombreDeBambous ();
    }
}
