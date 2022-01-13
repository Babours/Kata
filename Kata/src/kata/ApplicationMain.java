package kata;

import kata.bean.Operation;
import kata.service.OperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

/*
    Ma classe BankAccount où tout va se dérouler et qui contient :
    Une classe Operation
    Le main
    Une méthode pour ajouter des fonds
    Une méthode pour retirer des fonds
    Une méthode pour voir l'historique des opérations
*/
public class ApplicationMain {

    private static final OperationService operationService = new OperationService();

    /*
        Mon main appelant les différentes méthodes pour la gestion du compte
    */
    public static void main(String[] args) {
        // On initialise la liste des opérations qui se remplira à chaque fois que l'on ajoutera ou retirera de l'argent
        List<Operation> history = new ArrayList<>();
        // On définit le format des informations que l'on va traiter, on ne pourra pas avoir plus de deux chiffres après la virgule
        DecimalFormat df = new DecimalFormat("#.##");
        int choice;
        boolean end = false;

        // Ceci est la boucle principale de notre script qui va appeler les différentes méthodes
        do {
            // On demande tout d'abord à l'utilisateur ce qu'il veut effectuer comme action
            System.out.println("\n Que souhaitez vous faire? \n 1. Ajouter des fonds \n 2. Retirer des fonds \n 3. Voir l'historique des opérations \n 4. Quitter");
            //On sécurise l'entrée des choix par l'utilisateur avec un bloc try
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();

                switch (choice) {
                    // Le premier choix appelle la fonction permettant à l'utilisateur d'ajouter des fonds
                    case 1:
                        history.add(operationService.addFunds(df, history));
                        System.out.println("Opération validée!\n");
                        break;
                    // Le second choix appelle la fonction permettant à l'utilisateur de retirer des fonds
                    case 2:
                        history.add(operationService.withdrawFunds(df, history));
                        System.out.println("Opération validée!\n");
                        break;
                    // Le troisième choix permet à l'utilisateur d'afficher son historique d'opérations
                    case 3:
                        operationService.printHistory(history);
                        break;
                    // le quatrième choix met fin au programme
                    case 4:
                        System.out.println("Au revoir\n");
                        end = true;
                        break;
                    default:
                        System.out.println("Choix incorrect\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Choix incorrect\n");
            }
        } while (!end);
    }
}
