package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Voting system to manage candidates and cast votes.
 * It keeps track of votes and determines the election winner.
 */
class Voting {
    private Map<String, Integer> votes;

    public Voting() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the election.
     * 
     * @param name Candidate's name
     */
    public void addCandidate(String name) {
        if (!votes.containsKey(name)) {
            votes.put(name, 0);
        } else {
            System.out.println("Candidate " + name + " is already added.");
        }
    }

    /**
     * Casts a vote for a candidate.
     * 
     * @param name Candidate's name
     * @return true if vote is successful, false if candidate does not exist
     */
    public boolean castVote(String name) {
        if (votes.containsKey(name)) {
            votes.put(name, votes.get(name) + 1);
            return true;
        } 
        System.out.println("Candidate " + name + " does not exist. Vote not counted.");
        return false;
    }

    /**
     * Determines the winner of the election.
     * 
     * @return Winner's name and vote count, or a tie message if applicable
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        boolean tie = false;
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
                tie = false; // Reset tie flag
            } else if (entry.getValue() == maxVotes) {
                tie = true; // Multiple candidates have the highest votes
            }
        }
        
        if (tie) {
            return "It's a tie!";
        }
        
        return winner + " WINS with " + maxVotes + " votes!";
    }

    /**
     * Displays the current vote count for all candidates.
     */
    public void displayResults() {
        System.out.println("\nElection Results:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
