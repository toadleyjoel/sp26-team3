<!DOCTYPE html>
<html>
<head>
    <title>Review Submitted - studySpartan</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<header class="header">
    <h4>studySpartan</h4>
    <nav>
        <a href="/">Home</a>
        <a href="/services/view">Services</a>
        <a href="/reviews">Reviews</a>
        <a href="/reviews/new">Write Review</a>
    </nav>
</header>

<main>
    <section class="card" style="max-width: 700px; margin: 40px auto; text-align: center;">
        <span class="badge">Review Submitted</span>

        <div class="page-title">
            <h1>Review Submitted Successfully!</h1>
            <p>Your feedback has been saved.</p>
        </div>

        <div style="text-align: left; margin-top: 25px; line-height: 1.9; font-size: 18px;">
            <p><strong>Student ID:</strong> ${review.studentId}</p>
            <p><strong>Service ID:</strong> ${review.serviceId}</p>
            <p><strong>Rating:</strong> ${review.rating}/5</p>
            <p><strong>Comment:</strong> ${review.comment}</p>
        </div>

        <div style="margin-top: 30px; display: flex; gap: 15px; justify-content: center; flex-wrap: wrap;">
            <a href="/reviews" class="subscribe-btn">View All Reviews</a>
            <a href="/reviews/new" class="subscribe-btn">Write Another Review</a>
            <a href="/" class="back-link">← Back Home</a>
        </div>
    </section>
</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>