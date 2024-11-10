-- Step 1: Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS online_voting_system;

-- Step 2: Use the created database
USE online_voting_system;

-- Step 3: Create table for storing voter information
CREATE TABLE IF NOT EXISTS voters (
    voter_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- Step 4: Create table for storing election details
CREATE TABLE IF NOT EXISTS elections (
    election_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE NOT NULL
) ENGINE=InnoDB;

-- Step 5: Create table for storing candidate information
CREATE TABLE IF NOT EXISTS candidates (
    candidate_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    election_id INT,
    FOREIGN KEY (election_id) REFERENCES elections(election_id)
) ENGINE=InnoDB;

-- Step 6: Create table for storing votes
CREATE TABLE IF NOT EXISTS votes (
    vote_id INT AUTO_INCREMENT PRIMARY KEY,
    voter_id INT,
    election_id INT,
    candidate_id INT,
    vote_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (voter_id) REFERENCES voters(voter_id),
    FOREIGN KEY (election_id) REFERENCES elections(election_id),
    FOREIGN KEY (candidate_id) REFERENCES candidates(candidate_id),
    CONSTRAINT unique_vote UNIQUE (voter_id, election_id)
) ENGINE=InnoDB;

-- Step 7: Insert 10 sample values into the 'voters' table
INSERT INTO voters (name, email, password) VALUES
('John Doe', 'john.doe@example.com', 'password123'),
('Jane Smith', 'jane.smith@example.com', 'securepassword'),
('Alice Johnson', 'alice.johnson@example.com', 'mypassword'),
('Bob Brown', 'bob.brown@example.com', '1234abcd'),
('Charlie White', 'charlie.white@example.com', 'qwertyuiop'),
('David Green', 'david.green@example.com', 'password1'),
('Eva Black', 'eva.black@example.com', 'letmein'),
('Frank Blue', 'frank.blue@example.com', 'blue123'),
('Grace Red', 'grace.red@example.com', 'hello123'),
('Hank Gray', 'hank.gray@example.com', 'securepassword1');

-- Step 8: Insert 2 sample elections into the 'elections' table
INSERT INTO elections (title, description, date) VALUES
('Presidential Election 2024', 'Election for President of the country.', '2024-11-03'),
('Congressional Election 2024', 'Election for the Congressional members.', '2024-11-03');

-- Step 9: Insert 4 sample candidates into the 'candidates' table
INSERT INTO candidates (name, election_id) VALUES
('Alice Johnson', 1),  -- Alice Johnson running for President
('Bob Brown', 1),      -- Bob Brown running for President
('Charlie White', 2),  -- Charlie White running for Congress
('David Green', 2);    -- David Green running for Congress

-- Step 10: Insert 5 sample votes into the 'votes' table
INSERT INTO votes (voter_id, election_id, candidate_id) VALUES
(1, 1, 1),  -- John Doe votes for Alice Johnson in the Presidential Election
(2, 1, 2),  -- Jane Smith votes for Bob Brown in the Presidential Election
(3, 2, 4),  -- Alice Johnson votes for David Green in the Congressional Election
(4, 2, 3),  -- Bob Brown votes for Charlie White in the Congressional Election
(5, 1, 1);  -- Charlie White votes for Alice Johnson in the Presidential Election
