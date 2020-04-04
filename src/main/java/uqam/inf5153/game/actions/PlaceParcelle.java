package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.List;

public class PlaceParcelle implements Action {

    private Jeu jeu;

    public PlaceParcelle(Jeu jeu){
        this.jeu = jeu;
    }

    @Override
    public boolean executerAction(int numJoueur){
        return placerParcelle(numJoueur);
    }

    private boolean placerParcelle(int numJoueur){
        System.out.println("===========================================================================");
        System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Parcelle                        ");
        System.out.println("===========================================================================");
        System.out.println("Étape 1 - Piocher 3 parcelles ");
        List<Parcelle> parcellesPiochees = effectuerActionPiocherParcelles(3, numJoueur);

        System.out.println("Étape 2 - Vous avez pioché les parcelles suivantes : \n");

        afficherParcelles(parcellesPiochees);

        System.out.println("\nÉtape 3 - Choisissez une");
        int parcelleChosie = Keyin.inInt("Entrez le numéro de la parcelle choisie : ");
        while(parcelleChosie > 3 || parcelleChosie < 1){
            System.out.println("Vous devez choisir entre la parcelle 1 et 3");
            parcelleChosie = Keyin.inInt("\nEntrez le numéro de la parcelle choisie : ");
        }
        System.out.println("Étape 4 - Replacer les deux autres sous la pioche");
        Parcelle pSelectionnee = selectionnerParcelle(parcellesPiochees, parcelleChosie );
        System.out.println("Étape 5 - Afficher les parcelles du plateau:\n");
        afficherParcellesDansPlateau();
        jeu.getPlateauDeJeu().afficherLesPositionsDispo();
        System.out.println("\nÉtape 6 - Placer une parcelle dans la position (x,y) \n");
        int x = Keyin.inInt(" Entrer la position x : ");
        int y = Keyin.inInt(" Entrer la position y : ");
        boolean estPlacee = effectuerActionPlacerParcelleDansPlateau(pSelectionnee, x, y,  numJoueur);
        while (!estPlacee){
            System.out.println("La parcelle n'est pas placée. Veuillez choisir une autre position");
            jeu.getPlateauDeJeu().afficherLesPositionsDispo();
            System.out.println("Étape 6 - Placer une parcelle dans la position (x,y) ");
            x = Keyin.inInt(" Entrer la position x : ");
            y = Keyin.inInt(" Entrer la position y : ");
            estPlacee = effectuerActionPlacerParcelleDansPlateau(pSelectionnee, x, y,  numJoueur);
        }
        System.out.println("\nLa parcelle est bien placée ");

        return estPlacee;
    }

    public List<Parcelle> effectuerActionPiocherParcelles(int nbrAPiocher, int indexJoueur){
        return jeu.getPiocheParcelles().piocher(nbrAPiocher);
    }

    public Parcelle selectionnerParcelle(List<Parcelle> parcellesPiochees, int indexParcelle){
        Parcelle parcelleSelectionnee = parcellesPiochees.remove(indexParcelle - 1);
        jeu.getPiocheParcelles().replacerParcellesNonChoisies(parcellesPiochees);
        return parcelleSelectionnee;
    }

    public void afficherParcelles(List<Parcelle> parcelles){
        jeu.getPiocheParcelles().afficherParcelles(parcelles);
    }

    public void afficherParcellesDansPlateau(){
        jeu.getPlateauDeJeu().afficherParcelleDeposees();
    }

    public boolean effectuerActionPlacerParcelleDansPlateau(Parcelle parcelle, int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!positionExiste(jeu.getPlateauDeJeu(), coord))
            return false;

        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);

        joueur.placerParcelleDansPlateau(jeu.getPlateauDeJeu(),parcelle,x,y);
        return true;
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
}
