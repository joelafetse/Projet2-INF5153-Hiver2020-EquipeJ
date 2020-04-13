package uqam.inf5153.game.joueur;

import uqam.inf5153.game.actions.Action;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.objectif.ObjectifPanda;
import uqam.inf5153.game.plateau.PlateauDeJeu;


import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private PlateauDeJoueur plateauDeJoueur;
    private List<Objectif> objectifs;
    private Action actionCourante;
    private final int NOMBRE_ACTIONS = 2;
    private int score;

    public Joueur(){
        this.plateauDeJoueur = new PlateauDeJoueur();
        this.objectifs = new ArrayList<>();
        this.score = 0;
    }

    public boolean effectuerAction(int numJoueur){
        return this.actionCourante.executer(numJoueur);
    }

    public void setActionCourante(Action nouvelleAction){
        this.actionCourante = nouvelleAction;
    }

    public PlateauDeJoueur getPlateauDeJoueur() {
        return plateauDeJoueur;
    }

    public boolean aGagneLaPartie(int nbrObjectifsGagnant){
        return plateauDeJoueur.getNombreObjectifsAccomplis() == nbrObjectifsGagnant;
    }

    public boolean remplirObjectif(Objectif obj, PlateauDeJeu plateauDeJeu){
        int points = obj.appliquerObjectif(plateauDeJeu);
        //----------
        if(obj instanceof ObjectifPanda) {
            points = obj.appliquerObjectif(plateauDeJoueur);
        }
        if (points == 0){
            return false;
        }
        score += obj.appliquerObjectif(plateauDeJeu);
        plateauDeJoueur.ajouterObjectifAccomplis(obj);
        return true;
    }

}
