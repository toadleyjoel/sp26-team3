## Use Cases Mapped to MVC Implementation

This project follows the MVC pattern by separating the application into Models, Views, Controllers, Services, and Repositories.

- **Model**: Represents the data objects used by the app, such as students, tutoring services, subscriptions, and reviews.
- **View**: Freemarker `.ftlh` templates that display pages to the user.
- **Controller**: Handles browser requests, connects the user’s actions to the correct service logic, and returns the correct view.
- **Service**: Contains the business logic of the application.
- **Repository**: Communicates with the database and handles data persistence.

---

### Use Case 1: View Available Tutoring Services

**User goal:**  
A student wants to see the tutoring services available in StudySpartan.

**MVC implementation:**

- **Controller:** Handles the request to view services.
  - Example route: `/services/view`
  - The controller receives the request and asks the service layer for all available tutoring services.

- **Service:** Retrieves the list of tutoring services.
  - Example method: `getAllServices()`
  - This layer keeps the controller from directly accessing the database.

- **Repository:** Gets tutoring service records from the database.
  - Communicates with the Neon database through Spring Data JPA.

- **Model:** Tutoring service entity/model stores information such as title, description, subject, price, or availability.

- **View:** Displays the services to the user.
  - Example template: `service-list.ftlh`
  - The view loops through the services and shows them as cards on the page.

**Flow:**  
User visits `/services/view` → Controller receives request → Service gets services → Repository reads from database → Controller sends data to view → `service-list.ftlh` displays the services.

---

### Use Case 2: Subscribe to a Tutoring Service

**User goal:**  
A student wants to subscribe to or book a tutoring service.

**MVC implementation:**

- **Controller:** Handles both opening the subscription form and submitting it.
  - Example GET route: `/web/students/{studentId}/subscribe/{serviceId}`
  - Example POST route: `/web/students/{studentId}/subscribe/{serviceId}`

- **Service:** Processes the subscription request.
  - Checks that the student and service exist.
  - Creates a subscription record.
  - Saves the subscription through the repository layer.

- **Repository:** Saves the subscription to the database.

- **Model:** Subscription entity/model stores the connection between a student and a tutoring service.

- **View:** 
  - `subscribe-form.ftlh` displays the confirmation form.
  - `subscription-success.ftlh` displays a success message after the subscription is created.

**Flow:**  
User clicks subscribe → Controller opens form → User confirms subscription → Controller sends request to service → Service creates subscription → Repository saves it → Success page is shown.

---

### Use Case 3: Write a Review for a Tutoring Service

**User goal:**  
A student wants to leave a review for a tutoring service.

**MVC implementation:**

- **Controller:** Handles the review page and review submission.
  - A GET route displays the review form.
  - A POST route saves the review.

- **Service:** Handles review logic.
  - Validates the review information.
  - Connects the review to the correct tutoring service and student.
  - Sends the review to the repository to be saved.

- **Repository:** Saves the review record in the database.

- **Model:** Review entity/model stores information such as rating, comment, student, and tutoring service.

- **View:** Displays the review form and confirmation message.
  - Example template: `review-form.ftlh`
  - A success or updated service page can show after the review is submitted.

**Flow:**  
User clicks “Write a Review” → Controller opens review form → User submits review → Service validates and creates review → Repository saves it → User sees confirmation.

---

### Use Case 4: Return to the Home Page

**User goal:**  
A student wants to return to the main StudySpartan landing page.

**MVC implementation:**

- **Controller:** Handles the home route.
  - Example route: `/`

- **View:** Displays the landing page.
  - Example template: `index.ftlh`

- **Static Resources:** CSS styles are loaded from the static folder.
  - Example file: `styles.css`

**Flow:**  
User visits `/` → Controller returns the home page → `index.ftlh` displays the StudySpartan landing page.

---

## Summary of MVC Mapping

| Use Case | Controller Role | Service Role | Repository Role | View |
|---|---|---|---|---|
| View tutoring services | Receives `/services/view` request | Gets all services | Reads services from database | `service-list.ftlh` |
| Subscribe to service | Handles subscribe GET and POST routes | Creates subscription | Saves subscription | `subscribe-form.ftlh`, `subscription-success.ftlh` |
| Write review | Handles review form and submission | Validates and creates review | Saves review | `review-form.ftlh` |
| View home page | Handles `/` route | Not always needed | Not always needed | `index.ftlh` |

This mapping shows how each user action is connected to a specific MVC implementation. The controller handles the route, the service contains the logic, the repository communicates with the database, and the Freemarker view displays the result to the user.
