import React, { useState } from "react";
import { Table, Button, Modal, Form } from "react-bootstrap";

const ProjectManagement = () => {
  const [projects, setProjects] = useState([
    {
      id: 1,
      name: "Phần mềm Quản lý Lab",
      start: "2025-01-15",
      end: "2025-05-30",
      members: "Nguyễn Văn A, Trần Thị B",
    },
    {
      id: 2,
      name: "Ứng dụng Hỗ trợ Sinh viên",
      start: "2025-08-10",
      end: "2025-12-20",
      members: "Lê Minh C, Phạm Thảo D, Hoàng Đức E",
    },
  ]);

  const [showModal, setShowModal] = useState(false);
  const [showMemberModal, setShowMemberModal] = useState(false);
  const [selectedMembers, setSelectedMembers] = useState([]);

  const [newProject, setNewProject] = useState({
    name: "",
    start: "",
    end: "",
    members: "",
  });
  const [editIndex, setEditIndex] = useState(null);

  const handleShowModal = (project = null, index = null) => {
    if (project) {
      setNewProject(project);
      setEditIndex(index);
    } else {
      setNewProject({ name: "", start: "", end: "", members: "" });
      setEditIndex(null);
    }
    setShowModal(true);
  };

  const handleSave = () => {
    if (!newProject.name || !newProject.start || !newProject.end || !newProject.members) {
      alert("Vui lòng điền đầy đủ thông tin!");
      return;
    }
    if (editIndex !== null) {
      const updated = [...projects];
      updated[editIndex] = newProject;
      setProjects(updated);
    } else {
      setProjects([...projects, { ...newProject, id: Date.now() }]);
    }
    setShowModal(false);
  };

  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc muốn xóa dự án này?")) {
      setProjects(projects.filter((p) => p.id !== id));
    }
  };

  // Khi bấm vào số thành viên
  const handleShowMembers = (membersStr) => {
    const membersArr = membersStr.split(",").map((m) => m.trim());
    setSelectedMembers(membersArr);
    setShowMemberModal(true);
  };

  return (
    <div className="p-4 flex-grow-1">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="fw-bold text-primary">Quản lý Dự án</h4>
        <Button variant="primary" onClick={() => handleShowModal()}>
          + Thêm Dự án
        </Button>
      </div>

      <Table striped bordered hover responsive>
        <thead className="table-primary">
          <tr>
            <th>#</th>
            <th>Tên Dự án</th>
            <th>Bắt đầu</th>
            <th>Kết thúc</th>
            <th>Thành viên tham gia</th>
            <th>Hành động</th>
          </tr>
        </thead>
        <tbody>
          {projects.length > 0 ? (
            projects.map((p, index) => {
              const memberList = p.members.split(",").map((m) => m.trim());
              return (
                <tr key={p.id}>
                  <td>{index + 1}</td>
                  <td>{p.name}</td>
                  <td>{p.start}</td>
                  <td>{p.end}</td>
                  <td>
                    <Button
                      variant="link"
                      className="p-0 text-decoration-none"
                      onClick={() => handleShowMembers(p.members)}
                    >
                      {memberList.length}
                    </Button>
                  </td>
                  <td>
                    <Button
                      variant="warning"
                      size="sm"
                      className="me-2"
                      onClick={() => handleShowModal(p, index)}
                    >
                      Sửa
                    </Button>
                    <Button
                      variant="danger"
                      size="sm"
                      onClick={() => handleDelete(p.id)}
                    >
                      Xóa
                    </Button>
                  </td>
                </tr>
              );
            })
          ) : (
            <tr>
              <td colSpan="6" className="text-center">
                Chưa có dự án nào
              </td>
            </tr>
          )}
        </tbody>
      </Table>

      {/* Modal thêm/sửa dự án */}
      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>{editIndex !== null ? "Sửa Dự án" : "Thêm Dự án"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Tên Dự án</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: Ứng dụng Quản lý Sinh viên"
                value={newProject.name}
                onChange={(e) =>
                  setNewProject({ ...newProject, name: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Ngày bắt đầu</Form.Label>
              <Form.Control
                type="date"
                value={newProject.start}
                onChange={(e) =>
                  setNewProject({ ...newProject, start: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Ngày kết thúc</Form.Label>
              <Form.Control
                type="date"
                value={newProject.end}
                onChange={(e) =>
                  setNewProject({ ...newProject, end: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Thành viên tham gia</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: Nguyễn Văn A, Trần Thị B"
                value={newProject.members}
                onChange={(e) =>
                  setNewProject({ ...newProject, members: e.target.value })
                }
              />
              <Form.Text className="text-muted">
                Nhập tên các thành viên, cách nhau bằng dấu phẩy (,)
              </Form.Text>
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Hủy
          </Button>
          <Button variant="primary" onClick={handleSave}>
            Lưu
          </Button>
        </Modal.Footer>
      </Modal>

      {/* Modal hiển thị danh sách thành viên */}
      <Modal show={showMemberModal} onHide={() => setShowMemberModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>Danh sách thành viên</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {selectedMembers.length > 0 ? (
            <ul>
              {selectedMembers.map((m, idx) => (
                <li key={idx} className="mb-2">
                  {idx + 1}. {m}
                </li>
              ))}
            </ul>
          ) : (
            <p>Không có thành viên nào.</p>
          )}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowMemberModal(false)}>
            Đóng
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default ProjectManagement;
