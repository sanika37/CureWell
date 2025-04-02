const ContactPage = () => {
  return (
    <>
      <div
        className="jumbotron text-center"
        style={{
          fontSize: "1.5rem",
          marginTop: "2rem",
          marginBottom: "2rem",
        }}
      >
        <div
          className="display-4"
          style={{
            fontSize: "2.5rem",
            fontWeight: "bold",
          }}
        >
          Contact Us
        </div>
        <p className="lead">
          We're here to assist you with all your healthcare needs. Reach out to us anytime!
        </p>
      </div>
      <div
        className="container"
        style={{
          fontSize: "1.2rem",
          lineHeight: "1.8",
          marginBottom: "2rem",
        }}
      >
        {/* Section: How to Reach Us */}
        <section style={{ marginBottom: "2rem" }}>
          <h2 style={{ fontWeight: "bold" }}>How to Reach Us</h2>
          <p>
            At Curewell Hospital, we prioritize your health and well-being. Whether you have questions about our services, need to book an appointment, or require assistance, our team is here to help.
          </p>
          <p>
            <strong>Email:</strong> contact@curewellhospital.com <br />
            <strong>Phone:</strong> +61 (02) 1234 5678 <br />
            <strong>Address:</strong> 456 Health Avenue, Sydney, NSW 2000, Australia
          </p>
          <p>
            <strong>Support Hours:</strong> Monday to Saturday, 8:00 AM to 8:00 PM (AEST). Emergency services are available 24/7.
          </p>
        </section>

        {/* Section: Emergency Contact */}
        <section style={{ marginBottom: "2rem" }}>
          <h2 style={{ fontWeight: "bold" }}>Emergency Contact</h2>
          <p>
            For medical emergencies, please call our 24/7 emergency hotline:
          </p>
          <p>
            <strong>Emergency Hotline:</strong> +61 (02) 9876 5432
          </p>
          <p>
            Our emergency department is always open to provide immediate care.
          </p>
        </section>

        {/* Section: Stay Connected */}
        <section style={{ marginBottom: "2rem" }}>
          <h2 style={{ fontWeight: "bold" }}>Stay Connected</h2>
          <p>
            Subscribe to our newsletter for the latest updates on healthcare services, health tips, and more.
          </p>
          <form>
            <input
              type="email"
              placeholder="Enter your email"
              style={{
                padding: "0.5rem",
                fontSize: "1rem",
                width: "100%",
                maxWidth: "400px",
                marginBottom: "1rem",
              }}
            />
            <button
              type="submit"
              style={{
                padding: "0.5rem 1rem",
                fontSize: "1rem",
                backgroundColor: "#007bff",
                color: "#fff",
                border: "none",
                cursor: "pointer",
              }}
            >
              Subscribe
            </button>
          </form>
          <p>Follow us on social media to stay updated:</p>
          <ul>
            <li>
              <a
                href="https://facebook.com/curewellhospital"
                target="_blank"
                rel="noopener noreferrer"
              >
                Facebook
              </a>
            </li>
            <li>
              <a
                href="https://twitter.com/curewellhospital"
                target="_blank"
                rel="noopener noreferrer"
              >
                Twitter
              </a>
            </li>
            <li>
              <a
                href="https://instagram.com/curewellhospital"
                target="_blank"
                rel="noopener noreferrer"
              >
                Instagram
              </a>
            </li>
          </ul>
        </section>
      </div>
    </>
  );
};

export default ContactPage;