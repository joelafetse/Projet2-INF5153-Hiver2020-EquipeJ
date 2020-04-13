package uqam.inf5153.game.objectif;

import uqam.inf5153.game.joueur.PlateauDeJoueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.AmenagementBassin;
import uqam.inf5153.game.tuile.amenagement.AmenagementEnclos;
import uqam.inf5153.game.tuile.amenagement.AmenagementEngrais;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

public class ObjectifJardinier extends Objectif {

    public ObjectifJardinier(int identifiant){
        super(identifiant);
    }

    @Override
    public int appliquerObjectif(PlateauDeJeu plateauDeJeu){
        int i;
        switch (identifiant){
            case 16:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof  AmenagementBassin && p.getComposant().getCouleur()==Couleur.ROSE && p.getNombreDeBambous()==4)
                        return 5;
                }
                break;
            case 17:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof Parcelle && p.getComposant().getCouleur()==Couleur.ROSE && p.getNombreDeBambous()==4)
                        return 6;
                }
                break;
            case 18:
                i=0;
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if (Couleur.JAUNE ==p.getComposant().getCouleur() &&  p.getNombreDeBambous()==3){
                        i++;
                    }
                }
                if(i >= 2) return 6;
                break;
            case 19:
                i=0;
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if (Couleur.ROSE ==p.getComposant().getCouleur() &&  p.getNombreDeBambous()==3){
                        i++;
                    }
                }
                if(i >= 3) return 7;
                break;
            case 20:
                i=0;
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if (Couleur.VERT ==p.getComposant().getCouleur() &&  p.getNombreDeBambous()==3){
                        i++;
                    }
                }
                if(i >= 4) return 8;
                break;
            case 21:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementEnclos && p.getComposant().getCouleur()==Couleur.VERT && p.getNombreDeBambous()==4)
                        return 4;
                }
                break;
            case 22:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementBassin && p.getComposant().getCouleur()==Couleur.VERT && p.getNombreDeBambous()==4)
                        return 4;
                }
                break;
            case 23:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof Parcelle && p.getComposant().getCouleur()==Couleur.VERT && p.getNombreDeBambous()==4)
                        return 5;
                }
                break;
            case 24:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementEngrais && p.getComposant().getCouleur()==Couleur.ROSE && p.getNombreDeBambous()==4)
                        return 4;
                }
                break;
            case 25:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementEnclos && p.getComposant().getCouleur()==Couleur.ROSE && p.getNombreDeBambous()==4)
                        return 5;
                }
                break;
            case 26:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementEngrais && p.getComposant().getCouleur()==Couleur.JAUNE && p.getNombreDeBambous()==4)
                        return 5;
                }
                break;
            case 27:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementBassin && p.getComposant().getCouleur()==Couleur.JAUNE && p.getNombreDeBambous()==4)
                        return 6;
                }
                break;
            case 28:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof AmenagementEnclos && p.getComposant().getCouleur()==Couleur.JAUNE && p.getNombreDeBambous()==4)
                        return 6;
                }
                break;
            case 29:
                for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                    if(p instanceof Parcelle && p.getComposant().getCouleur()==Couleur.JAUNE && p.getNombreDeBambous()==4)
                        return 7;
                }
                break;
            case 30:
            for (ComposantParcelle p : plateauDeJeu.getParcelles()){
                if(p instanceof AmenagementEngrais && p.getComposant().getCouleur()==Couleur.VERT && p.getNombreDeBambous()==4)
                    return 3;
            }
            break;
        }
        return 0;
    }

    @Override
    public int appliquerObjectif(PlateauDeJoueur plateauDeJoueur) {
        return 0;
    }

    @Override
    public String toString() {

        switch (identifiant) {
            case 16:
                return "Objectif " + identifiant + " : Quatre bambous roses sur une parcelle rose avec amenagement bassain, Points: 5";
            case 17:
                return "Objectif " + identifiant + " : Quatre bambous roses sur une parcelle rose sans amenagement, Points: 6";
            case 18:
                return "Objectif " + identifiant + " : Plus de 2 parcelles jaunes contiennent exactement 3 bambous jaunes chacune, Points: 6";
            case 19:
                return "Objectif " + identifiant + " : Plus de 3 parcelles roses contiennent exactement 3 bambous roses chacune, Points: 7";
            case 20:
                return "Objectif " + identifiant + " : Plus de 4 parcelles vertes contiennent exactement 3 bambous verts chacune, Points: 8";
            case 21:
                return "Objectif " + identifiant + " : Quatre bambous verts sur une parcelle verte avec amenagement enclos, Points: 4";
            case 22:
                return "Objectif " + identifiant + " : Quatre bambous verts sur une parcelle verte avec amenagement bassin, Points: 4";
            case 23:
                return "Objectif " + identifiant + " : Quatre bambous verts sur une parcelle verte sans amenagement, Points: 5";
            case 24:
                return "Objectif " + identifiant + " : Quatre bambous roses sur une parcelle rose avec amenagement engrais, Points: 4";
            case 25:
                return "Objectif " + identifiant + " : Quatre bambous roses sur une parcelle rose avec amenagement enclos, Points: 5";
            case 26:
                return "Objectif " + identifiant + " : Quatre bambous jaunes sur une parcelle jaune avec amenagement engrais, Points: 5";
            case 27:
                return "Objectif " + identifiant + " : Quatre bambous jaunes sur une parcelle jaune avec amenagement bassin, Points: 6";
            case 28:
                return "Objectif " + identifiant + " : Quatre bambous jaunes sur une parcelle jaune avec amenagement enclos, Points: 6";
            case 29:
                return "Objectif " + identifiant + " : Quatre bambous jaunes sur une parcelle jaune sans amenagement, Points: 7";
            case 30:
                return "Objectif " + identifiant + " : Quatre bambous verts sur une parcelle verte avec amenagement engrais, Points: 3";
        }
        return " ";
    }

}
