package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.Coordonnees;

import java.util.List;

public abstract class Parcelle {

    protected Coordonnees coordonnees;
    protected List<Parcelle> voisins;

    public Parcelle(Coordonnees coordonnees){

    }

    public Parcelle(){

    }
    
}
