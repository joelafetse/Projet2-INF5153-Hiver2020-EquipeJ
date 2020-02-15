package uqam.inf5153.game;

import com.sun.istack.internal.NotNull;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleEtang;
import uqam.inf5153.game.parcelle.ParcelleVerte;

import java.util.ArrayList;
import java.util.HashSet;

public class PlateauDeJeu {

private ArrayList<Parcelle> plateau ;
private HashSet<Coordonnees> candidat;


public PlateauDeJeu() {
        this.plateau =new ArrayList<Parcelle>();
        this.candidat=new HashSet<Coordonnees>();
}

public int nbreElement(){
    return plateau.size();
}

public void initialiserPlateauDeJeu(){
    Parcelle p1= new ParcelleEtang(new Coordonnees(0,0));
    plateau.add(p1);
    candidat.add(new Coordonnees(2,1));
    candidat.add(new Coordonnees(2,-1));
    candidat.add(new Coordonnees(-2,1));
    candidat.add(new Coordonnees(-2, -1));
    candidat.add(new Coordonnees(0,-2));
    candidat.add(new Coordonnees(0,2));
}

public void placerUneParcelle(int x, int y){
        Coordonnees c = new Coordonnees(x,y);
        plateau.add(new ParcelleVerte(c));
        candidat.removeIf(coord -> coord.equals(c));
}

public boolean positionOccupee(int x, int y){
boolean trouve =false;
Coordonnees c=new Coordonnees(x,y);
int i=0;
while(i <plateau.size() && !trouve) {
    if (plateau.get(i)!=null && plateau.get(i).getCoordonnees()!=null && plateau.get(i).getCoordonnees().equals(c)) {
        trouve = true;
    }
    i++;
}
    return !trouve;
}

public void mettreAjourListePosiDisp(int x, int y){
    if (!positionOccupee(x + 2, y + 1)) {candidat.add(new Coordonnees(x+2,y+1));};
    if (!positionOccupee(x + 2, y - 1)) {candidat.add(new Coordonnees(x+2,y-1));};
    if (!positionOccupee(x - 2, y - 1)) {candidat.add(new Coordonnees(x-2,y-1));};
    if (!positionOccupee(x - 2, y + 1)) {candidat.add(new Coordonnees(x-2,y+1));};
    if (!positionOccupee(x, y + 2)) {candidat.add(new Coordonnees(x,y+2));};
    if (!positionOccupee(x, y - 2)) {candidat.add(new Coordonnees(x,y-2));};
}


public void afficherLesPositionsDispo(){
    for(Coordonnees elem: candidat)
    {
        System.out.println ("( "+ elem.getX() +", " +elem.getY()+" )");
    }

}

  public void afficherParcelleDeposee() {
      int i=0;
      while(i <plateau.size()) {
          if (plateau.get(i)!=null && plateau.get(i).getCoordonnees()!=null) {
              System.out.println(plateau.get(i).getCoordonnees().toString());
         }
          i++;
      }

  }

}