package uqam.inf5153.game.plateau;

import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.figurine.Jardinier;
import uqam.inf5153.game.figurine.Panda;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleEtang;

import java.util.*;

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
        parcelles.add(this.parcelleEtang);
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

    public void ajouterParcelle(Parcelle parcelle){
        this.parcelles.add(parcelle);
    }

    public Figurine getJardinier(){
        return jardinier;
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
        while(i < parcelles.size() && !estPositionOccupee) {
            parcelle = parcelles.get(i);
            if (parcelle != null &&
                    parcelle.getCoordonnees()!=null &&
                    parcelle.getCoordonnees().equals(coordonnees)) {
                estPositionOccupee = true;
            }
            i++;
        }
        return estPositionOccupee;
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

    public void mettreAjourListePosiDisp(Coordonnees coord){
        Coordonnees coordonnees[] = new Coordonnees[]
                    {   new Coordonnees(coord.getX()+2,coord.getY()+1),
                        new Coordonnees(coord.getX()+2,coord.getY()-1),
                        new Coordonnees(coord.getX()-2,coord.getY()-1),
                        new Coordonnees(coord.getX()-2,coord.getY()+1),
                        new Coordonnees(coord.getX(),coord.getY()+2),
                        new Coordonnees(coord.getX(),coord.getY()-2)  };
        for (int i=0; i < coordonnees.length; i++){
            if(!estPositionOccupee(coordonnees[i]) && nombreVoisinsOccupes(coordonnees[i])==2)
                positionsDisponibles.add(coordonnees[i]);
        }
    }

    public int nombreVoisinsOccupes(Coordonnees coord){
        if (coord.getX()>=-2 && coord.getX()<=2 && coord.getY()>=-2 && coord.getY()<=2 ) return 2;
        int nbre=0;
        Coordonnees coordonnees[] = new Coordonnees[]
                {   new Coordonnees(coord.getX()+2,coord.getY()+1),
                        new Coordonnees(coord.getX()+2,coord.getY()-1),
                        new Coordonnees(coord.getX()-2,coord.getY()-1),
                        new Coordonnees(coord.getX()-2,coord.getY()+1),
                        new Coordonnees(coord.getX(),coord.getY()+2),
                        new Coordonnees(coord.getX(),coord.getY()-2)  };
        for (int i=0; i < coordonnees.length; i++){
            if(estPositionOccupee(coordonnees[i]))
                nbre++;
        }
        return nbre;
    }


    public void afficherLesPositionsDispo(){
        System.out.println("POSITIONS DISPONIBLES : ");
        for(Coordonnees elem: positionsDisponibles)
        {
            System.out.print (" ( "+ elem.getX() +", " +elem.getY()+" ) ");
        }
        System.out.println();

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