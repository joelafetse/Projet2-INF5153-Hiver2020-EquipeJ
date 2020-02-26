package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleVerte;
import uqam.inf5153.game.plateau.PlateauDeJeu;

public class ObjectifParcelle extends Objectif {

    public ObjectifParcelle(int identifiant){
        super(identifiant);
    }


    public int appliquerObjectifPasrcelle(Joueur joueur, PlateauDeJeu plateau){
        switch (identifiant){
            case 1:
                for (Parcelle parcelle : plateau.getParcelles()) {
                    if (parcelle instanceof ParcelleVerte){
                        for (int i=0; i<6; i++){
                            Parcelle[] pAdj=parcelle.parcellesAdjacentes();
                            if (verifierParcelle()Parcelle(pAdj[i],0) && verifierParcelle()Parcelle(pAdj[(i+1)%6],0) && verifierParcelle(pAdj[(i+2)%6],0)) return 3;
                        }
                    }
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;

                default:
                    return 0;
        }
    }

    private boolean verifierParcelle(Parcelle p, string ){
        return p!=null && p.estIrriguee() && p.getColor()==col;
    }



}
