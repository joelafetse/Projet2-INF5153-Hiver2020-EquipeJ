package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Parcelle {
    //variable de classe
    private static int compteur = 0;

    //variables d'instances
    protected int parcelleId;
    protected Coordonnees coord;
    protected boolean irriguee;
    protected List<Parcelle> voisins;

    public Parcelle(Coordonnees coord){
        this.coord = coord;
    }


    public Parcelle(){
        this.voisins=new ArrayList<Parcelle>();

    }

    public Coordonnees getCoordonnees(){
        return this.coord;
    }

    public  List<Parcelle> getVoisins(){
        return this.voisins;
    }

    public boolean estIrriguee() {
        return irriguee;
    }

    public void setCoordonnees(Coordonnees coord) {
        this.coord = coord;
    }

    public void setVoisins(Parcelle p) {
        this.voisins.add(p);
    }

    public void setIrriguee(boolean irri) {
        this.irriguee = irri;
    }

    public abstract Couleur getCouleur();
    public abstract int getParcelleId();


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;


        return this.coord.equals(((Parcelle) obj).coord) && this.getCouleur() == ((Parcelle) obj).getCouleur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(parcelleId, coord, irriguee);
    }

    public boolean estAdjacent(Parcelle p){
        return (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() + 2) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() - 2);
    }




    public Parcelle[] parcellesAdjacentes(){
        Parcelle[] parcellesAdjacentes=new Parcelle[6];
        int i=0;
            while( i < voisins.size()) {
                    parcellesAdjacentes[i] = voisins.get(i);
                    i++;
            }
        return parcellesAdjacentes;
    }

    @Override
    public String toString(){
        return "Parcelle de couleur "+ this.getCouleur();
    }

}
