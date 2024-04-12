package fr.hetic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileSystemReader implements fr.hetic.FileReader {
    private String filePath; // Chemin du fichier à lire

    public FileSystemReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Traitement de chaque ligne lue depuis le fichier
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + filePath + ": " + e.getMessage());
        }
    }
}

