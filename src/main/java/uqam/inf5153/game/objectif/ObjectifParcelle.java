package uqam.inf5153.game.objectif;

import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifParcelle extends Objectif {

    public ObjectifParcelle(int identifiant){
        super(identifiant);
    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateau){
        switch (identifiant){
            case 1:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()== Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+1)%6], Couleur.VERT) ) return 2;
                        }
                    }
                }
                break;
            case 2:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+1)%6], Couleur.VERT) && verifierParcelle(pAdj[(i+2)%6], Couleur.VERT)) return 3;
                        }
                    }
                }
                break;
            case 3:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+1)%6], Couleur.JAUNE) && verifierParcelle(pAdj[(i+2)%6], Couleur.ROSE)) return 5;
                        }
                    }
                }
                break;
            case 4:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+1)%6], Couleur.ROSE) && verifierParcelle(pAdj[(i+2)%6], Couleur.VERT)) return 4;
                        }
                    }
                }
                break;
            case 5:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+1)%6], Couleur.JAUNE) && verifierParcelle(pAdj[(i+2)%6], Couleur.VERT)) return 3;
                        }
                    }
                }
                break;
            case 6:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+3)%6], Couleur.JAUNE)) return 3;
                        }
                    }
                }
                break;
            case 7:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+1)%6], Couleur.JAUNE) && verifierParcelle(pAdj[(i+2)%6], Couleur.JAUNE)) return 4;
                        }
                    }
                }
                break;
            case 8:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6 ; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+2)%6], Couleur.JAUNE)) return 3;
                        }
                    }
                }
                break;
            case 9:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+3)%6], Couleur.VERT)) return 2;
                        }
                    }
                }
                break;
            case 10:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+2)%6], Couleur.VERT)) return 2;
                        }
                    }
                }
                break;
            case 11:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+2)%6], Couleur.ROSE)) return 4;
                        }
                    }
                }
                break;
            case 12:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+1)%6], Couleur.ROSE)) return 4;
                        }
                    }
                }
                break;
            case 13:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+1)%6], Couleur.ROSE) && verifierParcelle(pAdj[(i+2)%6], Couleur.ROSE)) return 5;
                        }
                    }
                }
                break;
            case 14:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+3)%6], Couleur.ROSE)) return 4;
                        }
                    }
                }
                break;
            case 15:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.JAUNE) && verifierParcelle(pAdj[(i+1)%6], Couleur.JAUNE)) return 3;
                        }
                    }
                }
                break;

        }
        return 0;
    }

    private boolean verifierParcelle(Parcelle p, Couleur col ){
        return p!=null && p.getCouleur()==col;
    }

    @Override
    public String toString() {

        switch (identifiant){
            case 1:
                return "Objectif " + identifiant + " : Triangle vert, Points: 2";
            case 2:
                return "Objectif " + identifiant + " : Diamant vert, Points: 3";
            case 3:
                return "Objectif " + identifiant + " : Diamant jaune et rose, Points: 5";
            case 4:
                return "Objectif " + identifiant + " : Diamant rose et vert, Points: 4";
            case 5:
                return "Objectif " + identifiant + " : Diamant jaune et vert, Points: 3";
            case 6:
                return "Objectif " + identifiant + " : Ligne Jaune, Points: 3";
            case 7:
                return "Objectif " + identifiant + " : Diamant jaune, Points: 4";
            case 8:
                return "Objectif " + identifiant + " : Ligne courbé jaune, Points: 3";
            case 9:
                return "Objectif " + identifiant + " : Ligne vert, Points: 2";
            case 10:
                return "Objectif " + identifiant + " : Ligne courbé vert, Points: 2";
            case 11:
                return "Objectif " + identifiant + " : Ligne courbé rose, Points: 4";
            case 12:
                return "Objectif " + identifiant + " : Triangle rose, Points: 4";
            case 13:
                return "Objectif " + identifiant + " : Diamant rose, Points: 5";
            case 14:
                return "Objectif " + identifiant + " : Ligne rose, Points: 3";
            case 15:
                return "Objectif " + identifiant + " : Triangle jaune, Points: 3";
        }

         return " ";

    }



}
