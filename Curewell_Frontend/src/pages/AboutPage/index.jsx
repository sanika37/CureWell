const AboutPage = () => {
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
          About Us
        </div>
        <p className="lead">
          Learn more about Curewell Hospital and our commitment to excellence in healthcare.
        </p>
      </div>

      <div className="container">
        {/* Section 1: Our Mission */}
        <section
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            marginBottom: "40px",
          }}
        >
          <div style={{ flex: "1", paddingRight: "20px" }}>
            <h3 style={{ fontWeight: "bold", marginBottom: "10px" }}>Our Mission</h3>
            <p style={{ fontSize: "1.2rem", lineHeight: "1.6" }}>
              At <strong>Curewell Hospital</strong>, our mission is to provide world-class healthcare services with compassion, innovation, and excellence. We are dedicated to improving the health and well-being of our patients by offering state-of-the-art medical care and personalized attention.
            </p>
          </div>
          <div
            style={{
              flex: "1",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <img
              src="./img1.jpg"
              alt="Our Mission"
              style={{
                width: "80%",
                height: "auto",
                borderRadius: "8px",
                boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
                transition: "transform 0.3s ease, box-shadow 0.3s ease",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.style.transform = "scale(1.05)";
                e.currentTarget.style.boxShadow = "0 8px 16px rgba(0, 0, 0, 0.2)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.style.transform = "scale(1)";
                e.currentTarget.style.boxShadow = "0 4px 8px rgba(0, 0, 0, 0.1)";
              }}
            />
          </div>
        </section>

        {/* Section 2: Our Vision */}
        <section
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            marginBottom: "40px",
          }}
        >
          <div
            style={{
              flex: "1",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <img
              src="./img2.jpg"
              alt="Our Vision"
              style={{
                width: "80%",
                height: "auto",
                borderRadius: "8px",
                boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
                transition: "transform 0.3s ease, box-shadow 0.3s ease",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.style.transform = "scale(1.05)";
                e.currentTarget.style.boxShadow = "0 8px 16px rgba(0, 0, 0, 0.2)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.style.transform = "scale(1)";
                e.currentTarget.style.boxShadow = "0 4px 8px rgba(0, 0, 0, 0.1)";
              }}
            />
          </div>
          <div style={{ flex: "1", paddingLeft: "20px" }}>
            <h3 style={{ fontWeight: "bold", marginBottom: "10px" }}>Our Vision</h3>
            <p style={{ fontSize: "1.2rem", lineHeight: "1.6" }}>
              Our vision is to be a global leader in healthcare, setting the standard for excellence in patient care, medical research, and education. We strive to create a healthier world by advancing medical science and fostering a culture of innovation and collaboration.
            </p>
          </div>
        </section>

        {/* Section 3: Our Values */}
        <section
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            marginBottom: "40px",
          }}
        >
          <div style={{ flex: "1", paddingRight: "20px" }}>
            <h3 style={{ fontWeight: "bold", marginBottom: "10px" }}>Our Values</h3>
            <ul style={{ fontSize: "1.2rem", lineHeight: "1.8" }}>
              <li>
                <strong>Compassion:</strong> We treat every patient with empathy, respect, and dignity.
              </li>
              <li>
                <strong>Excellence:</strong> We are committed to delivering the highest quality of care and services.
              </li>
              <li>
                <strong>Innovation:</strong> We embrace cutting-edge technology and research to improve outcomes.
              </li>
              <li>
                <strong>Integrity:</strong> We uphold the highest ethical standards in everything we do.
              </li>
              <li>
                <strong>Collaboration:</strong> We work together as a team to achieve the best results for our patients.
              </li>
            </ul>
          </div>
          <div
            style={{
              flex: "1",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <img
              src="./img3.jpg"
              alt="Our Values"
              style={{
                width: "80%",
                height: "auto",
                borderRadius: "8px",
                boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
                transition: "transform 0.3s ease, box-shadow 0.3s ease",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.style.transform = "scale(1.05)";
                e.currentTarget.style.boxShadow = "0 8px 16px rgba(0, 0, 0, 0.2)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.style.transform = "scale(1)";
                e.currentTarget.style.boxShadow = "0 4px 8px rgba(0, 0, 0, 0.1)";
              }}
            />
          </div>
        </section>
      </div>
    </>
  );
};

export default AboutPage;