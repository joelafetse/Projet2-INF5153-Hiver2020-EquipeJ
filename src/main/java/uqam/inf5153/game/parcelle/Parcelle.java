package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public abstract class Parcelle {

    protected Coordonnees coord;

    public Parcelle(Coordonnees coordonnees){

    }

    public Coordonnees getCoordonnees(){
        return this.coord;
    }

    public abstract Couleur getCouleur();

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Parcelle &&
                this.coord.equals(((Parcelle) obj).coord) &&
                this.getCouleur() == ((Parcelle) obj).getCouleur();
    }

    public boolean estAdjacent(Parcelle p){
        return (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() + 2) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() - 2);
    }

}
