package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.Coordonnees;

public abstract class Bambou {

    protected Coordonnees coordonnees;

    public Bambou(Coordonnees coordonnees){
       this.coordonnees = coordonnees;
    }

    public Coordonnees getCoordonnees(){
        return this.coordonnees;
    }
}
