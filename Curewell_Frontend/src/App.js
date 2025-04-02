import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import HomePage from "./pages/HomePage/index.jsx";
import Navbar from "./components/Navbar/index.jsx";
import AboutPage from "./pages/AboutPage/index.jsx";
import ContactPage from "./pages/ContactPage/index.jsx";
import SurgeryPage from "./pages/SurgeryPage/index.jsx";
import DoctorPage from "./pages/DoctorPage/index.jsx";
import SpecializationPage from "./pages/SpecializationPage/index.jsx";
import LoginPage from "./pages/LoginPage/index.jsx";
import RegisterPage from "./pages/RegisterPage/index.jsx";
import ProtectedRoute from './routes/ProtectedRoute'; // Assuming this is in the same directory

import AddDoctor from './components/Doctors/AddDoctor.jsx';
import ViewDoctors from './components/Doctors/ViewDoctors.jsx';
import UpdateDoctor from './components/Doctors/UpdateDoctor.jsx';
import AddSurgery from './components/Surgery/AddSurgery.jsx';
import ViewSurgery from './components/Surgery/ViewSurgery.jsx';
import UpdateSurgery from './components/Surgery/UpdateSurgery.jsx';
import AddSpecialization from './components/Specialization/AddSpecialization.jsx';
import ViewSpecialization from './components/Specialization/ViewSpecialization.jsx';
import UpdateSpecialization from './components/Specialization/UpdateSpecialization.jsx';

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />

        <Route path="/surgery/*" element={<ProtectedRoute Component={SurgeryPage} />} >
          <Route index element={<ViewSurgery />} /> 
          <Route path="view" element={<ViewSurgery />} /> 
          <Route path="add" element={<AddSurgery />} /> 
          <Route path="update" element={<UpdateSurgery />} /> 
        </Route>

        <Route path="/doctor/*" element={<ProtectedRoute Component={DoctorPage} />} >
          <Route index element={<ViewDoctors />} />
          <Route path="view" element={<ViewDoctors />} /> 
          <Route path="update" element={<UpdateDoctor />} /> 
          <Route path="add" element={<AddDoctor />} />
        </Route>

        <Route path="/specialization/*" element={<ProtectedRoute Component={SpecializationPage} />} >
          <Route index element={<ViewSpecialization />} />
          <Route path="view" element={<ViewSpecialization />} /> 
          <Route path="update" element={<UpdateSpecialization />} />
          <Route path="add" element={<AddSpecialization />} />
        </Route>

        <Route path="*" element={<Navigate to="/" />} /> {/* Catch-all route */}
      </Routes>
    </Router>
  );
}

export default App;