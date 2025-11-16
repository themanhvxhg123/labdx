import React, { useState } from "react";
import { Table, Button, Modal, Form } from "react-bootstrap";

const GroupManagement = () => {
  const [groups, setGroups] = useState([
    { id: 1, name: "AI Research Team", semester: "Fall 2024", leader: "Nguyễn Văn A" },
    { id: 2, name: "Web Dev Squad", semester: "Fall 2024", leader: "Trần Thị B" },
  ]);

  const [showModal, setShowModal] = useState(false);
  const [newGroup, setNewGroup] = useState({ name: "", semester: "", leader: "" });
  const [editIndex, setEditIndex] = useState(null);

  const handleShowModal = (group = null, index = null) => {
    if (group) {
      setNewGroup(group);
      setEditIndex(index);
    } else {
      setNewGroup({ name: "", semester: "", leader: "" });
      setEditIndex(null);
    }
    setShowModal(true);
  };

  const handleSave = () => {
    if (!newGroup.name || !newGroup.semester || !newGroup.leader) {
      alert("Vui lòng điền đầy đủ thông tin!");
      return;
    }
    if (editIndex !== null) {
      const updated = [...groups];
      updated[editIndex] = newGroup;
      setGroups(updated);
    } else {
      setGroups([...groups, { ...newGroup, id: Date.now() }]);
    }
    setShowModal(false);
  };

  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc muốn xóa nhóm này?")) {
      setGroups(groups.filter((g) => g.id !== id));
    }
  };

  return (
    <div className="p-4 flex-grow-1">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="fw-bold text-primary">Quản lý Ban (Nhóm)</h4>
        <Button variant="primary" onClick={() => handleShowModal()}>
          + Thêm Nhóm
        </Button>
      </div>

      <Table striped bordered hover responsive>
        <thead className="table-primary">
          <tr>
            <th>#</th>
            <th>Tên Nhóm</th>
            <th>Kỳ học</th>
            <th>Leader</th>
            <th>Hành động</th>
          </tr>
        </thead>
        <tbody>
          {groups.length > 0 ? (
            groups.map((g, index) => (
              <tr key={g.id}>
                <td>{index + 1}</td>
                <td>{g.name}</td>
                <td>{g.semester}</td>
                <td>{g.leader}</td>
                <td>
                  <Button variant="warning" size="sm" className="me-2" onClick={() => handleShowModal(g, index)}>Sửa</Button>
                  <Button variant="danger" size="sm" onClick={() => handleDelete(g.id)}>Xóa</Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center">Chưa có nhóm nào</td>
            </tr>
          )}
        </tbody>
      </Table>

      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>{editIndex !== null ? "Sửa Nhóm" : "Thêm Nhóm"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Tên Nhóm</Form.Label>
              <Form.Control type="text" value={newGroup.name} onChange={(e) => setNewGroup({ ...newGroup, name: e.target.value })} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Kỳ học</Form.Label>
              <Form.Control type="text" value={newGroup.semester} onChange={(e) => setNewGroup({ ...newGroup, semester: e.target.value })} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Leader</Form.Label>
              <Form.Control type="text" value={newGroup.leader} onChange={(e) => setNewGroup({ ...newGroup, leader: e.target.value })} />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>Hủy</Button>
          <Button variant="primary" onClick={handleSave}>Lưu</Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default GroupManagement;
