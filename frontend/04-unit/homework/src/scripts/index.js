async function send(e) {
  e.preventDefault();
  let formData = {
    data: {
      name: document.getElementById("form-name").value,
      email: document.getElementById("form-email").value,
      subject: document.getElementById("form-subject").value,
      message: document.getElementById("form-message").value,
    }
  };
  document.getElementById("form-reset").click();
  fetch(
      'https://validator.courses.7bits.it/homework-4',
      {
        method: 'POST',
        body: JSON.stringify(formData)
      }
    );
}
