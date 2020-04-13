package uqam.inf5153.game.objectif;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.actions.PlaceParcelle;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;
import uqam.inf5153.game.tuile.parcelle.ParcelleRose;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;
import uqam.inf5153.game.plateau.PlateauDeJeu;

import static org.junit.Assert.*;

public class ObjectifParcelleTest {

    @Test
    public void testAppliquerObjectif_1() {
        //Triangle vert point=2
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleVerte();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleVerte();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleVerte();
        p3.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        ObjectifParcelle objectif =new ObjectifParcelle(1);
        assertEquals(objectif.appliquerObjectif(plateau), 2);

    }

    @Test
    public void testAppliquerObjectif_2() {
        //Diamant vert point=3
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleVerte();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleVerte();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleVerte();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleVerte();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,0,4);
        ObjectifParcelle objectif =new ObjectifParcelle(2);
        assertEquals(objectif.appliquerObjectif(plateau), 3);
    }

    @Test
    public void testAppliquerObjectif_3() {
        //Diamant Jaune et Rose point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleJaune();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleRose();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleRose();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,0,2);//jaune
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,3);//jaune
        placeParcelle.placerParcelleDansPlateau(plateau,p4,4,2);
        ObjectifParcelle objectif =new ObjectifParcelle(3);
        assertEquals(5, objectif.appliquerObjectif(plateau));

    }

    @Test
    public void testAppliquerObjectif_4() {
        //Diamant Jaune et Vert point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleJaune();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleVerte();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleVerte();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,0,2);//jaune
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,3);//jaune
        placeParcelle.placerParcelleDansPlateau(plateau,p4,4,2);
        ObjectifParcelle objectif =new ObjectifParcelle(5);
        assertEquals(3, objectif.appliquerObjectif(plateau));
    }

    @Test
    public void testAppliquerObjectif_5() {
        //Diamant Rose et Vert point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1= new ParcelleRose();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2= new ParcelleRose();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleVerte();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleVerte();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,0,2);//rose
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,3);//rose
        placeParcelle.placerParcelleDansPlateau(plateau,p4,4,2);
        ObjectifParcelle objectif =new ObjectifParcelle(4);
        assertEquals(4, objectif.appliquerObjectif(plateau));
    }
    @Test
    public void testAppliquerObjectif_6_et_8() {
        //test pour Ligne jaune point=3 et aussi pour Ligne curbé jaune point=3
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleJaune();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleJaune();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleJaune();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        //p1,p2 et p3  produit un ligne curbé jaune (objectif8)
        placeParcelle.placerParcelleDansPlateau(plateau,p1,-2,1);
        // p2, p3 et p4 créent un ligne droit jaune.
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,-2,3);
        ObjectifParcelle objectif6 =new ObjectifParcelle(6);
        assertEquals(3, objectif6.appliquerObjectif(plateau));
        ObjectifParcelle objectif8 =new ObjectifParcelle(8);
        assertEquals(3, objectif8.appliquerObjectif(plateau));
    }

    @Test
    public void testAppliquerObjectif_7() {
        //Diamant Jaune point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleJaune();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleJaune();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleJaune();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,4,2);
        ObjectifParcelle objectif7 =new ObjectifParcelle(7);
        assertEquals(4, objectif7.appliquerObjectif(plateau));
    }
    @Test
    public void testAppliquerObjectif_9_et_10() {
        //test pour Ligne vert point=2 et aussi pour Ligne curbé vert point=2
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleVerte();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleVerte();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleVerte();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleVerte();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        //p1,p2 et p3  produit un ligne curbé vert (objectif
        placeParcelle.placerParcelleDansPlateau(plateau,p1,-2,1);
        // p2, p3 et p4 créent un ligne droit vert.
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,-2,3);
        ObjectifParcelle objectif9 =new ObjectifParcelle(9);
        assertEquals(2, objectif9.appliquerObjectif(plateau));
        ObjectifParcelle objectif10 =new ObjectifParcelle(10);
        assertEquals(2, objectif10.appliquerObjectif(plateau));
    }
    @Test
    public void testAppliquerObjectif_11_et_14() {
        //test pour Ligne rose point=4 et aussi pour Ligne curbé rose point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleRose();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleRose();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleRose();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleRose();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        //p1,p2 et p3  produit un ligne curbé rose (objectif
        placeParcelle.placerParcelleDansPlateau(plateau,p1,-2,1);
        // p2, p3 et p4 créent un ligne droit rose.
        placeParcelle.placerParcelleDansPlateau(plateau,p2,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,-2,3);
        ObjectifParcelle objectif11 =new ObjectifParcelle(11);
        assertEquals(4, objectif11.appliquerObjectif(plateau));
        ObjectifParcelle objectif14 =new ObjectifParcelle(14);
        assertEquals(4, objectif14.appliquerObjectif(plateau));
    }
    @Test
    public void testAppliquerObjectif_12() {
        //Triangle rose point=4
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleRose();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleRose();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleRose();
        p3.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        ObjectifParcelle objectif12 =new ObjectifParcelle(12);
        assertEquals(4, objectif12.appliquerObjectif(plateau));

    }

    @Test
    public void testAppliquerObjectif_13() {
        //Diamant rose point=5
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleRose();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleRose();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleRose();
        p3.getComposant().setIrriguee(true);
        ComposantParcelle p4=new ParcelleRose();
        p4.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        placeParcelle.placerParcelleDansPlateau(plateau,p4,4,2);
        ObjectifParcelle objectif13 =new ObjectifParcelle(13);
        assertEquals(5, objectif13.appliquerObjectif(plateau));
    }
    @Test
    public void testAppliquerObjectif_15() {
        //Triangle jaune point=2
        PlateauDeJeu plateau =new PlateauDeJeu();
        ComposantParcelle p1=new ParcelleJaune();
        p1.getComposant().setIrriguee(true);
        ComposantParcelle p2=new ParcelleJaune();
        p2.getComposant().setIrriguee(true);
        ComposantParcelle p3=new ParcelleJaune();
        p3.getComposant().setIrriguee(true);
        Jeu jeu=new Jeu(2);
        PlaceParcelle placeParcelle=new PlaceParcelle(jeu);
        placeParcelle.placerParcelleDansPlateau(plateau,p1,2,1);
        placeParcelle.placerParcelleDansPlateau(plateau,p2,0,2);
        placeParcelle.placerParcelleDansPlateau(plateau,p3,2,3);
        ObjectifParcelle objectif =new ObjectifParcelle(15);
        assertEquals(3, objectif.appliquerObjectif(plateau));

    }
    @Test
    public void testAppliquerObjectif16() {
        PlateauDeJeu plateau =new PlateauDeJeu();
        ObjectifParcelle objectif =new ObjectifParcelle(16);
        assertEquals(objectif.appliquerObjectif(plateau), 0);
    }



}