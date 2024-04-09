public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <nombre> <nombre> <opérateur>");
            return;
        }

        double nombre1, nombre2, resultat;
        String operateur;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers paramètres doivent être numériques.");
            return;
        }

        operateur = args[2];
        switch (operateur) {
            case "+":
                resultat = nombre1 + nombre2;
                System.out.println("Résultat : " + resultat);
                break;
            case "-":
                resultat = nombre1 - nombre2;
                System.out.println("Résultat : " + resultat);
                break;
            case "x":
                resultat = nombre1 * nombre2;
                System.out.println("Résultat : " + resultat);
                break;
            default:
                System.out.println("Opérateur invalide.");
                break;
        }
    }
}
