const Header = () => {
  return (
    <div
      className="jumbotron text-center"
      style={{
        marginTop: '20px', // Add space between the navbar and header
      }}
    >
      {/* Original Content */}
      <h1 className="display-4">Welcome to NeoCure!</h1>
      <p className="lead">
        Revolutionizing healthcare management for Curewell Hospital in Sydney.
      </p>
      <hr className="my-4" />
      <p
        style={{
          fontSize: '1.25rem', // Increase font size for the second paragraph
        }}
      >
        NeoCure empowers healthcare professionals with innovative tools for
        seamless hospital management. From patient records to appointments,
        staff coordination, and beyond—experience the future of healthcare,
        right here. Join us in advancing efficiency and enhancing patient care!
      </p>
      <a
        className="btn btn-lg"
        href="/dashboard"
        role="button"
        style={{
          backgroundColor: '#28a745', // Green button for a healthcare theme
          color: 'white', // White text for readability
          border: 'none', // Remove border for a clean look
          marginTop: '20px', // Add space between paragraph and button
          transition: '0.3s', // Smooth transition for hover effect
        }}
        onMouseEnter={(e) => (e.target.style.boxShadow = '0 0 15px #28a745')} // Glow effect on hover
        onMouseLeave={(e) => (e.target.style.boxShadow = 'none')} // Remove glow effect on hover out
      >
        Explore NeoCure
      </a>

      {/* New Content in a Main Box */}
      <div
        style={{
          backgroundColor: '#bab5b5', // Slightly darker background for contrast
          borderRadius: '10px',
          padding: '20px',
          marginTop: '30px',
          marginLeft: '20px',
          marginRight: '20px', // Keep the box border away from the page border
          boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)', // Add a subtle shadow for emphasis
        }}
      >
        {/* Title and Description */}
        <h2 className="lead" style={{ marginBottom: '20px' }}>
          IMPORTANCE OF HEALTH INSURANCE
        </h2>
        <h3 style={{ marginBottom: '10px' }}>Why do I need a Health Insurance Policy?</h3>
        <hr className="my-4" />
        <p
          style={{
            fontSize: '1.25rem',
            marginBottom: '30px', // Added extra spacing between paragraph and sub-boxes
          }}
        >
          The rising medical costs and an ever-increasing number of diseases
          make Health Insurance a necessity. While doing your financial
          planning, you should always add a Health Insurance plan to your list.
          The best health insurance policy is the one that meets your needs.
          Star Health expert advisors and our array of unique plans ensure you
          get the best health plan.
        </p>

        {/* Smaller Boxes Inside Main Box */}
        <div
          style={{
            display: 'flex',
            justifyContent: 'space-around',
            alignItems: 'flex-start',
            gap: '20px', // Add spacing between the boxes
          }}
        >
          <div
            style={{
              backgroundColor: '#cccccc', // Lighter gray for smaller boxes
              borderRadius: '10px',
              padding: '20px',
              width: '30%',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)', // Subtle shadow
              fontSize: '1.25rem', // Increased font size for content
            }}
          >
            <strong>Annual Health Check-up:</strong>
            <p style={{ marginTop: '10px' }}>
              Having a periodic health check-up helps you prevent various health
              problems. Besides providing cover for incurred medical expenses,
              Health Insurance Policies also facilitate annual health check-ups
              that keep your health on track.
            </p>
          </div>
          <div
            style={{
              backgroundColor: '#cccccc',
              borderRadius: '10px',
              padding: '20px',
              width: '30%',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              fontSize: '1.25rem',
            }}
          >
            <strong>COVID-19 Cover:</strong>
            <p style={{ marginTop: '10px' }}>
              Pandemics like COVID-19 remind us of the importance of health and
              the necessity of Health Insurance. So, to be financially stable
              even during uncertainties, it is essential to buy health
              insurance.
            </p>
          </div>
          <div
            style={{
              backgroundColor: '#cccccc',
              borderRadius: '10px',
              padding: '20px',
              width: '30%',
              boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
              fontSize: '1.25rem',
            }}
          >
            <strong>Tax Benefits:</strong>
            <p style={{ marginTop: '10px' }}>
              Health Insurance is an essential investment for which you can
              avail the tax exemption. Under Section 80D of the Income Tax Act,
              1961, a taxpayer can avail tax exemptions on premiums paid toward
              health policies.
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;