import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ESIGPaques {

    public static final String[] TAB_CAT_CHOC = {"au lait", "blanc", "noir", "matcha"};
    public static void main(String[] args) {




        ArrayList<Lapin> liste = lireDonnees_Q1_v1("RabbitData.txt");


        for ( Lapin rabbit : liste )
        {
            System.out.println(rabbit);
        }

        System.out.println("Question 2");
        //afficherPoidsMoyens_Q2(liste);
        System.out.println();

        System.out.println("Question 3");
        //Lapin lePlusLourd = lapinLePlusLourd_Q3a(liste);
        //afficherInfoPlusLourd_Q3b(lePlusLourd);
        System.out.println();


        System.out.println("Question 4");

        //liste.get(0).afficherDistanceAvecLesAutres_Q4a(liste);

        //afficherToutesLesDistances_Q4b(liste);
        System.out.println();

    }

    public static ArrayList<Lapin> lireDonnees_Q1_v1( String nomFichier)
    {
        ArrayList<Lapin> liste = new ArrayList<>();
        try {
            Scanner scFile = new Scanner(new File(nomFichier));
            while (scFile.hasNextLine())
            {
                Scanner scLine = new Scanner(scFile.nextLine());

                String nom = scLine.next();


                String typeChocolat = TAB_CAT_CHOC[scLine.nextInt() - 1];
                boolean garni = scLine.next().equals("oui");
                int x = scLine.nextInt();
                int y = scLine.nextInt();
                double poids = scLine.nextInt()/1000.0;

                liste.add(new Lapin(nom, typeChocolat, garni, x, y, poids));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return liste;
    }

}
