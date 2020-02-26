package uqam.inf5153.game.plateau;

//import com.sun.istack.internal.NotNull;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.figurine.Panda;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleEtang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlateauDeJeu {

    private List<Parcelle> parcelles;
    private HashSet<Coordonnees> positionsDisponibles;
    private List<ReseauIrrigation> reseauxIrr;
    private Figurine jardinier;
    private Figurine panda;
    private Parcelle parcelleEtang;


    public PlateauDeJeu() {
        this.parcelles = new ArrayList<>();
        this.positionsDisponibles = new HashSet<>();
        this.reseauxIrr = new ArrayList<>();
        this.jardinier = new Jardinier();
        this.panda = new Panda();
        this.parcelleEtang =  new ParcelleEtang(new Coordonnees(0,0));
    }

    public int nbreDeParcelles(){
        return parcelles.size();
    }

    public void initialiserPlateauDeJeu(){
        parcelles.add(parcelleEtang);
        positionsDisponibles.add(new Coordonnees(2,1));
        positionsDisponibles.add(new Coordonnees(2,-1));
        positionsDisponibles.add(new Coordonnees(-2,1));
        positionsDisponibles.add(new Coordonnees(-2, -1));
        positionsDisponibles.add(new Coordonnees(0,-2));
        positionsDisponibles.add(new Coordonnees(0,2));
    }

    public Parcelle getParcelleEtang() {
        return parcelleEtang;
    }

    public List<Parcelle> getParcelles() {
        return parcelles;
    }

    arcelle getParcelle() {
        return parcelles;
    }

    public List<ReseauIrrigation> getReseauxIrr(){
        return reseauxIrr;
    }

    public void placerUneParcelle(Parcelle parcelle, int x, int y){
        Coordonnees c = new Coordonnees(x,y);
        parcelle.setCoordonnees(c);
        parcelles.add(parcelle);
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

    public void ajouterNouveauReseauIrrigation(ReseauIrrigation nouveauReseau){
        this.reseauxIrr.add(nouveauReseau);
    }
}