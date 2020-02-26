package uqam.inf5153.game.joueur;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.ReseauIrrigation;

import java.util.List;

public class Joueur {

    private PlateauDeJoueur plateauDeJoueur;
    private List<Objectif> objectifs;
    private int nombreActions = 2;


    /* Méthode à déplacer eventuellement plus tard */
    public void placerIrrigation(PlateauDeJeu plateauDeJeu, Irrigation irr){

        if (irr.getParcelle1().estAdjacent(plateauDeJeu.getParcelleEtang()) &&
            irr.getParcelle2().estAdjacent(plateauDeJeu.getParcelleEtang())){

            plateauDeJeu.ajouterNouveauReseauIrrigation(new ReseauIrrigation(irr));
        }else {
            for (ReseauIrrigation reseau : plateauDeJeu.getReseauxIrr()) {
                List<Irrigation> irrigationsDuReseau = reseau.getIrrigations();
                Irrigation irrigationFin = irrigationsDuReseau.get(irrigationsDuReseau.size() - 1);

                if (irr.getParcelle1().equals(irrigationFin.getParcelle1()) ||
                        irr.getParcelle2().equals(irrigationFin.getParcelle2())) {

                    reseau.ajouterIrragtionAuReseau(irr);
                }
            }
        }
    }


}
