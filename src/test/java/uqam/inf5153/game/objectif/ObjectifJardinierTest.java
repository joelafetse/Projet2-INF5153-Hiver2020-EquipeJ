package uqam.inf5153.game.objectif;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.actions.PlaceParcelle;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.AmenagementBassin;
import uqam.inf5153.game.tuile.amenagement.AmenagementEnclos;
import uqam.inf5153.game.tuile.amenagement.AmenagementEngrais;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;
import uqam.inf5153.game.tuile.parcelle.ParcelleRose;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class ObjectifJardinierTest {

        @Test
        public void testAppliquerObjectif_16() {
            //4 bambous jaunes sur une parcelle jaune avec amenagement bassain, point=5
            PlateauDeJeu plateau =new PlateauDeJeu();
            ComposantParcelle p1=new AmenagementBassin(new ParcelleJaune());
            Jeu jeu=new Jeu(2);
            PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
            placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            ObjectifJardinier objectif =new ObjectifJardinier(16);
            assertEquals(objectif.appliquerObjectif(plateau), 5);
        }

        @Test
        public void testAppliquerObjectif_17() {
            //4 bambous jaunes sur une parcelle jaune sans amenagement, point=6
            PlateauDeJeu plateau =new PlateauDeJeu();
            ComposantParcelle p1=new ParcelleJaune();
            Jeu jeu=new Jeu(2);
            PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
            placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            p1.fairePousserBambou();
            ObjectifJardinier objectif =new ObjectifJardinier(17);
            assertEquals(objectif.appliquerObjectif(plateau), 6);

        }

        @Test
        public void testAppliquerObjectif_18() {
         //plus de 2 parcelles roses avec 3 bambous roses chacune, point=6
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleRose();
        ComposantParcelle p2=new ParcelleRose();
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p2.fairePousserBambou();
        p2.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(18);
        assertEquals(objectif.appliquerObjectif(plateau), 6);
    }

    @Test
    public void testAppliquerObjectif_19() {
        //plus de 3 parcelles jaunes avec 3 bambous jaunes chacune, point=7
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        ComposantParcelle p2=new ParcelleJaune();
        ComposantParcelle p3=new ParcelleJaune();
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,-1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p2.fairePousserBambou();
        p2.fairePousserBambou();
        p3.fairePousserBambou();
        p3.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(19);
        assertEquals(objectif.appliquerObjectif(plateau), 7);
    }

    @Test
    public void testAppliquerObjectif_20() {
        //plus de 4 parcelles vertes avec 3 bambous verts chacune, point=8
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleVerte();
        ComposantParcelle p2=new ParcelleVerte();
        ComposantParcelle p3=new ParcelleVerte();
        ComposantParcelle p4=new ParcelleVerte();
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,-1);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,2,3);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p2.fairePousserBambou();
        p2.fairePousserBambou();
        p3.fairePousserBambou();
        p3.fairePousserBambou();
        p4.getComposant().setIrriguee(true);
        p4.fairePousserBambou();
        p4.fairePousserBambou();
        p4.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(20);
        assertEquals(objectif.appliquerObjectif(plateau), 8);
    }

    @Test
    public void testAppliquerObjectif_21(){
        //4 bambous verts sur une parcelle verte avec amenagement enclos, point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEnclos(new ParcelleVerte());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(21);
        assertEquals(objectif.appliquerObjectif(plateau), 4);
    }

    @Test
    public void testAppliquerObjectif_22(){
        //4 bambous verts sur une parcelle verte avec amenagement bassin, point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementBassin(new ParcelleVerte());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(22);
        assertEquals(objectif.appliquerObjectif(plateau), 4);
    }

    @Test
    public void testAppliquerObjectif_23(){
        //4 bambous verts sur une parcelle verte sans amenagement, point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1= new ParcelleVerte();
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(23);
        assertEquals(objectif.appliquerObjectif(plateau), 5);
    }

    @Test
    public void testAppliquerObjectif_24(){
        //4 bambous jaunes sur une parcelle jaune avec amenagement angrais, point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEngrais(new ParcelleJaune());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(24);
        assertEquals(objectif.appliquerObjectif(plateau), 4);
    }

    @Test
    public void testAppliquerObjectif_25(){
        //4 bambous jaunes sur une parcelle jaune avec amenagement enclos, point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEnclos(new ParcelleJaune());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(25);
        assertEquals(objectif.appliquerObjectif(plateau), 5);
    }

    @Test
    public void testAppliquerObjectif_26(){
        //4 bambous roses sur une parcelle rose avec amenagement engrais, point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEngrais(new ParcelleRose());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(26);
        assertEquals(objectif.appliquerObjectif(plateau), 5);
    }

    @Test
    public void testAppliquerObjectif_27(){
        //4 bambous roses sur une parcelle rose avec amenagement bassin, point=6
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementBassin(new ParcelleRose());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(27);
        assertEquals(objectif.appliquerObjectif(plateau), 6);
    }

    @Test
    public void testAppliquerObjectif_28(){
        //4 bambous roses sur une parcelle rose avec amenagement enclos, point=6
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEnclos(new ParcelleRose());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(28);
        assertEquals(objectif.appliquerObjectif(plateau), 6);
    }

    @Test
    public void testAppliquerObjectif_29(){
        //4 bambous roses sur une parcelle rose sans amenagement, point=7
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleRose();
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(29);
        assertEquals(objectif.appliquerObjectif(plateau), 7);
    }

    @Test
    public void testAppliquerObjectif_30(){
        //4 bambous verts sur une parcelle verte avec amenagement engrais, point=3
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new AmenagementEngrais(new ParcelleVerte());
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        p1.fairePousserBambou();
        ObjectifJardinier objectif =new ObjectifJardinier(30);
        assertEquals(objectif.appliquerObjectif(plateau), 3);
    }

    @Test
    public void testAppliquerObjectif_31() {
        //Identifiant n'existe pas
        PlateauDeJeu plateau =new PlateauDeJeu();
        ObjectifJardinier objectif =new ObjectifJardinier(31);
        assertEquals(objectif.appliquerObjectif(plateau), 0);
    }
}