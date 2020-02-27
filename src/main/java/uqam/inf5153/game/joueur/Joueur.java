package uqam.inf5153.game.joueur;

import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.ReseauIrrigation;

import java.util.List;

public class Joueur {

    private PlateauDeJoueur plateauDeJoueur;
    private List<Objectif> objectifs;
    private int nombreActions = 2;


    /* Méthode à déplacer eventuellement plus tard */
    public void placerIrrigation(PlateauDeJeu plateauDeJeu, Irrigation irr, Parcelle p1, Parcelle p2){
        irr.setParcelles(p1,p2);
        if (irr.getParcelle1().estAdjacent(plateauDeJeu.getParcelleEtang()) &&
            irr.getParcelle2().estAdjacent(plateauDeJeu.getParcelleEtang())){

            plateauDeJeu.ajouterNouveauReseauIrrigation(new ReseauIrrigation(irr));
        }else {
            for (ReseauIrrigation reseau : plateauDeJeu.getReseauxIrr()) {
                List<Irrigation> irrigationsDuReseau = reseau.getIrrigations();
                for (int i=0; i < irrigationsDuReseau.size(); i++) {
                    Irrigation irrigation = irrigationsDuReseau.get(i);
                    if (irr.getParcelle1().equals(irrigation.getParcelle1()) ||
                            irr.getParcelle2().equals(irrigation.getParcelle2())) {

                        reseau.ajouterIrragtionAuReseau(irr);
                        break;
                    }
                }
            }
        }
    }

    public void deplacerJardinier(PlateauDeJeu plateau, Figurine jardinier, Parcelle parcelleDestination){
        if (jardinier.estDeplaceableSur(parcelleDestination)){
            jardinier.setParcelleDepart(parcelleDestination);
        }else{
            //TODO
        }
    }

}
