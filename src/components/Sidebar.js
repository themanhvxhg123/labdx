import React from "react";
import { ListGroup } from "react-bootstrap";

const Sidebar = ({ currentPage, setCurrentPage }) => {
  const menu = [
    "Kỳ học",
    "Dashboard",
    "Quản lý Dự án",
    "Quản lý Ban",
    "Quản lý Thành viên",
  ];

  return (
    <div className="bg-white border-end p-3" style={{ width: "230px" }}>
      <h6 className="fw-bold text-primary text-center mb-3">Bảng điều khiển</h6>
      <ListGroup variant="flush">
        {menu.map((item) => (
          <ListGroup.Item
            key={item}
            action
            active={currentPage === item}
            onClick={() => setCurrentPage(item)}
            style={{ borderRadius: 8, marginBottom: 8 }}
          >
            {item}
          </ListGroup.Item>
        ))}
      </ListGroup>
      <div className="mt-auto text-muted text-center small">© 2025 Lab</div>
    </div>
  );
};

export default Sidebar;
