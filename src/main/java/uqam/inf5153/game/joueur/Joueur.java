package uqam.inf5153.game.joueur;

import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.ReseauIrrigation;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private PlateauDeJoueur plateauDeJoueur;
    private List<Objectif> objectifs;
    private int nombreActions = 2;
    private int score;

    public Joueur(){
        this.plateauDeJoueur = new PlateauDeJoueur();
        this.objectifs = new ArrayList<>();
        this.score = 0;
    }

    public PlateauDeJoueur getPlateauDeJoueur() {
        return plateauDeJoueur;
    }

    public boolean placerParcelleDansPlateau(PlateauDeJeu plateau, Parcelle parcelle, int x, int y){
        Coordonnees c = new Coordonnees(x,y);
        parcelle.setCoordonnees(c);
        plateau.ajouterParcelle(parcelle);
        plateau.getPositionsDisponibles().removeIf(coordonnees -> coordonnees.equals(c));
        int i = plateau.positionParcelle(x,y+2);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        i = plateau.positionParcelle(x+2,y+1);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        i = plateau.positionParcelle(x+2,y-1);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        i = plateau.positionParcelle(x,y-2);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        i = plateau.positionParcelle(x-2,y-1);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        i = plateau.positionParcelle(x-2,y+1);
        if(i!=-1){
            parcelle.setVoisins(plateau.getParcelles().get(i));
        }
        plateau.mettreAjourListePosiDisp(x,y);
        return true;
    }

    public void prendreIrrigation() {
        int nbrCanauxIrrigationRestant = Irrigation.getNbrCanauxIrrigation() - 1;
        Irrigation.setNbrCanauxIrrigation(nbrCanauxIrrigationRestant);
    }

    /* Méthode à déplacer eventuellement plus tard */
    public void placerIrrigation(PlateauDeJeu plateauDeJeu, Parcelle p1, Parcelle p2){
        Irrigation irr = new Irrigation(p1,p2);
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
            //TODO //afficher message qu'on ne peut pas déplacer le jardinier vers cettr destination.
        }
    }

}
