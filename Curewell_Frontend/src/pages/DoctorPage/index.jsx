import React from "react";
import { Outlet } from "react-router-dom";
import DoctorsSubNavbar from "../../components/Doctors/SubNavbar";

const DoctorsPage = () => {
  return (
    <div>
      <DoctorsSubNavbar />
      <Outlet />
    </div>
  );
};

export default DoctorsPage;