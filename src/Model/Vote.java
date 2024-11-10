package Model;

//package com.onlinevoting.model;

public class Vote {
    private int voterId;
    private int electionId;
    private int candidateId;

    // Constructor
    public Vote(int voterId, int electionId, int candidateId) {
        this.voterId = voterId;
        this.electionId = electionId;
        this.candidateId = candidateId;
    }

    // Getters and Setters
    public int getVoterId() { return voterId; }
    public void setVoterId(int voterId) { this.voterId = voterId; }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }
}
