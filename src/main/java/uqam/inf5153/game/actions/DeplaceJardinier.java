package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

public class DeplaceJardinier implements Action {

    private Jeu jeu;

    public DeplaceJardinier(Jeu jeu){
        this.jeu = jeu;
    }

    @Override
    public boolean executerAction(int numJoueur){
        return deplacerJardinier(numJoueur);
    }

    private boolean effectuerActionDeplacerJardinier(int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!jeu.getPlateauDeJeu().estPositionOccupee(coord)){
            return false;
        }
        ComposantParcelle parcelleDestination = jeu.getPlateauDeJeu().getParcelleAtPosition(coord);
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        return deplacerJardinier(jeu.getPlateauDeJeu().getJardinier(),parcelleDestination);
    }

    private boolean deplacerJardinier(Figurine jardinier, ComposantParcelle comParcelleDestination){

        if (!jardinier.estDeplaceableSur(comParcelleDestination)) {
            return false;
        }else{
            jardinier.setParcelleDepart(comParcelleDestination);
            if (comParcelleDestination.getComposant().estIrriguee() && comParcelleDestination.getNombreDeBambous() <= 4) {
                comParcelleDestination.fairePousserBambou();
                Parcelle[] parcellesAdjacentes = comParcelleDestination.getComposant().parcellesAdjacentes();
                for(int i = 0; i < 6; i++) {
                    if( estIrrigeeEtDeMemeCouleur(comParcelleDestination.getComposant(), parcellesAdjacentes[i]) ) {
                        parcellesAdjacentes[i].fairePousserBambou();
                    }
                }
            }
        }
        return true;
    }

    private boolean estIrrigeeEtDeMemeCouleur(Parcelle parcelleDest, Parcelle parcelleAdj) {
        return (parcelleAdj!= null) && parcelleAdj.estIrriguee() &&
                (parcelleDest.getCouleur() == parcelleAdj.getCouleur());
    }

    private boolean deplacerJardinier(int numJoueur){
        System.out.println("==========================================================================");
        System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Jardiner                        ");
        System.out.println("==========================================================================");
        System.out.println("|        Afficher les parcelles du plateau (les positions):             \n");
        jeu.afficherParcellesDansPlateau();
        System.out.println("\n|        Précisier la nouvelle parcelle (position x,y) du Jardinier      ");
        int x = Keyin.inInt(" Entrer la position x : ");
        int y = Keyin.inInt(" Entrer la position y : ");
        boolean estDeplace = effectuerActionDeplacerJardinier(x,y, numJoueur );
        while (!estDeplace) {
            System.out.println("Vous ne pouvez pas déplacer le jardinier sur cette parcelle");
            System.out.println("|        Préciser la nouvelle parcelle (position x,y) du Jardinier      ");
            x = Keyin.inInt(" Entrer la position x : ");
            y = Keyin.inInt(" Entrer la position y : ");
            estDeplace = effectuerActionDeplacerJardinier(x, y, numJoueur);
        }
        System.out.println("Le Jardinier est bien déplacé.");

        return estDeplace;
    }
}
