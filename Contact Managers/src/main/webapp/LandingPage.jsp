<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Contact Manager</title>
  <link rel="stylesheet" href="LandingPage.css" />
</head>
<body>
  <nav>
    <div class="logo">
      <img src="https://cdn-icons-png.flaticon.com/512/561/561127.png" alt="Logo" />
    </div>
    <div class="nav-links">
      <a href="LoginPage.jsp">Login</a>
      <a href="Register.jsp">Register</a>
    </div>
    <div class="menu-toggle" onclick="toggleDrawer()">☰</div>
  </nav>

  <div class="drawer" id="drawer">
    <a href="LoginPage.jsp" onclick="closeDrawer()">Login</a>
    <a href="Register.jsp" onclick="closeDrawer()">Register</a>
  </div>

  <main>
    <section id="hero" class="container">
      <h1>Contact Manager</h1>
      <p>Organize your contacts effortlessly. Securely manage, search, and update your contacts anytime, anywhere.</p>
      <div class="btn-group">
        <a href="Register.jsp" class="btn">Get Started</a>
        <a href="LoginPage.jsp" class="btn">Login</a>
      </div>
    </section>

    <section id="features" class="container">
      <img src="https://images.unsplash.com/photo-1556740749-887f6717d7e4?auto=format&fit=crop&w=800&q=80" alt="Features" />
      <div class="feature-text">
        <h2>Why Choose Contact Manager?</h2>
        <ul>
          <li>Easy and intuitive interface</li>
          <li>Secure cloud backup for your contacts</li>
          <li>Powerful search and filter features</li>
          <li>Seamless import/export options</li>
          <li>Access contacts across all your devices</li>
        </ul>
      </div>
    </section>

    <section id="cta" class="container">
      <h2>Ready to take control of your contacts?</h2>
      <a href="Register.jsp">Create Your Account Now</a>
    </section>

    <section id="faq" class="container">
      <h2>Frequently Asked Questions</h2>
      <div class="faq-item" onclick="toggleFAQ(this)">
        <h3>Is my data secure? <span>+</span></h3>
        <div class="faq-answer">
          <p>Yes, we use top-level encryption to secure your contact data at all times.</p>
        </div>
      </div>
      <div class="faq-item" onclick="toggleFAQ(this)">
        <h3>Can I export my contacts? <span>+</span></h3>
        <div class="faq-answer">
          <p>Absolutely! You can export your contacts in CSV or VCF formats easily from the dashboard.</p>
        </div>
      </div>
      <div class="faq-item" onclick="toggleFAQ(this)">
        <h3>Is it mobile-friendly? <span>+</span></h3>
        <div class="faq-answer">
          <p>Yes, our platform is optimized for all devices including smartphones and tablets.</p>
        </div>
      </div>
    </section>
  </main>

  <footer>
    &copy; 2025 Contact Manager. All rights reserved.
  </footer>

  <script>
    const drawer = document.getElementById("drawer");

    function toggleDrawer() {
      drawer.classList.toggle("open");
    }

    function closeDrawer() {
      drawer.classList.remove("open");
    }

    document.addEventListener("click", function (e) {
      if (!drawer.contains(e.target) && !e.target.closest('.menu-toggle')) {
        drawer.classList.remove("open");
      }
    });

    function toggleFAQ(element) {
      element.classList.toggle("open");
    }
  </script>
</body>
</html>
