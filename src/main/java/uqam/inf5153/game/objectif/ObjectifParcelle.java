package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.parcelle.Couleur;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifParcelle extends Objectif {

    public ObjectifParcelle(int identifiant){
        super(identifiant);
    }


    public int appliquerObjectifPasrcelle(Joueur joueur, PlateauDeJeu plateau){
        switch (identifiant){
            case 1:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.VERT){
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
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+1)%6], Couleur.ROSE) && verifierParcelle(pAdj[(i+2)%6], Couleur.JAUNE)) return 5;
                        }
                    }
                }
                break;
            case 4:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.ROSE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+1)%6], Couleur.VERT) && verifierParcelle(pAdj[(i+2)%6], Couleur.ROSE)) return 4;
                        }
                    }
                }
                break;
            case 5:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle.getCouleur()==Couleur.JAUNE){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle(pAdj[i],Couleur.VERT) && verifierParcelle(pAdj[(i+1)%6], Couleur.VERT) && verifierParcelle(pAdj[(i+2)%6], Couleur.JAUNE)) return 3;
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
                        for (int i=0; i<6; i++){
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
                            if (verifierParcelle(pAdj[i],Couleur.ROSE) && verifierParcelle(pAdj[(i+1)%6], Couleur.JAUNE)) return 4;
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
        return p!=null && p.estIrriguee() && p.getCouleur()==col;
    }



}
