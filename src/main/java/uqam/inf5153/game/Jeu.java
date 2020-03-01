package uqam.inf5153.game;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.pioche.Pioche;
import uqam.inf5153.game.pioche.PiocheObjectifs;
import uqam.inf5153.game.pioche.PiocheParcelles;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.PlateauDeJeu;

import java.util.ArrayList;
import java.util.List;

public class
Jeu {

    private final int NBRE_DE_JOUEURS = 2;

    private PlateauDeJeu plateauDeJeu;
    private List<Joueur> joueurs;
    private Pioche<Objectif> piocheObjectifs;
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
    }


    public List<Parcelle> effectuerActionPiocherParcelles(int nbrAPiocher, int indexJoueur){
        return piocheParcelles.piocher(nbrAPiocher);
    }

    public Parcelle selectionnerParcelle(List<Parcelle> parcellesPiochees, int indexParcelle){
        Parcelle parcelleSelectionnee = parcellesPiochees.remove(indexParcelle - 1);
        piocheParcelles.replacerParcellesNonChoisies(parcellesPiochees);
        return parcelleSelectionnee;
    }

    public void afficherParcelles(List<Parcelle> parcelles){
        piocheParcelles.afficherParcelles(parcelles);
    }

    public void afficherParcellesDansPlateau(){
        plateauDeJeu.afficherParcelleDeposees();
    }

    public boolean effectuerActionPlacerParcelleDansPlateau(Parcelle parcelle, int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        //if (!plateauDeJeu.getPositionsDisponibles().contains(coord)){
        if (!plateauDeJeu.estPositionOccupee(coord)){
            return false;
        }
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.placerParcelleDansPlateau(plateauDeJeu,parcelle,x,y);
        return true;
    }

    public void effectuerActionPiocherIrrigation(int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.prendreIrrigation();
    }

    public void effectuerActionGarderIrrigation(int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.getPlateauDeJoueur().ajouterIrrigations();
    }

    public boolean effectuerActionPlacerIrrigation( int x1, int y1, int x2, int y2, int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        Coordonnees c1 = new Coordonnees(x1,y1);
        Coordonnees c2 = new Coordonnees(x2,y2);
        if (!plateauDeJeu.estPositionOccupee(c1) || !plateauDeJeu.estPositionOccupee(c2)){
            return false;
        }
        Parcelle p1 = plateauDeJeu.getParcelleAtPosition(c1);
        Parcelle p2 = plateauDeJeu.getParcelleAtPosition(c2);
        joueur.placerIrrigation(plateauDeJeu, p1, p2);
        return true;
    }


    public Joueur getJoueurByIndex(int index){
        return this.joueurs.get(index - 1);
    }

    private void melangerPioches(){
        this.piocheParcelles.melangerPioche();
        this.piocheObjectifs.melangerPioche();
    }



}
