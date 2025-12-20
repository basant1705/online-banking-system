// Real-time validation logic for forms

// Validate email
function validateEmail(inputId, errorId) {
    const emailField = document.getElementById(inputId);
    const errorField = document.getElementById(errorId);
    emailField.addEventListener('input', () => {
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(emailField.value)) {
            errorField.textContent = 'Invalid email address.';
        } else {
            errorField.textContent = '';
        }
    });
}

// Validate password strength
function validatePasswordStrength(inputId, strengthId, errorId) {
    const passwordField = document.getElementById(inputId);
    const strengthField = document.getElementById(strengthId);
    const errorField = document.getElementById(errorId);
    passwordField.addEventListener('input', () => {
        const value = passwordField.value;
        let strength = 'Weak';
        let color = 'red';

        if (value.length >= 8 && /[A-Z]/.test(value) && /[0-9]/.test(value)) {
            strength = 'Strong';
            color = 'green';
        } else if (value.length >= 6) {
            strength = 'Moderate';
            color = 'orange';
        }

        strengthField.textContent = `Strength: ${strength}`;
        strengthField.style.color = color;

        if (value.length < 6) {
            errorField.textContent = 'Password too short.';
        } else {
            errorField.textContent = '';
        }
    });
}

// Validate matching passwords
function validateConfirmPassword(passwordId, confirmId, errorId) {
    const passwordField = document.getElementById(passwordId);
    const confirmField = document.getElementById(confirmId);
    const errorField = document.getElementById(errorId);

    confirmField.addEventListener('input', () => {
        if (passwordField.value !== confirmField.value) {
            errorField.textContent = 'Passwords do not match.';
        } else {
            errorField.textContent = '';
        }
    });
}

// Call validations on form
validateEmail('email', 'emailError');
validatePasswordStrength('password', 'passwordStrength', 'passwordError');
validateConfirmPassword('password', 'confirmPassword', 'confirmPasswordError');
