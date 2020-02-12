package uqam.inf5153.game.parcelle;

public class Bambou {

    private Couleur couleur;

    public Bambou (Couleur couleur) {
        this.couleur = couleur;
    }


    // getters
    public Couleur getCouleur () {
        return couleur;
    }


    @Override
    public boolean equals (Object obj)
    {
        if (obj == null || !(obj instanceof Bambou)) return false;

        Bambou autre = (Bambou) obj;

        return this.couleur.equals(autre.couleur);
    }


}
