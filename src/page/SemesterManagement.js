import React, { useState } from "react";
import { Table, Button, Modal, Form } from "react-bootstrap";

const SemesterManagement = ({ onView }) => {
  const [semesters, setSemesters] = useState([
    { id: 1, name: "Học kỳ 1 - Năm 2025", start: "2025-01-15", end: "2025-05-30" },
    { id: 2, name: "Học kỳ 2 - Năm 2025", start: "2025-08-10", end: "2025-12-20" },
  ]);

  const [showModal, setShowModal] = useState(false);
  const [newSemester, setNewSemester] = useState({ name: "", start: "", end: "" });
  const [editIndex, setEditIndex] = useState(null);

  const handleShowModal = (semester = null, index = null) => {
    if (semester) {
      setNewSemester(semester);
      setEditIndex(index);
    } else {
      setNewSemester({ name: "", start: "", end: "" });
      setEditIndex(null);
    }
    setShowModal(true);
  };

  const handleSave = () => {
    if (!newSemester.name || !newSemester.start || !newSemester.end) {
      alert("Vui lòng điền đủ thông tin!");
      return;
    }
    if (editIndex !== null) {
      const updated = [...semesters];
      updated[editIndex] = newSemester;
      setSemesters(updated);
    } else {
      setSemesters([...semesters, { ...newSemester, id: Date.now() }]);
    }
    setShowModal(false);
  };

  const handleDelete = (id) => {
    if (window.confirm("Bạn có chắc muốn xóa học kỳ này?")) {
      setSemesters(semesters.filter((s) => s.id !== id));
    }
  };

  return (
    <div className="p-4 flex-grow-1">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="fw-bold text-primary">Quản lý Kỳ học</h4>
        <Button variant="primary" onClick={() => handleShowModal()}>
          + Thêm Kỳ học
        </Button>
      </div>

      <Table striped bordered hover>
        <thead className="table-primary">
          <tr>
            <th>#</th>
            <th>Tên Kỳ học</th>
            <th>Bắt đầu</th>
            <th>Kết thúc</th>
            <th>Hành động</th>
          </tr>
        </thead>
        <tbody>
          {semesters.length > 0 ? (
            semesters.map((s, index) => (
              <tr key={s.id}>
                <td>{index + 1}</td>
                <td>{s.name}</td>
                <td>{s.start}</td>
                <td>{s.end}</td>
                <td>
                  <Button variant="warning" size="sm" className="me-2" onClick={() => onView()}>
                    Xem
                  </Button>
                  <Button variant="danger" size="sm" onClick={() => handleDelete(s.id)}>
                    Xóa
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center">Chưa có kỳ học nào</td>
            </tr>
          )}
        </tbody>
      </Table>

      <Modal show={showModal} onHide={() => setShowModal(false)} centered>
        <Modal.Header closeButton>
          <Modal.Title>{editIndex !== null ? "Sửa Kỳ học" : "Thêm Kỳ học"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Tên Kỳ học</Form.Label>
              <Form.Control
                type="text"
                placeholder="Ví dụ: Học kỳ 1 - Năm 2026"
                value={newSemester.name}
                onChange={(e) => setNewSemester({ ...newSemester, name: e.target.value })}
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Ngày bắt đầu</Form.Label>
              <Form.Control type="date" value={newSemester.start} onChange={(e) => setNewSemester({ ...newSemester, start: e.target.value })} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Ngày kết thúc</Form.Label>
              <Form.Control type="date" value={newSemester.end} onChange={(e) => setNewSemester({ ...newSemester, end: e.target.value })} />
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

export default SemesterManagement;
