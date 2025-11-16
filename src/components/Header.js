import React from "react";
import { Navbar, Container, Button } from "react-bootstrap";
import { FaUserCircle } from "react-icons/fa";

const Header = ({ onLogout }) => {
  return (
    <Navbar className="header-gradient" variant="dark" expand="lg" style={{ background: "#2b7bff" }}>
      <Container fluid>
        <Navbar.Brand className="fw-bold text-white">Lab Management System</Navbar.Brand>

        <div className="header-right ms-auto text-white d-flex align-items-center gap-2">
          <span className="d-none d-md-inline">Hi, <strong>Lab Manager</strong></span>
          <FaUserCircle size={20} />
          <Button variant="light" size="sm" onClick={onLogout}>Logout</Button>
        </div>
      </Container>
    </Navbar>
  );
};

export default Header;
