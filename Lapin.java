import java.util.ArrayList;
import java.util.Scanner;

public class Lapin {
    private String nom;
    private String typeChocolat ;
    private boolean garni;
    private Coord position;
    private double poids;

    public Lapin(String nom, String typeChocolat, boolean garni, int x, int y, double poids) {
        this.nom = nom;
        this.typeChocolat = typeChocolat;
        this.garni = garni;
        this.position = new Coord(x, y);
        this.poids = poids;
    }

    public Lapin(String ligne)
    {
        Scanner scLine = new Scanner(ligne);
        nom = scLine.next();
        typeChocolat = ESIGPaques.TAB_CAT_CHOC[scLine.nextInt() - 1];
        garni = scLine.next().equals("oui");
        int x = scLine.nextInt();
        int y = scLine.nextInt();
        position = new Coord(x, y);
        poids = scLine.nextInt()/1000.0;
    }


    public void afficherDistanceAvecLesAutres_Q4a(ArrayList<Lapin> liste)
    {
        for ( Lapin lap : liste )
        {
            if ( !nom.equals(lap.nom) ) //pas le même lapin
                System.out.println(nom+" - "+lap.nom+" : "+distanceAvec(lap));
        }
    }


    //NE PAS MODIFIER la fonction distanceAvec!!
    public int distanceAvec(Lapin autreLapin)
    {
        return position.distanceAvec(autreLapin.position);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Lapin{" +
                "nom='" + nom + '\'' +
                ", typeChocolat='" + typeChocolat + '\'' +
                ", garni=" + garni +
                ", position=" + position +
                ", poids=" + poids +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeChocolat() {
        return typeChocolat;
    }

    public void setTypeChocolat(String typeChocolat) {
        this.typeChocolat = typeChocolat;
    }

    public boolean isGarni() {
        return garni;
    }

    public void setGarni(boolean garni) {
        this.garni = garni;
    }

    public Coord getPosition() {
        return position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
