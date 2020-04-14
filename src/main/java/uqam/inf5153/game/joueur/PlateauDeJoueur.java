package uqam.inf5153.game.joueur;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.objectif.ObjectifParcelle;
import uqam.inf5153.game.tuile.parcelle.Couleur;

import java.util.ArrayList;
import java.util.List;

/**
 * Réprésente le plateau d'un joueur donné.
 */
public class PlateauDeJoueur {


    private final int NBRE_OBJECTIFS_PIOCHES_MAX = 5;

    // Bambous qui sont manguées par le panda
    private List<Bambou> bambousPanda;

    // Objectifs accomplis
    private List<Objectif> objectifsAccomplis;

    // Objectifs piochés
    private List<Objectif> objectifsPioches;

    // Nombre  de canaux d'irrigations collectionnés
    private int irrigations;


    public PlateauDeJoueur(){
        objectifsPioches = new ArrayList<>();
        objectifsAccomplis = new ArrayList<>();
        bambousPanda = new ArrayList<>();
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
    public void reserverBambousPanda(Bambou bambou){
        this.bambousPanda.add(bambou);
    }
    public void retirerBambousPanda(Couleur couleur){
        boolean trouver =false;
        int i=0;
        int j=-1;
        while(i<bambousPanda.size() && !trouver){
            if(bambousPanda.get(i).getCouleur()==Couleur.VERT){
               j=i;
               trouver=true;
            }
            i++;
        }
        if(j!=-1){
            bambousPanda.remove(j);
        }
    }
    public List<Bambou> getBambousPanda(){return this.bambousPanda;}

    public void afficherObjectifsPioches(){
        int i=1;
        for (Objectif obj: objectifsPioches){
            System.out.println(i+". "+obj);
            i++;
        }
    }

    public int[] calculerNbrBambousPanda(){
        int[] nombreBambouspanda = new int[3];
        int nbrBambousVertPanda = 0;
        int nbrBambousJaunePanda = 0;
        int nbrBambousRosePanda = 0;


        for (Bambou bambou : bambousPanda) {
            if (bambou.getCouleur() == Couleur.VERT){
                nbrBambousVertPanda++;

            } else if (bambou.getCouleur() == Couleur.JAUNE){
                nbrBambousJaunePanda++;
            } else if (bambou.getCouleur() == Couleur.ROSE){
                nbrBambousRosePanda++;
            }
        }
        nombreBambouspanda[0] = nbrBambousVertPanda;
        nombreBambouspanda[1] = nbrBambousJaunePanda;
        nombreBambouspanda[2] = nbrBambousRosePanda;

        return nombreBambouspanda;
    }


}
