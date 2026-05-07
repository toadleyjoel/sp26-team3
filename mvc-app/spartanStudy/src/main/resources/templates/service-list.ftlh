<!DOCTYPE html>
<html>
<head>
    <title>Available Tutoring Services</title>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>

<header class="header">
    <h4>studySpartan</h4>
    <nav>
        <a href="/">Home</a>
        <a href="/services/view">Services</a>
    </nav>
</header>

<main>

    <div class="page-title">
        <h1>Available Tutoring Services</h1>
        <p>Choose a service and subscribe to get help.</p>
    </div>

    <#if services?size == 0>
        <p style="text-align:center;">No services available.</p>
    <#else>

        <div class="services-grid">
            <#list services as service>

                <div class="card">
                    <span class="badge">Tutoring</span>

                    <h2>${service.title}</h2>
                    <p>${service.description}</p>

                    <!-- subscription button -->
                    <a href="/web/students/1/subscribe/${service.id}" class="subscribe-btn">
                        Subscribe
                    </a>
                </div>

            </#list>
        </div>

    </#if>

    <a href="/" class="back-link">← Back Home</a>

</main>

<footer>
    <p>&copy; 2026 studySpartan</p>
</footer>

</body>
</html>