document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('login-form');
    const wrongCredentialMessage = document.getElementById('wrong-credential');

    form.addEventListener('submit', async function(event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const role = document.getElementById('role').value;

        wrongCredentialMessage.textContent = '';

            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password, role })
            });
            const result = await response.json();
            if (response.ok) {
                if (result.message === "Login Successful") {
                    switch (result.role) {
                        case 'STUDENT':
                            window.location.href = '/pages/student.html';
                            break;
                        case 'FACULTY':
                            window.location.href = '/pages/faculty.html';
                            break;
                        case 'ADMINISTRATOR':
                            window.location.href = '/pages/admin.html';
                            break;
                        default:
                            wrongCredentialMessage.textContent = 'Unknown role';
                    }
                } else {
                    wrongCredentialMessage.textContent = result.message || 'Unexpected response message';
                }
            } else {
                wrongCredentialMessage.textContent = result.message || 'An error occurred. Please try again later.';
            }
    });
});
