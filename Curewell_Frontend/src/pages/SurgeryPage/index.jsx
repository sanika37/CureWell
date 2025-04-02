import React from "react";
import { Outlet } from "react-router-dom";
import SurgerySubNavbar from "../../components/Surgery/SubNavbar";

const SurgeryPage = () => {
  return (
    <div>
      <SurgerySubNavbar />
      <Outlet />
    </div>
  );
};

export default SurgeryPage;