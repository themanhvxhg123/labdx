import React from "react";
import { Row, Col, Table, Card } from "react-bootstrap";
import { FiCalendar, FiUsers, FiFolder, FiUser } from "react-icons/fi";
import "../App.css"; // dùng chung App.css

const Dashboard = ({ setCurrentPage, onOpenSemester, showSemesterCard }) => {
  // Danh sách thẻ trên cùng (Dashboard chính)
  const cards = [
    {
      title: "Kỳ học",
      color: "#4dabf7",
      icon: <FiCalendar size={36} />,
      action: onOpenSemester,
      show: showSemesterCard,
    },
    {
      title: "Nhóm",
      color: "#63e6be",
      icon: <FiUsers size={36} />,
      action: () => setCurrentPage("Quản lý Ban"),
    },
    {
      title: "Project",
      color: "#ffd43b",
      icon: <FiFolder size={36} />,
      action: () => setCurrentPage("Quản lý Dự án"),
    },
    {
      title: "Thành viên",
      color: "#b197fc",
      icon: <FiUser size={36} />,
      action: () => setCurrentPage("Quản lý Thành viên"),
    },
  ];

  // Dữ liệu mẫu cho Dự án & Nhóm trong kỳ học
  const semesterData = {
    name: "Học kỳ 1 - Năm 2025",
    projects: [
      { id: 1, name: "Hệ thống quản lý sinh viên", status: "Hoàn thành" },
      { id: 2, name: "Website điểm danh AI", status: "Đang thực hiện" },
    ],
    groups: [
      { id: "G1", name: "Nhóm 1 - Backend" },
      { id: "G2", name: "Nhóm 2 - Frontend" },
    ],
  };

  return (
    <div className="dashboard p-4">
      <h4 className="fw-bold mb-4">Dashboard</h4>

      {/* Vùng thẻ chính */}
      <Row className="g-4">
        {cards
          .filter((card) => card.show !== false)
          .map((card, index) => (
            <Col key={index} xs={12} sm={6} md={3}>
              <div
                className="dashboard-card"
                style={{ backgroundColor: card.color }}
                onClick={card.action}
              >
                <div className="icon-wrapper">{card.icon}</div>
                <h6 className="card-title">{card.title}</h6>
                <div className="card-shadow" />
              </div>
            </Col>
          ))}
      </Row>

      {/* Nếu đã chọn 1 kỳ học thì hiển thị phần Dự án + Nhóm */}
      {!showSemesterCard && (
        <div className="mt-5">
          <h5 className="fw-bold mb-3">
            {semesterData.name} – Thông tin chi tiết
          </h5>

          {/* Danh sách Dự án */}
          <Card className="mb-4 shadow-sm">
            <Card.Body>
              <h6 className="fw-bold mb-3">Dự án trong kỳ học</h6>
              <Table striped bordered hover>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Tên dự án</th>
                    <th>Trạng thái</th>
                  </tr>
                </thead>
                <tbody>
                  {semesterData.projects.map((proj, index) => (
                    <tr key={proj.id}>
                      <td>{index + 1}</td>
                      <td>{proj.name}</td>
                      <td>{proj.status}</td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            </Card.Body>
          </Card>

          {/* Danh sách Nhóm */}
          <Card className="shadow-sm">
            <Card.Body>
              <h6 className="fw-bold mb-3">Nhóm trong kỳ học</h6>
              <ul className="list-group">
                {semesterData.groups.map((group) => (
                  <li key={group.id} className="list-group-item">
                    {group.name}
                  </li>
                ))}
              </ul>
            </Card.Body>
          </Card>
        </div>
      )}
    </div>
  );
};

export default Dashboard;
