package uqam.inf5153.game.plateau;

import java.util.Objects;

public class Coordonnees {

    private int x;
    private int y;

    public Coordonnees(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "("+ x + ","+ y + ")";
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Coordonnees)) return false;

        Coordonnees coord = (Coordonnees) obj;
        return x == coord.x && y == coord.y ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
