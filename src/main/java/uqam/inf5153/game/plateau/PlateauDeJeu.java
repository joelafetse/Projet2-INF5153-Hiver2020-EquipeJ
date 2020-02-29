package uqam.inf5153.game.plateau;

import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.figurine.Panda;
import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleEtang;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.parcelleEtang =  new ParcelleEtang(new Coordonnees(0,0));
        this.jardinier = new Jardinier(parcelleEtang);
        this.panda = new Panda(parcelleEtang);
        initialiserPlateauDeJeu();
    }

    public int nbreDeParcelles(){
        return parcelles.size();
    }

    private void initialiserPlateauDeJeu(){
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

    public HashSet<Coordonnees> getPositionsDisponibles() {
        return positionsDisponibles;
    }

    public List<ReseauIrrigation> getReseauxIrr(){
        return reseauxIrr;
    }

    /*public void placerUneParcelle(Parcelle parcelle, int x, int y){
        Coordonnees c = new Coordonnees(x,y);
        parcelle.setCoordonnees(c);
        parcelles.add(parcelle);
        positionsDisponibles.removeIf(coord -> coord.equals(c));
        int i=positionParcelle(x-2,y+1);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
        i=positionParcelle(x,y+2);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
        i=positionParcelle(x+2,y+1);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
        i=positionParcelle(x+2,y-1);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
        i=positionParcelle(x,y-2);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
        i=positionParcelle(x-2,y-1);
        if(i!=-1){
            parcelle.setVoisins(parcelles.get(i));
        }
    }*/

    public void ajouterParcelle(Parcelle p){
        this.parcelles.add(p);
    }

    public Parcelle getParcelleAtPosition(Coordonnees position){
        Parcelle parcelle = null;
        for (Parcelle p: parcelles){
            if (p.getCoordonnees().equals(position)){
                parcelle = p;
                break;
            }
        }
        return parcelle;
    }

    public boolean estPositionOccupee(Coordonnees coordonnees){
        boolean estPositionOccupee = false;
        int i=0;
        Parcelle parcelle;
        while(i < parcelles.size()) {
            parcelle = parcelles.get(i);
            if (parcelle != null &&
                    parcelle.getCoordonnees()!=null &&
                    parcelle.getCoordonnees().equals(coordonnees)) {
                estPositionOccupee = true;
                break;
            }
            i++;
        }
        return !estPositionOccupee;
    }

    public int positionParcelle(int x, int y){
        Coordonnees c=new Coordonnees(x,y);
        int i=0;
        Parcelle parcelle;
        while(i < parcelles.size()) {
            parcelle = parcelles.get(i);
            if (parcelle != null &&
                    parcelle.getCoordonnees()!=null &&
                    parcelle.getCoordonnees().equals(c)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void mettreAjourListePosiDisp(int x, int y){
        Coordonnees coordonnees[] = new Coordonnees[]
                    {   new Coordonnees(x+2,y+1),
                        new Coordonnees(x+2,y-1),
                        new Coordonnees(x-2,y-1),
                        new Coordonnees(x-2,y+1),
                        new Coordonnees(x,y+2),
                        new Coordonnees(x,y-2)  };
        for (int i=0; i < coordonnees.length; i++){
            if(!estPositionOccupee(coordonnees[i]))
                positionsDisponibles.add(coordonnees[i]);
        }
    }


    public void afficherLesPositionsDispo(){
        for(Coordonnees elem: positionsDisponibles)
        {
            System.out.println ("( "+ elem.getX() +", " +elem.getY()+" )");
        }

    }

    public void afficherParcelleDeposees() {
        int i=0;
        while(i < parcelles.size()) {
            if (parcelles.get(i)!=null && parcelles.get(i).getCoordonnees()!=null) {
                System.out.println(parcelles.get(i) + " : Coordonnées" +
                        parcelles.get(i).getCoordonnees());
            }
            i++;
        }
    }

    public void ajouterNouveauReseauIrrigation(ReseauIrrigation nouveauReseau){
        this.reseauxIrr.add(nouveauReseau);
    }
}