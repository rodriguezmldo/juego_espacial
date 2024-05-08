package SaveData;

import java.util.*;
import java.io.*;


public class profiles {
 
    String name;
    int victories, gamePlayed , defeats, destroyedObjects;

    public profiles(String name,int victories, int gamePlayed, int defeats, int destroyedObjects){
        this.name = name;
        this.victories = victories;
        this.gamePlayed = gamePlayed;
        this.defeats = defeats;
        this.destroyedObjects = destroyedObjects;
    }

    public static void creatingProfileFile(String nameFile){
        File file = new File(nameFile);

        if (!file.exists()) {
            try {
                PrintWriter outFile = new PrintWriter(file);
                outFile.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            
        }
    }

    public static void registeringProfiles(String nameFile, String name, int victories, int gamePlayed, int defeats, int destroyedObjects) {
        String root = "SaveData\\DataFiles\\profiles.txt"; 
        creatingProfileFile(root);
        Scanner inData = new Scanner(System.in);

        String newUsuario = "NO";

        do {
            try {
                // Escribir los datos en el archivo
                BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true)); // true para agregar al final del archivo
                writer.write(name + "," + victories + "," + gamePlayed + "," + defeats + "," + destroyedObjects);
                writer.newLine(); // Nueva línea para el próximo registro
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Nuevo usuario: ");
            newUsuario = inData.nextLine();

        } while (newUsuario.equals("Si"));

        inData.close();
    }
    
}
