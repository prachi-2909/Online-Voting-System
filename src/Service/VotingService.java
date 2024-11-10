package Service;

import Dao.ElectionDao;
import Dao.VoterDao;
//import Model.VoteDao;
import Model.Voter;
import Model.Election;
import Model.Vote;

import java.util.List;

public class VotingService {
    private  VoterDao voterDao = new VoterDao();
    private ElectionDao electionDAO = new ElectionDao();
    private VoterDao voteDAO = new VoterDao();

    public boolean registerVoter(Voter voter) {
        return voterDao.registerVoter(voter);
    }

    public Voter authenticateVoter(String email, String password) {
        return voterDao.authenticateVoter(email, password);
    }

    public boolean castVote(int voterId, int electionId, int candidateId) {
        Vote vote = new Vote(voterId, electionId, candidateId);
        return voterDao.saveVote(vote);

    }

    public List<Election> getAllElections() {
        System.out.println(" ");
        return List.of();
    }


    /*public List<Election> getAllElections() {
        return ElectionDao.getAllElections();
    }*/

}
