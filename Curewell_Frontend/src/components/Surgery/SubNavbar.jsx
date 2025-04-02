import React from "react";
import { Link } from "react-router-dom";

const SurgerySubNavbar = () => {
  return (
    <nav style={{ textAlign: "center", marginTop: "30px" }}>
      <ul style={{
        display: "flex",
        justifyContent: "center",
        padding: 0,
        listStyle: "none",
        gap: "40px" /* Adds spacing between buttons */
      }}>
        <li>
          <Link
            to="/surgery/view"
            style={{
              backgroundColor: "#007BFF",
              border: "none",
              color: "white",
              padding: "20px 50px", /* Enlarged padding for bigger buttons */
              textDecoration: "none",
              fontSize: "20px", /* Increased text size */
              borderRadius: "8px", /* Rounded corners */
              transition: "background-color 0.3s, transform 0.3s",
            }}
            onMouseEnter={(e) => {
              e.target.style.backgroundColor = "#0056b3";
              e.target.style.transform = "scale(1.1)"; /* Slightly larger hover effect */
            }}
            onMouseLeave={(e) => {
              e.target.style.backgroundColor = "#007BFF";
              e.target.style.transform = "scale(1)";
            }}
          >
            View Surgery
          </Link>
        </li>
        <li>
          <Link
            to="/surgery/add"
            style={{
              backgroundColor: "#007BFF",
              border: "none",
              color: "white",
              padding: "20px 50px",
              textDecoration: "none",
              fontSize: "20px",
              borderRadius: "8px",
              transition: "background-color 0.3s, transform 0.3s",
            }}
            onMouseEnter={(e) => {
              e.target.style.backgroundColor = "#0056b3";
              e.target.style.transform = "scale(1.1)";
            }}
            onMouseLeave={(e) => {
              e.target.style.backgroundColor = "#007BFF";
              e.target.style.transform = "scale(1)";
            }}
          >
            Add Surgery
          </Link>
        </li>
        <li>
          <Link
            to="/surgery/update"
            style={{
              backgroundColor: "#007BFF",
              border: "none",
              color: "white",
              padding: "20px 50px",
              textDecoration: "none",
              fontSize: "20px",
              borderRadius: "8px",
              transition: "background-color 0.3s, transform 0.3s",
            }}
            onMouseEnter={(e) => {
              e.target.style.backgroundColor = "#0056b3";
              e.target.style.transform = "scale(1.1)";
            }}
            onMouseLeave={(e) => {
              e.target.style.backgroundColor = "#007BFF";
              e.target.style.transform = "scale(1)";
            }}
          >
            Update Surgery
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default SurgerySubNavbar;