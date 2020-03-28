package uqam.inf5153.game.tuile.parcelle;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.tuile.ComposantParcelle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Parcelle implements ComposantParcelle {


    protected Coordonnees coord;
    protected boolean irriguee;
    protected List<Parcelle> voisins;
    protected List<Bambou> bambous = new ArrayList<Bambou>();

    public Parcelle(Coordonnees coord){
        this.coord = coord;
    }


    public Parcelle(){
        this.voisins=new ArrayList<Parcelle>();
        this.bambous = new ArrayList<Bambou>();
    }

    public abstract Couleur getCouleur();
    public abstract void fairePousserBambou(Bambou bambou);
    public abstract void prendreBambou();
    public abstract int getNbSectionsDeBambou();


    public Coordonnees getCoordonnees(){
        return this.coord;
    }

    public List<Parcelle> getVoisins(){
        return this.voisins;
    }
    public  List<Bambou> getBambous () {return this.bambous; }

    public boolean estIrriguee() {
        return irriguee == true;
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


    /*public int getNombreDeBambous () {
        return this.bambous.size();
    }*/

    public void mangerBambou() {
        this.bambous.remove(0);
    }

    public boolean estAdjacent(Parcelle p){
        return (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() + 2) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() - 2);
    }

    /*
     * Cette méthode après sera utilisée pour faire une parcelle irriguée,
     * et pour faire pousser un bambou
     * si une parcelle est à côté de Etange çela deviendra irriguée.
     */
    public boolean estAdjacentAParcelleEtang(Parcelle p){
        return (p.coord.getX() == 2 && p.coord.getY() == 1) ||
                (p.coord.getX() == 2 && p.coord.getY() == - 1) ||
                (p.coord.getX() == - 2 && p.coord.getY() == 1) ||
                (p.coord.getX() == - 2 && p.coord.getY() == - 1) ||
                (p.coord.getX() == 0 && p.coord.getY() == 2) ||
                (p.coord.getX() == 0 && p.coord.getY() == - 2);
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
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (!(obj instanceof Parcelle)) return false;

        return this.coord.equals(((Parcelle) obj).coord) && this.getCouleur() == ((Parcelle) obj).getCouleur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, this.getCouleur());
    }

    @Override
    public String toString(){
        return "Parcelle de couleur "+ this.getCouleur()+
                ", nombre de bambous: "+ getNombreDeBambous ();
    }

}
