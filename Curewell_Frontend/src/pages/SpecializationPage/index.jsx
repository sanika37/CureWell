import React from "react";
import { Outlet } from "react-router-dom";
import SpecializationSubNavbar from "../../components/Specialization/SubNavbar";

const SpecializationPage = () => {
  return (
    <div>
      <SpecializationSubNavbar />
      <Outlet />
    </div>
  );
};

export default SpecializationPage;