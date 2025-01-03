<!DOCTYPE html>
<html>
<head>
    <title>Vote Now!</title>
</head>
<body>
    <h2>Vote Now!</h2>
    <form action="vote" method="post">
        <label for="candidate">Choose a candidate:</label>
        <select name="candidate" id="candidate" required>
            <option value="candidate1">Candidate 1</option>
            <option value="candidate2">Candidate 2</option>
        </select><br>
        <button type="submit">Submit Vote</button>
    </form>
</body>
</html>
