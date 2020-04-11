package uqam.inf5153.game.actions;

import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.Keyin;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.ReseauIrrigation;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.List;

public class PlaceIrrigation  implements  Action {


    private Jeu jeu;
    private boolean estDecision;

    public PlaceIrrigation(Jeu jeu, boolean estDecision){
        this.jeu = jeu;
        this.estDecision = estDecision;
    }

    @Override
    public boolean executer(int numJoueur){
        if (estDecision)
            return placerIrrigation(numJoueur);

        return traiterIrrigation(numJoueur);
    }



    private boolean traiterIrrigation(int numJoueur){
        System.out.println("===========================================================================");
        System.out.println("|   TAKENOKO MENU JOUEUR " +numJoueur+ " : Action Irrigation                        ");
        System.out.println("===========================================================================");
        effectuerActionPiocherIrrigation(numJoueur);
        System.out.println("|        Une irrigation est prise                                 ");
        System.out.println("|        Voulez-vous la placer   ?                             ");
        int reponse = Keyin.inChar(" réponse (O/N) : ");
        if (reponse == 'o' || reponse == 'O' ) {
            placerIrrigation(numJoueur);
        }else{
            effectuerActionGarderIrrigation(numJoueur);
        }
        return true;
    }

    private void effectuerActionPiocherIrrigation(int joueurIndex){
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        prendreIrrigation();
    }

    private void effectuerActionGarderIrrigation(int joueurIndex){
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        joueur.getPlateauDeJoueur().ajouterIrrigations();
    }

    private boolean effectuerActionPlacerIrrigation( int x1, int y1, int x2, int y2, int joueurIndex){
        Joueur joueur = jeu.getJoueurByIndex(joueurIndex);
        Coordonnees c1 = new Coordonnees(x1,y1);
        Coordonnees c2 = new Coordonnees(x2,y2);
        if (!jeu.getPlateauDeJeu().estPositionOccupee(c1) || !jeu.getPlateauDeJeu().estPositionOccupee(c2)){
            return false;
        }
        ComposantParcelle p1 = jeu.getPlateauDeJeu().getParcelleAtPosition(c1);
        ComposantParcelle p2 = jeu.getPlateauDeJeu().getParcelleAtPosition(c2);
        if (!p1.getComposant().estAdjacent(p2.getComposant())){
            System.out.println("Choisissez deux positions adjacentes.");
            return false;
        }
        return placerIrrigation(jeu.getPlateauDeJeu(), p1.getComposant(), p2.getComposant());
    }

    private void prendreIrrigation() {
        int nbrCanauxIrrigationRestant = Irrigation.getNbrCanauxIrrigation() - 1;
        Irrigation.setNbrCanauxIrrigation(nbrCanauxIrrigationRestant);
    }

    private boolean placerIrrigation(PlateauDeJeu plateauDeJeu, Parcelle p1, Parcelle p2){
        boolean irrigationEstPlacee = false;
        Irrigation irr = new Irrigation(p1,p2);
        if (irr.getParcelle1().estAdjacent(plateauDeJeu.getParcelleEtang()) &&
                irr.getParcelle2().estAdjacent(plateauDeJeu.getParcelleEtang()))
        {
            plateauDeJeu.ajouterNouveauReseauIrrigation(new ReseauIrrigation(irr));
            irrigationEstPlacee = true;
        }else {
            for (ReseauIrrigation reseau : plateauDeJeu.getReseauxIrr()) {
                List<Irrigation> irrigationsDuReseau = reseau.getIrrigations();
                for (int i=0; i < irrigationsDuReseau.size(); i++) {
                    Irrigation uneIrrigationDeReseau = irrigationsDuReseau.get(i);
                    if (irrigationEstVerifiee(irr, uneIrrigationDeReseau)) {
                        reseau.ajouterIrragtionAuReseau(irr);
                        if(irr.getParcelle1().getNombreDeBambous() == 0) {
                            irr.getParcelle1().fairePousserBambou();
                        }
                        if(irr.getParcelle2().getNombreDeBambous() == 0) {
                            irr.getParcelle2().fairePousserBambou();
                        }
                        return true;
                    }
                }
            }
        }
        return irrigationEstPlacee;
    }
    private boolean irrigationEstVerifiee(Irrigation irr1, Irrigation irr2) {
        return irr1.getParcelle1().equals(irr2.getParcelle1()) ||
                irr1.getParcelle1().equals(irr2.getParcelle2()) ||
                irr1.getParcelle2().equals(irr2.getParcelle1()) ||
                irr1.getParcelle2().equals(irr2.getParcelle2());
    }

    private boolean placerIrrigation(int numJoueur) {
        System.out.println("=========================================================================");
        System.out.println("|  TAKENOKO MENU JOUEUR " +numJoueur+ ": décide de placer une irrigation ");
        System.out.println("=========================================================================\n");
        System.out.println("Les parcelles déposées sur le plateau de jeu sont: \n");
        jeu.afficherParcellesDansPlateau();
        System.out.println("\n|        Préciser les deux parcelles (x1,y1) et (x2, y2) séparés par l'irrigation ");
        int x1 = Keyin.inInt(" Entrer la position x1 : ");
        int y1 = Keyin.inInt(" Entrer la position y1 : ");
        int x2 = Keyin.inInt(" Entrer la position x2 : ");
        int y2 = Keyin.inInt(" Entrer la position y2 : ");
        boolean estPlacee = effectuerActionPlacerIrrigation( x1, y1, x2, y2, numJoueur);
        while(!estPlacee){
            System.out.println("l'irrigation n'est pas placée");
            System.out.println("Vous devez entrer des positions valides");
            x1 = Keyin.inInt(" Entrer la position x1 : ");
            y1 = Keyin.inInt(" Entrer la position y1 : ");
            x2 = Keyin.inInt(" Entrer la position x2 : ");
            y2 = Keyin.inInt(" Entrer la position y2 : ");
            estPlacee = effectuerActionPlacerIrrigation( x1, y1, x2, y2, numJoueur);
        }
        System.out.println("L'irrigation est bien placée");

        return estPlacee;
    }

}
