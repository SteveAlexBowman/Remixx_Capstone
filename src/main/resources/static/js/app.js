// Wait until the DOM is fully loaded before executing the script
document.addEventListener("DOMContentLoaded", function() {

  // Select the contact form by its ID
  const contactForm = document.getElementById("contactForm");

  // Check if the form exists on the page (to avoid errors on pages without this form)
  if (contactForm) {

    // Add an event listener for the 'submit' event on the form
    contactForm.addEventListener("submit", function(event) {

      // Retrieve the values entered by the "name" and "email" fields
      const name = document.getElementById("name").value;
      const email = document.getElementById("email").value;

      // Simple validation: Check if either field is empty
      if (name.trim() === "" || email.trim() === "") {
        alert("All fields are required!"); // Notify the user about the validation failure

        // Prevent the form from being submitted if validation fails
        event.preventDefault();
      }
    });
  }
});

