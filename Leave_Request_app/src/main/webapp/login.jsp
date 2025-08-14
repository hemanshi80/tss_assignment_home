<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login Portal Preview</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    
    <!-- Font Awesome for Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet" />

    <!-- Custom Styles -->
<style>
/* Body & Background */
body {
    height: 100vh;
    margin: 0;
    font-family: 'Poppins', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(135deg, #e0f7fa, #fff9c4); /* Soft pastel gradient */
}

/* Login Form Container */
.login-container {
    width: 100%;
    max-width: 420px;
    padding: 40px 30px;
    background: rgba(255, 255, 255, 0.95);
    border-radius: 20px;
    box-shadow: 0 20px 40px rgba(0, 0, 0, 0.08);
    backdrop-filter: blur(8px);
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.login-container:hover {
    transform: translateY(-4px);
    box-shadow: 0 25px 50px rgba(0, 0, 0, 0.12);
}

/* Header */
.login-header {
    text-align: center;
    margin-bottom: 30px;
}
.login-header h2 {
    font-weight: 700;
    font-size: 2rem;
    color: #006064; /* Deep teal */
    letter-spacing: 1px;
}

/* Floating Labels */
.form-floating input,
.form-floating select {
    border-radius: 12px;
    background: #f0f0f0;
    border: 1px solid #b0bec5;
    height: 50px;
    padding: 1rem 0.75rem;
    font-size: 1rem;
    transition: all 0.3s ease;
}

.form-floating input:focus,
.form-floating select:focus {
    background: #ffffff;
    border-color: #00796b; /* accent teal */
    box-shadow: 0 0 8px rgba(0, 121, 107, 0.3);
}

/* Password Toggle */
.password-wrapper {
    position: relative;
}
#password-toggle {
    position: absolute;
    right: 15px;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    color: #00796b;
}
#password-toggle:hover {
    color: #004d40;
}

/* Buttons */
.btn-login {
    background: linear-gradient(90deg, #26c6da, #00acc1); /* soft teal gradient */
    color: #fff;
    font-weight: 600;
    border-radius: 12px;
    padding: 12px;
    font-size: 1rem;
    transition: all 0.3s ease;
}
.btn-login:hover {
    background: linear-gradient(90deg, #00acc1, #26c6da);
    transform: translateY(-2px);
    box-shadow: 0 8px 20px rgba(38, 198, 218, 0.4);
}

/* Footer / Links */
.footer-link {
    text-align: center;
    margin-top: 20px;
    font-size: 0.9rem;
    color: #455a64;
}
.footer-link a {
    color: #00796b;
    text-decoration: none;
}
.footer-link a:hover {
    text-decoration: underline;
}

/* Checkbox & Remember Me */
.form-check-label {
    color: #455a64;
    font-size: 0.9rem;
}

/* Responsive */
@media(max-width: 500px) {
    .login-container {
        padding: 30px 20px;
    }
}
</style>




</head>
<body>
<div class="login-container">
    <div class="login-header">
        <h2><i class="fas fa-sign-in-alt me-2"></i>Secure Login</h2>
    </div>

    <form method="post" action="LoginController" class="needs-validation" novalidate>

        <div class="form-floating mb-3">
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required minlength="3">
            <label for="username">Username</label>
        </div>

        <div class="form-floating mb-3 password-wrapper">
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required minlength="5">
            <label for="password">Password</label>
            <span id="password-toggle"><i class="fas fa-eye"></i></span>
        </div>

        <div class="form-floating mb-3">
            <select id="role" name="role" class="form-select" required>
                <option value="" disabled selected hidden>Select Role</option>
                <option value="employee">Employee</option>
                <option value="admin">Admin</option>
            </select>
            <label for="role">Login as</label>
        </div>

        <div class="d-flex justify-content-between align-items-center mb-4">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="rememberMe" />
                <label class="form-check-label" for="rememberMe">Remember Me</label>
            </div>
            <div class="footer-link">
                <a href="#">Forgot Password?</a>
            </div>
        </div>

        <button type="submit" class="btn btn-login w-100">Login</button>

        <div class="footer-link">
            New Employee? <a href="register.jsp">Create an account</a>
        </div>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (function () {
        'use strict';

        // --- Bootstrap 5 Form Validation ---
        var forms = document.querySelectorAll('.needs-validation');
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });

        const passwordInput = document.getElementById('password');
        const passwordToggle = document.getElementById('password-toggle');
        
        if (passwordToggle) {
            const toggleIcon = passwordToggle.querySelector('i');
            passwordToggle.addEventListener('click', function() {
                const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
                passwordInput.setAttribute('type', type);
                toggleIcon.classList.toggle('fa-eye');
                toggleIcon.classList.toggle('fa-eye-slash');
            });
        }
    })();
</script>

</body>
</html>
