<!DOCTYPE html>
<html>
<head>
    <title>Subscribe to Service</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<header class="header">
    <h4>studySpartan</h4>
</header>

<main>

    <div class="card" style="text-align: center; max-width: 500px; margin: auto;">
        
        <div class="page-title">
            <h1>Confirm Subscription</h1>
            <p>Please confirm your request</p>
        </div>

        <p><strong>Student ID:</strong> ${studentId}</p>
        <p><strong>Service ID:</strong> ${serviceId}</p>

        <!-- FIXED FORM -->
        <form action="/web/students/${studentId}/subscribe/${serviceId}" method="post">
            <button type="submit" class="subscribe-btn">
                Confirm Subscribe
            </button>
        </form>

        <a href="/services/view" class="back-link">← Back to Services</a>

    </div>

</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>