package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

public class DeplacePanda implements Action{

    private Jeu jeu;

    public DeplacePanda(Jeu jeu){
        this.jeu = jeu;
    }

    @Override
    public boolean executerAction(int numJoueur){
        return deplacerPanda(numJoueur);
    }

    public boolean deplacerPanda(int numJoueur){
        System.out.println("==========================================================================");
        System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Panda                         ");
        System.out.println("==========================================================================");
        System.out.println("|        Afficher les parcelles du plateau  (les positions)\n               ");
        jeu.afficherParcellesDansPlateau();
        System.out.println("\n|        Préciser la nouvelle parcelle (position x,y) du Panda                   ");
        int x = Keyin.inInt(" Entrer la position x : ");
        int y = Keyin.inInt(" Entrer la position y : ");
        boolean pandaEstDeplace = effectuerActionDeplacerPanda(x,y, numJoueur );
        while (!pandaEstDeplace){
            System.out.println("Vous ne pouvez pas déplacer le panda sur cette parcelle");
            System.out.println("|        Préciser la nouvelle parcelle (position x,y) du panda      ");
            x = Keyin.inInt(" Entrer la position x : ");
            y = Keyin.inInt(" Entrer la position y : ");
            pandaEstDeplace = effectuerActionDeplacerPanda(x,y, numJoueur );
        }
        System.out.println("Le Panda est bien déplacé.");

        return pandaEstDeplace;
    }

    private boolean effectuerActionDeplacerPanda(int x, int y, int joueurIndex){
        Coordonnees coord = new Coordonnees(x,y);
        if (!jeu.getPlateauDeJeu().estPositionOccupee(coord)){
            return false;
        }
        Parcelle parcelleDestination = jeu.getPlateauDeJeu().getParcelleAtPosition(coord);
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        return deplacerPanda(jeu.getPlateauDeJeu().getPanda(), joueur, parcelleDestination);
    }

    private boolean deplacerPanda(Figurine panda, Joueur joueur, Parcelle parcelleDestination){
        if (!panda.estDeplaceableSur(parcelleDestination)){
            return false;
        }else{
            panda.setParcelleDepart(parcelleDestination);
            if (parcelleDestination.getNombreDeBambous() != 0) {
                Bambou bambouMange = parcelleDestination.mangerBambou();
                joueur.getPlateauDeJoueur().reserverBambousPanda(bambouMange);
            }
        }
        return true;
    }
}
