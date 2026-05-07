<!DOCTYPE html>
<html>
<head>
    <title>Subscription Success</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<header class="header">
    <h4>studySpartan</h4>
</header>

<main>

    <div class="card" style="text-align: center; max-width: 550px; margin: auto;">

        <div class="page-title">
            <h1>Subscription Successful 🎉</h1>
            <p>Your tutoring session has been booked</p>
        </div>

        <p style="font-size: 18px; margin-top: 20px;">
            You have successfully subscribed to the tutoring service.
        </p>

        <div style="margin-top: 25px; text-align: left;">
            <p><strong>Subscription ID:</strong> ${subscription.id}</p>
            <p><strong>Student ID:</strong> ${subscription.studentId}</p>
            <p><strong>Service ID:</strong> ${subscription.serviceId}</p>
        </div>

        <a href="/services/view" class="subscribe-btn" style="margin-top: 25px;">
            View More Services
        </a>

        <br>

        <a href="/" class="back-link">← Back Home</a>

    </div>

</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>