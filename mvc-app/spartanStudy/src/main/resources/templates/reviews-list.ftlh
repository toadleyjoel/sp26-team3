<!DOCTYPE html>
<html>
<head>
    <title>Student Reviews - studySpartan</title>
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

    <div class="page-title" style="text-align: center;">
        <h1>Student Reviews</h1>
        <p>See what students are saying about our tutoring services.</p>
    </div>

    <div style="text-align: center; margin-bottom: 30px;">
        <a href="/reviews/new" class="subscribe-btn">Write a Review</a>
    </div>

    <#if reviews?size == 0>
        <section class="card" style="max-width: 700px; margin: 0 auto; text-align: center;">
            <p>No reviews have been submitted yet.</p>
        </section>
    <#else>
        <div class="services-grid">
            <#list reviews as review>
                <div class="card review-card">
                    <span class="badge">Review</span>

                    <h2>Service ID: ${review.serviceId}</h2>

                    <p><strong>Student ID:</strong> ${review.studentId}</p>
                    <p><strong>Rating:</strong> ${review.rating}/5</p>
                    <p><strong>Comment:</strong></p>
                    <p>${review.comment}</p>
                </div>
            </#list>
        </div>
    </#if>

    <div style="text-align: center; margin-top: 30px;">
        <a href="/" class="back-link">← Back Home</a>
    </div>

</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>