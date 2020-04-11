package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.Amenagement;
import uqam.inf5153.game.tuile.amenagement.AmenagementBassin;
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
        List<ComposantParcelle> parcellesPiochees = effectuerActionPiocherParcelles(3, numJoueur);

        System.out.println("Étape 2 - Vous avez pioché les parcelles suivantes : \n");

        afficherParcelles(parcellesPiochees);

        System.out.println("\nÉtape 3 - Choisissez une");
        int parcelleChosie = Keyin.inInt("Entrez le numéro de la parcelle choisie : ");
        while(parcelleChosie > 3 || parcelleChosie < 1){
            System.out.println("Vous devez choisir entre la parcelle 1 et 3");
            parcelleChosie = Keyin.inInt("\nEntrez le numéro de la parcelle choisie : ");
        }
        System.out.println("Étape 4 - Replacer les deux autres sous la pioche");
        ComposantParcelle pSelectionnee = selectionnerParcelle(parcellesPiochees, parcelleChosie );
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

    public List<ComposantParcelle> effectuerActionPiocherParcelles(int nbrAPiocher, int indexJoueur){
        return jeu.getPiocheParcelles().piocher(nbrAPiocher);
    }

    public ComposantParcelle selectionnerParcelle(List<ComposantParcelle> parcellesPiochees, int indexParcelle){
        ComposantParcelle parcelleSelectionnee = parcellesPiochees.remove(indexParcelle - 1);
        jeu.getPiocheParcelles().replacerParcellesNonChoisies(parcellesPiochees);
        return parcelleSelectionnee;
    }

    public void afficherParcelles(List<ComposantParcelle> parcelles){
        jeu.getPiocheParcelles().afficherParcelles(parcelles);
    }

    public void afficherParcellesDansPlateau(){
        jeu.getPlateauDeJeu().afficherParcelleDeposees();
    }

    public boolean effectuerActionPlacerParcelleDansPlateau(ComposantParcelle parcelle, int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!positionExiste(jeu.getPlateauDeJeu(), coord))
            return false;

        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);

        placerParcelleDansPlateau(jeu.getPlateauDeJeu(),parcelle,x,y);
        return true;
    }


    public boolean placerParcelleDansPlateau(PlateauDeJeu plateau, ComposantParcelle parcelle, int x, int y){
        Coordonnees coordParcelle = new Coordonnees(x,y);

        parcelle.getComposant().setCoordonnees(coordParcelle);

        planterBambouSurParcelleDeposee(parcelle);

        plateau.ajouterParcelle(parcelle);

        plateau.getPositionsDisponibles().removeIf(coordonnees -> coordonnees.equals(coordParcelle));

        int i = plateau.positionParcelle(x, y + 2);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());            }
        i = plateau.positionParcelle(x + 2, y + 1);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());
        }
        i = plateau.positionParcelle(x + 2, y - 1);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());
        }
        i = plateau.positionParcelle(x, y - 2);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());
        }
        i = plateau.positionParcelle(x - 2, y - 1);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());
        }
        i = plateau.positionParcelle(x - 2, y + 1);
        if (i != -1) {
            parcelle.getComposant().setVoisins(plateau.getParcelles().get(i).getComposant());
            plateau.getParcelles().get(i).getComposant().setVoisins(parcelle.getComposant());
        }

        plateau.mettreAjourListePosiDisp(coordParcelle);
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

    /*
     * Si une parcelle est adjacent à la parcelle Étang, ça deviendra irriguée.
     * et on pourrait faire pousser une section de bambou sur cette parcelle.
     */
    public void planterBambouSurParcelleDeposee(ComposantParcelle comParcelle) {
        if (comParcelle.getComposant().estAdjacentAParcelleEtang() || comParcelle instanceof AmenagementBassin) {
            comParcelle.getComposant().setIrriguee(true);
            comParcelle.fairePousserBambou();
        }
    }
}
