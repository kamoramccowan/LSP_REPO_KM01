package org.howard.edu.lsp.midterm.question3;

/**
 * Tests the Voting class with candidate addition, voting, and result display.
 */
public class VotingTest {
    public static void main(String[] args) {
        Voting vm = new Voting();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Display results and winner
        vm.displayResults();
        System.out.println("\nWinner: " + vm.getWinner());
    }
}
