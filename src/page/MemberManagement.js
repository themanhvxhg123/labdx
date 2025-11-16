import React, { useState } from "react";
import { Table, Button, Modal, Form } from "react-bootstrap";

const MemberManagement = () => {
  const [members, setMembers] = useState([
    { id: 1, name: "Nguyễn Văn A", studentCode: "HE181327", group: 1, field: "Coding", project: "Website bán hàng" },
    { id: 2, name: "Trần Thị B", studentCode: "HE182541", group: 2, field: "Thiết kế", project: "Ứng dụng học tập" },
  ]);

  const [showModal, setShowModal] = useState(false);
  const [newMember, setNewMember] = useState({ name: "", studentCode: "", group: "", field: "", project: "" });
  const [editIndex, setEditIndex] = useState(null);

  const handleShowModal = (member = null, index = null) => {
    if (member) {
      setNewMember(member);
      setEditIndex(index);
    } else {
      setNewMember({ name: "", studentCode: "", group: "", field: "", project: "" });
      setEditIndex(null);
    }
    setShowModal(true);
  };

  const handleSave = () => {
    if (!newMember.name || !newMember.studentCode || !newMember.group || !newMember.field || !newMember.project) {
      alert("Vui lòng điền đầy đủ thông tin!");
      return;
    }
    if (editIndex !== null) {
      const updated = [...members];
      updated[editIndex] = newMember;
      setMembers(updated);
    } else {
      setMembers([...members, { ...newMember, id: Date.now() }]);
    }
    setShowModal(false);
  };

  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc muốn xóa sinh viên này?")) {
      setMembers(members.filter((m) => m.id !== id));
    }
  };

  return (
    <div className="p-4 flex-grow-1">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="fw-bold text-primary">Quản lý Sinh viên</h4>
        <Button variant="primary" onClick={() => handleShowModal()}>
          + Thêm sinh viên
        </Button>
      </div>

      <Table striped bordered hover responsive>
        <thead className="table-primary">
          <tr>
            <th>#</th>
            <th>Họ và tên</th>
            <th>Mã sinh viên</th>
            <th>Nhóm</th>
            <th>Lĩnh vực</th>
            <th>Dự án tham gia</th>
            <th>Hành động</th>
          </tr>
        </thead>
        <tbody>
          {members.length > 0 ? (
            members.map((m, index) => (
              <tr key={m.id}>
                <td>{index + 1}</td>
                <td>{m.name}</td>
                <td>{m.studentCode}</td>
                <td>{m.group}</td>
                <td>{m.field}</td>
                <td>{m.project}</td>
                <td>
                  <Button
                    variant="warning"
                    size="sm"
                    className="me-2"
                    onClick={() => handleShowModal(m, index)}
                  >
                    Sửa
                  </Button>
                  <Button
                    variant="danger"
                    size="sm"
                    onClick={() => handleDelete(m.id)}
                  >
                    Xóa
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="7" className="text-center">
                Chưa có sinh viên nào
              </td>
            </tr>
          )}
        </tbody>
      </Table>

      {/* Modal thêm/sửa sinh viên */}
      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>
            {editIndex !== null ? "Sửa thông tin sinh viên" : "Thêm sinh viên mới"}
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Họ và tên</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: Nguyễn Văn A"
                value={newMember.name}
                onChange={(e) =>
                  setNewMember({ ...newMember, name: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Mã sinh viên</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: HE181327"
                value={newMember.studentCode}
                onChange={(e) =>
                  setNewMember({ ...newMember, studentCode: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Nhóm</Form.Label>
              <Form.Control
                type="number"
                placeholder="Ví dụ: 1"
                value={newMember.group}
                onChange={(e) =>
                  setNewMember({ ...newMember, group: e.target.value })
                }
              />
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Lĩnh vực</Form.Label>
              <Form.Select
                value={newMember.field}
                onChange={(e) =>
                  setNewMember({ ...newMember, field: e.target.value })
                }
              >
                <option value="">-- Chọn lĩnh vực --</option>
                <option value="Coding">Coding</option>
                <option value="BA">BA</option>
                <option value="Thiết kế">Thiết kế</option>
                <option value="Tester">Tester</option>
                <option value="Khác">Khác</option>
              </Form.Select>
            </Form.Group>

            <Form.Group className="mb-3">
              <Form.Label>Dự án tham gia</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: Website quản lý sinh viên"
                value={newMember.project}
                onChange={(e) =>
                  setNewMember({ ...newMember, project: e.target.value })
                }
              />
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
    </div>
  );
};

export default MemberManagement;
