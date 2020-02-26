package uqam.inf5153.game.parcelle;

import uqam.inf5153.game.plateau.Coordonnees;

public abstract class Parcelle {

    protected Coordonnees coord;
    protected boolean irriguee;
    private voisin

    public Parcelle(Coordonnees coordonnees, boolean irriguee){

    }

    public Coordonnees getCoordonnees(){
        return this.coord;
    }

    public boolean estIrriguee() {
        return irriguee;
    }


    @Override
    public boolean equals(Object obj) {
        return obj instanceof Parcelle &&
                this.coord.equals(((Parcelle) obj).coord) &&
    }

    public boolean estAdjacent(Parcelle p){
        return (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() + 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() + 1) ||
                (p.coord.getX() == this.coord.getX() - 2 && p.coord.getY() == this.coord.getY() - 1) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() + 2) ||
                (p.coord.getX() == this.coord.getX() && p.coord.getY() == this.coord.getY() - 2);
    }


    public int [][] listeDesAdjacents(Parcelle p){

        int [][] listeAdjacents = new int[6][2];
        posAdj[0][0]=p.getCoordonnees().getX()-2;
        posAdj[0][1]=p.getCoordonnees().getY()+1;

        posAdj[1][0]=p.getCoordonnees().getX();
        posAdj[1][1]=p.getCoordonnees().getY()+2;

        posAdj[2][0]=p.getCoordonnees().getX()+2;
        posAdj[2][1]=p.getCoordonnees().getY()+1;

        posAdj[3][0]=p.getCoordonnees().getX()+2;
        posAdj[3][1]=p.getCoordonnees().getY()-1;

        posAdj[4][0]=p.getCoordonnees().getX();
        posAdj[4][1]=p.getCoordonnees().getY()-2;

        posAdj[5][0]=p.getCoordonnees().getX()-2;
        posAdj[5][1]=p.getCoordonnees().getY()-1;
        return listeAdjacents;

    }

    public Parcelle[] parcellesAdjacentes(){
        Parcelle[] parcellesAdjacentes=new Parcelle[6];
        for (int i=0; i<6; i++){
            if (lienParcelles[i]!=null) parcellesAdjacentes[i]= lienParcelles[i].getParcelLie(this);
        }
        return parcellesAdjacentes;
    }

}
