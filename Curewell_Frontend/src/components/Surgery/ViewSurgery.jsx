import { useState, useEffect, useCallback } from "react";
import { useNavigate } from "react-router-dom";
import { Table, Button, Container, Alert } from "react-bootstrap";
import axios from "axios";

const ViewSurgery = () => {
  const [surgeries, setSurgeries] = useState([]);
  const [error, setError] = useState(null);
  const [isToday, setIsToday] = useState(false);
  const token = localStorage.getItem("token");
  const navigate = useNavigate();

  const fetchSurgeries = useCallback(async (url) => {
    try {
      const response = await axios.get(url, {
        headers: { Authorization: `Bearer ${token}` },
      });
      setSurgeries(response.data);
    } catch (err) {
      setError("Failed to fetch surgeries.");
    }
  }, [token]);

  useEffect(() => {
    const url = isToday ? "http://localhost:8080//api/surgeries/today" : "http://localhost:8080/api/surgeries";
    if (token) {
      fetchSurgeries(url);
    } else {
      setError("Unauthorized! Please log in.");
    }
  }, [token, isToday, fetchSurgeries]);

  return (
    <Container className="mt-4">
      <h2 className="text-center mb-4">Surgery List</h2>

      {error && <Alert variant="danger">{error}</Alert>}

      <div className="d-flex justify-content-center mb-3">
        <Button
          variant="info"
          className="me-2"
          style={{ fontSize: "1.1rem" }}
          onClick={() => setIsToday(false)}
        >
          All Surgeries
        </Button>

        <Button
          variant="success"
          className="me-2"
          style={{ fontSize: "1.1rem" }}
          onClick={() => setIsToday(true)}
        >
          Today's Surgeries
        </Button>

        <Button
          variant="success"
          style={{ fontSize: "1.1rem" }}
          onClick={() => navigate("/addsurgery")}
        >
          Add Surgery
        </Button>
      </div>

      <Table striped bordered hover style={{ fontSize: "1.1rem" }}>
        <thead>
          <tr>
            <th className="text-center">ID</th>
            <th className="text-center">Name</th>
            <th className="text-center">Specialization</th>
            <th className="text-center">Start Time</th>
            <th className="text-center">End Time</th>
            <th className="text-center">Date</th>
            <th className="text-center">Doctor ID</th>
            <th className="text-center">Actions</th>
          </tr>
        </thead>
        <tbody>
          {surgeries.map((surgery) => (
            <tr key={surgery.surgId}>
              <td className="text-center">{surgery.surgId}</td>
              <td className="text-center">{surgery.surgeryName}</td>
              <td className="text-center">{surgery.specCode}</td>
              <td className="text-center">{surgery.startTime}</td>
              <td className="text-center">{surgery.endTime}</td>
              <td className="text-center">{surgery.surgeryDate}</td>
              <td className="text-center">{surgery.doctor?.doctorId}</td>
              <td className="text-center">
                <Button
                  variant="warning"
                  style={{ fontSize: "1.1rem" }}
                  onClick={() => navigate(`/updatesurgery/${surgery.surgId}`)}
                >
                  Edit
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default ViewSurgery;