package uqam.inf5153.game.objectif;

import org.junit.Test;
import uqam.inf5153.game.Jeu;
import uqam.inf5153.game.actions.PlaceParcelle;
import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.bambou.BambouJaune;
import uqam.inf5153.game.bambou.BambouRose;
import uqam.inf5153.game.bambou.BambouVert;
import uqam.inf5153.game.joueur.Joueur;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import static org.junit.Assert.*;

public class ObjectifPandaTest {


    @Test
    public void testAppliquerObjectif_31() {
        //Deux bambous verts mangés par le panda, Points: 3"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouVert();
        Bambou b2=new BambouVert();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(31);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 3);
    }

    @Test
    public void testAppliquerObjectif_34() {
        //Deux bambous verts mangés par le panda, Points: 3"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouVert();
        Bambou b2=new BambouVert();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(34);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 3);
    }

    @Test
    public void testAppliquerObjectif_36() {
        //Deux bambous jaunes mangés par le panda, Points: 4"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouJaune();
        Bambou b2=new BambouJaune();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(36);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 4);
    }

    @Test
    public void testAppliquerObjectif_39() {
        //Deux bambous jaunes mangés par le panda, Points: 4"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouJaune();
        Bambou b2=new BambouJaune();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(39);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 4);
    }

    @Test
    public void testAppliquerObjectif_40() {
        //Deux bambous roses mangés par le panda, Points: 5"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouRose();
        Bambou b2=new BambouRose();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(40);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 5);
    }

    @Test
    public void testAppliquerObjectif_42() {
        //Deux bambous roses mangés par le panda, Points: 5"
        Joueur joueur=new Joueur();
        Bambou b1=new BambouRose();
        Bambou b2=new BambouRose();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        ObjectifPanda objectif =new ObjectifPanda(42);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 5);
    }

    @Test
    public void testAppliquerObjectif_43() {
        //trois bambous de couleurs différents mangés par le panda, Points: 6
        Joueur joueur=new Joueur();
        Bambou b1=new BambouVert();
        Bambou b2=new BambouJaune();
        Bambou b3=new BambouRose();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b3);
        ObjectifPanda objectif =new ObjectifPanda(43);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 6);
    }

    @Test
    public void testAppliquerObjectif_45() {
        //trois bambous de couleurs différents mangés par le panda, Points: 6
        Joueur joueur=new Joueur();
        Bambou b1=new BambouVert();
        Bambou b2=new BambouJaune();
        Bambou b3=new BambouRose();
        joueur.getPlateauDeJoueur().reserverBambousPanda(b1);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b2);
        joueur.getPlateauDeJoueur().reserverBambousPanda(b3);
        ObjectifPanda objectif =new ObjectifPanda(45);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 6);
    }

    @Test
    public void testAppliquerObjectif_46() {
        //Identifiant n'existe pas
        Joueur joueur=new Joueur();
        ObjectifPanda objectif =new ObjectifPanda(46);
        assertEquals(objectif.appliquerObjectif(joueur.getPlateauDeJoueur()), 0);
    }

}