<!DOCTYPE html>
<html>
<head>
    <title>Write a Review - StudySpartan</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<header class="header">
    <h4>studySpartan</h4>
    <nav>
        <a href="/">Home</a>
        <a href="/services/view">Services</a>
        <a href="/reviews">Reviews</a>
    </nav>
</header>

<main>

    <div class="card" style="max-width: 550px; margin: auto;">

        <div class="page-title" style="text-align: center;">
            <h1>Write a Review</h1>
            <p>Share your experience with a tutoring service.</p>
        </div>

        <form action="/reviews/save" method="post">

            <label for="studentId">Student ID:</label>
            <input type="number" id="studentId" name="studentId" required>
            <br><br>

            <label for="serviceId">Service ID:</label>
            <input type="number" id="serviceId" name="serviceId" required>
            <br><br>

            <label for="rating">Rating:</label>
            <select id="rating" name="rating" required>
                <option value="">Select a rating</option>
                <option value="5">5 - Excellent</option>
                <option value="4">4 - Good</option>
                <option value="3">3 - Okay</option>
                <option value="2">2 - Poor</option>
                <option value="1">1 - Bad</option>
            </select>
            <br><br>

            <label for="comment">Review:</label>
            <br>
            <textarea id="comment" name="comment" rows="5" cols="45" required></textarea>
            <br><br>

            <button type="submit" class="subscribe-btn">Submit Review</button>

        </form>

        <br>

        <a href="/reviews" class="back-link">View All Reviews</a>
        <br>
        <a href="/services/view" class="back-link">← Back to Services</a>

    </div>

</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>