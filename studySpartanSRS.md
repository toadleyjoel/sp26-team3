
# Requirements – Starter Template

**Project Name:** StudySpartan
**Team:** Huda Abukhass-Students & Joel Pickett-Tutors
**Course:** CSC 340
**Version:** 1.0
**Date:** 2026-02-13

---

## 1. Overview
**Vision.** StudySpartan is a web-based tutoring platform that connects students with tutors by allowing tutors to host study sessions and students to book them, improving accessibility to academic support and streamlining session management.

**Glossary** Terms used in the project
Session: A scheduled tutoring meeting created by a tutor.
Booking: A student reserving a seat in a tutoring session.
Profile: A user’s personal information including subjects, bio, and availability.
Feedback: A rating or review submitted by a student after a session.

**Primary Users / Roles.**
* Student — Books tutoring sessions, manages profile, and leaves feedback.
* Tutor — Hosts tutoring sessions, manages subjects and availability, and tracks bookings.


**Scope (this semester).**
<User registration and login>
<Student and tutor profile management>
<Tutors create, edit, and delete sessions>
<Students browse and book sessions>
<Students leave feedback for tutors>
<Admin manages user accounts>


**Out of scope (deferred).**
<Payment processing>
<Real-time video conferencing integration>
<AI tutor matching>
<Mobile application>


> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)

### 2.1 Customer Stories
- **US‑CUST‑001 — Register/create a profile**  
  _Story:_ As a student, I want to create or update my profile (name, email/phone, subject/course preference, other details) so that I receive proper help and communications.  
  _Acceptance:_
  ```gherkin
  Scenario: Register with valid details
    Given I am not registered,
    When I sign up with required fields (name, email/phone, subject),
    Then my customer profile is created and visible in my account and to providers on the platform.
  ```

- **US‑CUST‑002 — Browse professors/tutors**  
  _Story:_ As a student, I want to browse professor profiles (subject/experience and availability) so that I can learn about them before asking for help.  
  _Acceptance:_
  ```gherkin
  Scenario: Sort tutors by subject
    Given multiple tutors exist,
    When I sort by subject and/or availability,
    Then tutors appear sorted accordingly.
  ```
- **US‑CUST‑003 — Request professors/tutors**  
  _Story:_ As a student, I want to request help from professors/students so that I can meet with them for help.  
  _Acceptance:_
  ```gherkin
  Scenario: Request meetings with tutors 
    Given I would like to receive help,
    When I create a request within a tutor's subject and/or availability,
    Then tutors can see those requests.
  ```

- **US‑CUST‑004 — Write a review**
  _Story:_ As a student, I want to rate tutors/professors so that the community benefits from my feedback.
  _Acceptance:_
  ```gherkin
  Scenario: Eligible review by attendance
    Given I attended a meeting/recieved help,
    When I submit a rating and a comment,
    Then the review is recorded and linked to the tutor and it is published or queued per moderation policy.
  ```

- **US‑CUST‑005 — Read reviews**
  _Story:_ As a student, I want to read recent reviews for a tutor/professor so that I can make an informed decision.
  _Acceptance:_
  ```gherkin
  Scenario: List recent reviews
    Given reviews exist for a tutor,
    When I open Reviews,
    Then I see the most recent reviews with rating and comment.
  ```

- **US‑CUST‑006 — Chat**
  _Story:_ As a student, I want to use the chatting features to talk to other users.
  _Acceptance:_
  ```gherkin
  Scenario: Chatting
    Given there is something I need to say/ask,
    When I open Chat,
    Then I see the most recent chats (possibly per channel) and can also communicate.
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — Register/create a profile**  
  _Story:_ As a tutor/professor, I want to create or update my profile (name, email/phone, subject/course preference, other details) so that I can provide proper help and communications.  
  _Acceptance:_
  ```gherkin
  Scenario: Register with valid details
    Given I am not registered,
    When I sign up with required fields (name, email/phone, subject),
    Then my provider profile is created and visible in my account and to customers and other providers on the platform.
  ```

- **US‑PROV‑002 — Host students**  
  _Story:_ As a tutor, I want to browse student profiles and requests based on subject/experience and availability so that I can learn about them before offering to help.  
  _Acceptance:_
  ```gherkin
  Scenario: Sort requests by subject
    Given multiple requests exist,
    When I sort by subject and/or availability,
    Then student requests appear sorted accordingly and I may host a meeting.
  ```

- **US‑PROV‑003 — Write a review**
  _Story:_ As a tutor/professor, I want to rate students so that the community benefits from my feedback.
  _Acceptance:_
  ```gherkin
  Scenario: Eligible review by hosting
    Given I hosted a meeting/provided help,
    When I submit a rating and a comment,
    Then the review is recorded and linked to the student and it is published or queued per moderation policy.
  ```

- **US‑PROV‑004 — Read reviews**
  _Story:_ As a tutor/professor, I want to read recent reviews for a student so that I can make an informed decision.
  _Acceptance:_
  ```gherkin
  Scenario: List recent reviews
    Given reviews exist for a student,
    When I open Reviews,
    Then I see the most recent reviews with rating and comment.
  ```

- **US‑PROV‑005 — Chat**
  _Story:_ As a tutor, I want to use the chatting features to talk to other users.
  _Acceptance:_
  ```gherkin
  Scenario: Chatting
    Given there is something I need to say/ask,
    When I open Chat,
    Then I see the most recent chats (possibly per channel) and can also communicate.
  ```

### 2.3 SysAdmin Stories
- **US‑ADMIN‑001 — Moderate Chat**  
  _Story:_ As a sysadmin, I want to moderate chat so that only appropriate messages remain. 
  _Acceptance:_
  ```gherkin
  Scenario: Chat Moderation
    Given there is an inappropriate chat message,
    When I open Chat,
    Then I can remove those messages and possibly take other measures, if warranted.
  ```

- **US‑ADMIN‑002 — Moderate Profiles**  
  _Story:_ As a sysadmin, I want to moderate profiles so that only appropriate profiles remain. 
  _Acceptance:_
  ```gherkin
  Scenario: Chat Moderation
    Given there is an inappropriate user profile,
    When I open Profiles,
    Then I can remove those profiles and possibly take other measures, if warranted.
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** 
*The system shall load dashboard pages within 2 seconds under normal conditions.
*The system shall support at least 200 concurrent users. 
- **Availability/Reliability:** 
*The system shall maintain 95% uptime during the semester.
*User data shall be saved without loss.
- **Security/Privacy:** 
*Passwords shall be encrypted.
*Only authenticated users may access dashboards.
*Students can only edit their own profiles.
- **Usability:** 
*The system shall be accessible through modern browsers.
*The UI shall be consistent across student and tutor views.

---

## 4. Assumptions, Constraints, and Policies
*The platform is web-based.
*Payment functionality is not included this semester.
*Real-time tutoring (Zoom integration) is not required.
*The system assumes users have internet access.

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
User stories will be tracked as GitHub issues.
Pull requests must reference and close related issues.
Major requirement changes must update this SRS document.
