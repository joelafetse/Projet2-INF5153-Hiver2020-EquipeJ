package uqam.inf5153.game.joueur;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Bambou;

import java.util.ArrayList;
import java.util.List;

/**
 * Réprésente le plateau d'un joueur donné.
 */
public class PlateauDeJoueur {

    // Bambous collectionnés via le panda
    private List<Bambou> bambous;

    // Objectifs accomplis
    private List<Objectif> objectifsAccomplis;

    // Nombre d'irrigations collectionnés
    private int irrigations;


    public PlateauDeJoueur(){
        bambous = new ArrayList<>();
        objectifsAccomplis = new ArrayList<>();
        irrigations = 0;
    }
}
