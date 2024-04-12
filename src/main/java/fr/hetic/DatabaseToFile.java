package fr.hetic;

import java.sql.*;

public class DatabaseToFile {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP";
        String user = "etudiant";
        String password = "MT4@hetic2324";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT F.NOM, L.PARAM1, L.PARAM2, L.OPERATEUR, L.INDEX " +
                    "FROM FICHIER F " +
                    "INNER JOIN LIGNE L ON F.ID = L.FICHIER_ID " +
                    "WHERE F.TYPE = 'OP'";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    String nomFichier = resultSet.getString("NOM");
                    int param1 = resultSet.getInt("PARAM1");
                    int param2 = resultSet.getInt("PARAM2");
                    String operateur = resultSet.getString("OPERATEUR");
                    int index = resultSet.getInt("INDEX");

                    // Générer le nom du fichier par convention
                    String nomFichierFinal = generateFileName(nomFichier, param1, param2);

                    // Écrire les données dans le fichier
                    writeToFile(nomFichierFinal, param1, param2, operateur, index);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String generateFileName(String nomFichier, int param1, int param2) {
        return nomFichier + "_" + param1 + "_" + param2 + ".txt";
    }

    private static void writeToFile(String fileName, int param1, int param2, String operateur, int index) {
        System.out.println("Nom du fichier: " + fileName);
        System.out.println("Param1: " + param1);
        System.out.println("Param2: " + param2);
        System.out.println("Operateur: " + operateur);
        System.out.println("Index: " + index);
        System.out.println("-----------------------------------");
    }
}
