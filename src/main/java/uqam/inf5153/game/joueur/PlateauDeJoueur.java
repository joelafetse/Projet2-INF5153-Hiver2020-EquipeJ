package uqam.inf5153.game.joueur;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.objectif.ObjectifParcelle;

import java.util.ArrayList;
import java.util.List;

/**
 * Réprésente le plateau d'un joueur donné.
 */
public class PlateauDeJoueur {


    private final int NBRE_OBJECTIFS_PIOCHES_MAX = 5;
    private  final int NBRE_CHAQUE_AMENAGEMENT = 3;

    // Bambous collectionnés via le panda //TODO
    //private List<Bambou> bambousPanda;

    // Objectifs accomplis
    private List<Objectif> objectifsAccomplis;

    // Objectifs piochés
    private List<Objectif> objectifsPioches;

    // Nombre  de canaux d'irrigations collectionnés
    private int irrigations;

    private int amenagementBassins = NBRE_CHAQUE_AMENAGEMENT;


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

    public void ajouterObjectif(Objectif obj){
        this.objectifsPioches.add(obj);
    }

    public void ajouterObjectifAccomplis(Objectif obj) {
        this.objectifsAccomplis.add(obj);
    }

    public boolean peutAjouterObjectif(){
        return this.objectifsPioches.size() < NBRE_OBJECTIFS_PIOCHES_MAX;
    }

    public void setObjectifsPioches(List<Objectif> objectifsPioches){
        this.objectifsPioches = objectifsPioches;
    }
    public void ajouterIrrigations() {
        this.irrigations++;
    }
    public void retirerIrrigation() { this.irrigations--; }

    public void afficherObjectifsPioches(){
        int i=1;
        for (Objectif obj: objectifsPioches){
            System.out.println(i+". "+obj);
            i++;
        }
    }


    public void retirerAmenagementBassin(){
        amenagementBassins--;
    }

}
