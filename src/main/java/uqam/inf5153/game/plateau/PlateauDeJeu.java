package uqam.inf5153.game;

//import com.sun.istack.internal.NotNull;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleEtang;
import uqam.inf5153.game.parcelle.ParcelleVerte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlateauDeJeu {

    private List<Parcelle> parcelles;
    private HashSet<Coordonnees> positionsDisponibles;


    public PlateauDeJeu() {
        this.parcelles =new ArrayList<Parcelle>();
        this.positionsDisponibles =new HashSet<Coordonnees>();
    }

    public int nbreElement(){
        return parcelles.size();
    }

    public void initialiserPlateauDeJeu(){
        Parcelle p1= new ParcelleEtang(new Coordonnees(0,0));
        parcelles.add(p1);
        positionsDisponibles.add(new Coordonnees(2,1));
        positionsDisponibles.add(new Coordonnees(2,-1));
        positionsDisponibles.add(new Coordonnees(-2,1));
        positionsDisponibles.add(new Coordonnees(-2, -1));
        positionsDisponibles.add(new Coordonnees(0,-2));
        positionsDisponibles.add(new Coordonnees(0,2));
    }

    public void placerUneParcelle(int x, int y){
        Coordonnees c = new Coordonnees(x,y);
        parcelles.add(new ParcelleVerte(c));
        positionsDisponibles.removeIf(coord -> coord.equals(c));
    }

    public boolean estPositionOccupee(int x, int y){
        boolean trouve =false;
        Coordonnees c=new Coordonnees(x,y);
        int i=0;
        Parcelle parcelle;
        while(i < parcelles.size() && !trouve) {
            parcelle = parcelles.get(i);
            if (parcelle != null &&
                    parcelle.getCoordonnees()!=null &&
                    parcelle.getCoordonnees().equals(c)) {
                trouve = true;
            }
            i++;
        }
        return !trouve;
    }

    public void mettreAjourListePosiDisp(int x, int y){
        if (!estPositionOccupee(x + 2, y + 1)) {
            positionsDisponibles.add(new Coordonnees(x+2,y+1));};
        if (!estPositionOccupee(x + 2, y - 1)) {
            positionsDisponibles.add(new Coordonnees(x+2,y-1));};
        if (!estPositionOccupee(x - 2, y - 1)) {
            positionsDisponibles.add(new Coordonnees(x-2,y-1));};
        if (!estPositionOccupee(x - 2, y + 1)) {
            positionsDisponibles.add(new Coordonnees(x-2,y+1));};
        if (!estPositionOccupee(x, y + 2)) {
            positionsDisponibles.add(new Coordonnees(x,y+2));};
        if (!estPositionOccupee(x, y - 2)) {
            positionsDisponibles.add(new Coordonnees(x,y-2));};
    }


    public void afficherLesPositionsDispo(){
        for(Coordonnees elem: positionsDisponibles)
        {
            System.out.println ("( "+ elem.getX() +", " +elem.getY()+" )");
        }

    }

    public void afficherParcelleDeposee() {
        int i=0;
        while(i < parcelles.size()) {
            if (parcelles.get(i)!=null && parcelles.get(i).getCoordonnees()!=null) {
                System.out.println(parcelles.get(i).getCoordonnees().toString());
            }
            i++;
        }

    }

}