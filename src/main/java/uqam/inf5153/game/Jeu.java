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
        if (!positionExiste(plateauDeJeu, coord))
            return false;

        Joueur joueur = getJoueurByIndex(joueurIndex);

        if(parcelle.getCouleur() == Couleur.VERT) {
            parcelle = new ParcelleVerte();
        }else if (parcelle.getCouleur() == Couleur.ROSE) {
            parcelle = new ParcelleRose();
        }else if (parcelle.getCouleur() == Couleur.JAUNE) {
            parcelle = new ParcelleJaune();
        }

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

    public boolean effectuerActionDeplacerJardinier(int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!plateauDeJeu.estPositionOccupee(coord)){
            return false;
        }
        Parcelle parcelleDestination = plateauDeJeu.getParcelleAtPosition(coord);
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.deplacerJardinier(plateauDeJeu.getJardinier(),parcelleDestination);
        return true;
    }
    public boolean effectuerActionDeplacerPanda(int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!plateauDeJeu.estPositionOccupee(coord)){
            return false;
        }
        Parcelle parcelleDestination = plateauDeJeu.getParcelleAtPosition(coord);
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.deplacerPanda(plateauDeJeu.getPanda(),parcelleDestination);
        return true;
    }

    public void afficherObjectifsPioches(int joueurIndex) {
        Joueur joueur = getJoueurByIndex(joueurIndex);
        joueur.getPlateauDeJoueur().afficherObjectifsPioches();
    }

    public Objectif selectionnerObjectif(List<Objectif> objectifsPioches, int indexObjectif){
        Objectif objSelectionne = objectifsPioches.remove(indexObjectif - 1);
        return objSelectionne;
    }

    public List<Objectif> getObjectifsPioches(int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        return joueur.getPlateauDeJoueur().getObjectifsPioches();
    }

    public Objectif piocherObjectif(int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        return joueur.prendreObjectif(piocheObjectifs,joueur.getPlateauDeJoueur());
    }

    public boolean effectuerActionRemplirObjectif(Objectif objectif, int joueurIndex){
        Joueur joueur = getJoueurByIndex(joueurIndex);
        return joueur.remplirObjectif(objectif, plateauDeJeu);
    }

    public boolean verifierFinPartie() {
        for (Joueur joueur: joueurs){
            if (joueur.getPlateauDeJoueur().getNombreObjectifsAccomplis() == NBRE_OBJECTIFS_GAGNANT){
                return true;
            }
        }
        return false;
    }

    // private methods
    private Joueur getJoueurByIndex(int index){
        return this.joueurs.get(index - 1);
    }

    private void melangerPioches(){
        this.piocheParcelles.melangerPioche();
        this.piocheObjectifs.melangerPioche();
    }

    private boolean positionExiste(PlateauDeJeu plateauDeJeu, Coordonnees coord){
        boolean positionExiste = false;
        for (Coordonnees elem: plateauDeJeu.getPositionsDisponibles()){
            if (elem.equals(coord)){
                positionExiste = true;
                break;
            }
        }
        return positionExiste;
    }



    private void piocherObjectifsPourChaqueJoueur(){
        for (Joueur joueur: joueurs)
            joueur.getPlateauDeJoueur().setObjectifsPioches(this.piocheObjectifs.piocher(3));

    }
}
