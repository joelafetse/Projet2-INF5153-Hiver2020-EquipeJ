package uqam.inf5153.game;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.pioche.Pioche;
import uqam.inf5153.game.pioche.PiocheIrrigations;
import uqam.inf5153.game.pioche.PiocheObjectifs;
import uqam.inf5153.game.pioche.PiocheParcelles;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;

import java.util.List;

public class Jeu {

    private PlateauDeJeu plateauDeJeu;
    private List<Joueur> joueurs;
    private Pioche<Objectif> piocheObjectifs;
    private Pioche<Parcelle> piocheParcelles;
    private Pioche<Irrigation> piocheIrrigations;

    //Constucteur
    public Jeu(){
        this.plateauDeJeu = new PlateauDeJeu();
        this.piocheObjectifs = new PiocheObjectifs();
        this.piocheParcelles = new PiocheParcelles();
        this.piocheIrrigations = new PiocheIrrigations();
        this.melangerPioches();
    }

    private void melangerPioches(){
        this.piocheParcelles.melangerPioche();
        this.piocheObjectifs.melangerPioche();
    }

}
