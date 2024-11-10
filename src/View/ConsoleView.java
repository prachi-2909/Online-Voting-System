package View;

import Model.Voter;
import Model.Election;
import Service.VotingService;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private VotingService votingService;
    private Scanner scanner;

    public ConsoleView() {
        votingService = new VotingService();
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerVoter();
                    break;
                case 2:
                    loginVoter();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void registerVoter() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Voter voter = new Voter(0, name, email, password);
        if (votingService.registerVoter(voter)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
        }
    }

    private void loginVoter() {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Voter voter = votingService.authenticateVoter(email, password);
        if (voter != null) {
            System.out.println("Login successful!");
            displayElectionList(voter);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void displayElectionList(Voter voter) {
        List<Election> elections = votingService.getAllElections();
        System.out.println("Available Elections:");
        for (Election election : elections) {
            System.out.println(election.getId() + ". " + election.getTitle());
        }
        System.out.println("Select election to vote:");
        int electionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // For simplicity, assume candidates are already available for voting
        System.out.println("Enter candidate ID to vote:");
        int candidateId = scanner.nextInt();

        if (votingService.castVote(voter.getId(), electionId, candidateId)) {
            System.out.println("Vote cast successfully!");
        } else {
            System.out.println("Failed to cast vote.");
        }
    }
}

