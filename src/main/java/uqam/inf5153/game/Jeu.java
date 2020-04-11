package uqam.inf5153.game;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.pioche.PiocheObjectifs;
import uqam.inf5153.game.pioche.PiocheParcelles;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.parcelle.*;

import java.util.ArrayList;
import java.util.List;

public class Jeu {

    private final int NBRE_DE_JOUEURS = 2;
    private final int NBRE_OBJECTIFS_GAGNANT = 9;

    private PlateauDeJeu plateauDeJeu;
    private List<Joueur> joueurs;
    private PiocheObjectifs piocheObjectifs;
    private PiocheParcelles piocheParcelles;


    //Constucteur
    public Jeu(){
        this.joueurs = new ArrayList<>();
        for (int i=0; i < NBRE_DE_JOUEURS; i++)
            this.joueurs.add(new Joueur());
        this.plateauDeJeu = new PlateauDeJeu();
        this.piocheObjectifs = new PiocheObjectifs();
        this.piocheParcelles = new PiocheParcelles();
        this.melangerPioches();
        piocherObjectifsPourChaqueJoueur();

    }

    public PlateauDeJeu getPlateauDeJeu(){
        return plateauDeJeu;
    }

    public PiocheParcelles getPiocheParcelles(){
        return piocheParcelles;
    }

    public PiocheObjectifs getPiocheObjectifs() { return piocheObjectifs; }

    public List<Joueur> getJoueurs() { return joueurs; }

    public void afficherParcellesDansPlateau(){
        plateauDeJeu.afficherParcelleDeposees();
    }
    public void afficherPositionPanda(){
        plateauDeJeu.afficherPositionPanda();
    }
    public void afficherPositionJardinier(){
        plateauDeJeu.afficherPositionJardinier();
    }


    public void afficherObjectifsPioches(int joueurIndex) {
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.getPlateauDeJoueur().afficherObjectifsPioches();
    }

    public boolean verifierFinPartie() {
        for (Joueur joueur: joueurs){
            boolean aGagneLaPartie = joueur.aGagneLaPartie(NBRE_OBJECTIFS_GAGNANT);
            if (aGagneLaPartie){
                return true;
            }
        }
        return false;
    }

    public int annoncerGagnant(){
        for (Joueur joueur: joueurs){
            boolean aGagneLaPartie = joueur.aGagneLaPartie(NBRE_OBJECTIFS_GAGNANT);
            if (aGagneLaPartie){
                return joueurs.indexOf(joueur) + 1;
            }
        }
        return -1;
    }

    // private methods
    public Joueur getJoueurByIndex(int index){
        return this.joueurs.get(index - 1);
    }

    private void melangerPioches(){
        this.piocheParcelles.melangerPioche();
        this.piocheObjectifs.melangerPioche();
    }

    private void piocherObjectifsPourChaqueJoueur(){
        for (Joueur joueur: joueurs)
            joueur.getPlateauDeJoueur().setObjectifsPioches(this.piocheObjectifs.piocher(3));
    }
}
