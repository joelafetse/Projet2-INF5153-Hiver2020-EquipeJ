package uqam.inf5153.game.joueur;

import uqam.inf5153.game.objectif.Objectif;

import java.util.ArrayList;
import java.util.List;

/**
 * Réprésente le plateau d'un joueur donné.
 */
public class PlateauDeJoueur {

    // Bambous collectionnés via le panda //TODO
    //private List<Bambou> bambous;

    // Objectifs accomplis
    private List<Objectif> objectifsAccomplis;

    // Objectifs piochés
    private List<Objectif> objectifsPioches;

    // Nombre  de canaux d'irrigations collectionnés
    private int irrigations;


    public PlateauDeJoueur(){
        //bambous = new ArrayList<>();
        objectifsPioches = new ArrayList<>();
        objectifsAccomplis = new ArrayList<>();
        irrigations = 0;
    }

    public int getIrrigations() {
        return irrigations;
    }

    public int getNombreObjectifsAccomplis(){
        return this.objectifsAccomplis.size();
    }
    public List<Objectif>  getObjectifsPioches(){
        return objectifsPioches;
    }

    public void setObjectifsPioches(List<Objectif> objectifsPioches){
        this.objectifsPioches = objectifsPioches;
    }
    public void ajouterIrrigations() {
        this.irrigations++;
    }
    public void retirerIrrigation() { this.irrigations--; }

    public void afficherObjectifsPioches(){
        for (Objectif obj: objectifsPioches){
            System.out.println(obj);
        }
    }
}
