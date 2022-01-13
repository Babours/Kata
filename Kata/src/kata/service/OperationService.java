package kata.service;

import kata.bean.Operation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OperationService {

    /*
        La méthode AddFunds permet à l'utilisateur d'ajouter des fonds sur son compte
        Elle reçoit en paramètres le format défini dans le main ainsi que l'historique des opérations
    */
    public Operation addFunds(DecimalFormat df, List<Operation> history) {
        double amount = 0;
        boolean amount_ok = false;

        do {
            System.out.println("Quel montant voulez-vous ajouter? \n");
            //On sécurise l'entrée des choix par l'utilisateur avec un bloc try
            try {
                Scanner s = new Scanner(System.in);
                amount = Double.parseDouble(df.format(s.nextDouble()));
                // on vérifie qu'un nombre positif a été entré
                if (amount < 0) {
                    System.out.println("Un problème est survenu \n");
                } else {
                    amount_ok = true;
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu \n");
            }
        } while (!amount_ok);

        // On créée une nouvelle opération
        Operation op = new Operation();
        try {
            // Le solde restant de cette opération est calculé en regardant le solde restant de l'opération précédente
            op.setWealth(history.get(history.size() - 1).getWealth() + amount);
        } catch (Exception e) {
            op.setWealth(amount);
        }

        // On complète les attributs de notre opération
        op.setType("Deposit");
        op.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        op.setAmount(amount);
        // la méthode renvoie l'opération créée
        return op;
    }

    /*
        La méthode WithdrawFunds permet à l'utilisateur d'ajouter des fonds sur son compte
        Elle reçoit en paramètres le format défini dans le main ainsi que l'historique des opérations
    */
    public Operation withdrawFunds(DecimalFormat df, List<Operation> history) {
        double amount = 0;
        boolean amount_ok = false;

        do {
            System.out.println("Quel montant voulez-vous retirer? \n");
            //On sécurise l'entrée des choix par l'utilisateur avec un bloc try
            try {
                Scanner s = new Scanner(System.in);
                amount = Double.parseDouble(df.format(s.nextDouble()));
                // on vérifie qu'un nombre positif a été entré
                if (amount < 0) {
                    System.out.println("Un problème est survenu \n");
                    // on vérifie qu'il y ait assez de fonds à retirer
                } else if (amount > history.get(history.size() - 1).getWealth()) {
                    System.out.println("Pas assez de fonds \n");
                } else {
                    amount_ok = true;
                }
            } catch (Exception e) {
                System.out.println("Un problème est survenu \n");
            }
        } while (!amount_ok);

        // On créée une nouvelle opération
        Operation op = new Operation();
        try {
            // Le solde restant de cette opération est calculé en regardant le solde restant de l'opération précédente
            op.setWealth(history.get(history.size() - 1).getWealth() - amount);
        } catch (Exception e) {
            op.setWealth(amount);
        }

        // On complète les attributs de notre opération
        op.setType("Withdraw");
        op.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        op.setAmount(amount);

        // la méthode renvoie l'opération créée
        return op;
    }

    /*
        La méthode PrintHistory permet à l'utilisateur d'afficher les opérations qui ont eu lieu
        Elle reçoit en paramètre l'historique des opérations
    */
    public void printHistory(List<Operation> history) {
        System.out.println("Voici l'historique de vos transactions: \n");
        // On boucle sur notre historique et on affiche les opérations une par une
        for (Operation operation : history) {
            System.out.println(operation.getType() + ", " + operation.getDate() + ", " + operation.getAmount() + ", " + operation.getWealth());
        }

    }
}
