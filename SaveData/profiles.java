package SaveData;

import java.util.*;
import java.io.*;


public class profiles {
 
    String name;
    int victories, gamePlayed , defeats;

    public profiles(String name,int victories, int gamePlayed, int defeats){
        this.name = name;
        this.victories = victories;
        this.gamePlayed = gamePlayed;
        this.defeats = defeats;
    }

    public static void procesoRegistro(){
        String root = "SaveData\\DataFiles\\profiles.txt"; 
        crearPerfiles(root);
        Scanner inData = new Scanner(System.in);

        String newUsuario = "NO", name;
        int victories, gamePlayed, defeats;
        

        do {
            // Solicitar datos al usuario
            System.out.print("Ingresa el nombre: ");
            name = inData.nextLine();
            System.out.print("Ingresa el número de victorias: ");
            victories = Integer.parseInt(inData.nextLine());
            System.out.print("Ingresa el número de partidas: ");
            gamePlayed = Integer.parseInt(inData.nextLine());
            System.out.print("Ingresa el número de derrotas: ");
            defeats = Integer.parseInt(inData.nextLine());

            registroPerfiles(root, name, victories, gamePlayed, defeats);

            System.out.print("Nuevo usuario: ");
            newUsuario = inData.nextLine();

        } while (newUsuario.equals("Si"));

        inData.close();
    }

    public static void crearPerfiles(String nameFile){
        File file = new File(nameFile);

        if (!file.exists()) {
            try {
                PrintWriter outFile = new PrintWriter(file);
                outFile.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace(System.out);
            }
        } else {
            System.out.println("El archivo ya existe.");
        }
    }

    public static void registroPerfiles(String nameFile, String name, int victories, int gamePlayed, int defeats) {
    
        try {
            // Escribir los datos en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true)); // true para agregar al final del archivo
            writer.write(name + "," + victories + "," + gamePlayed + "," + defeats);
            writer.newLine(); // Nueva línea para el próximo registro
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
