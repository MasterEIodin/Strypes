# Strypes

This is my solution tothe Strypes' task, with a slight alteration of the original requirement:
The tests do not cover a single section, but two instead - redirection to "Careers" and "Podcast", along with tests for the Subscribe functionality.

Also, a test for sending a job application is written, but never executed completely (to avoid spamming the system).
Negative tests were added as well, which found a couple of bugs in this feature.

I have used Gradle for project building, TestNG instead of JUnit for the tests, and ChromeDriver as the browser instance.

The framework allows for Firefox to be used as well, although the driver is not included in the project.
