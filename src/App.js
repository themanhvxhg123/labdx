import React, { useState } from "react";
import Header from "./components/Header";
import Sidebar from "./components/Sidebar";
import Dashboard from "./page/Dashboard";
import SemesterManagement from "./page/SemesterManagement";
import ProjectManagement from "./page/ProjectManagement";
import GroupManagement from "./page/GroupManagement";
import MemberManagement from "./page/MemberManagement";
import Login from "./page/Login";

// ...existing code...
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [currentPage, setCurrentPage] = useState("Dashboard");
  const [showSemesterCard, setShowSemesterCard] = useState(true); // điều khiển hiển thị ô Kỳ học trên Dashboard
  const [hideSidebar, setHideSidebar] = useState(false); // ẩn/hiện sidebar (ẩn khi ở SemesterManagement)

  const handleLogin = () => {
    setIsLoggedIn(true);
    setCurrentPage("Kỳ học"); // sau login mở luôn Kỳ học
    setHideSidebar(true);
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    setCurrentPage("Dashboard");
    setShowSemesterCard(true);
    setHideSidebar(false);
  };

  // khi user bấm "Xem" 1 kỳ học -> chuyển về Dashboard và ẩn ô Kỳ học
  const handleViewSemester = () => {
    setCurrentPage("Dashboard");
    setShowSemesterCard(false);
    setHideSidebar(false);
  };

  // khi user trong Dashboard bấm ô Kỳ học để vào lại Kỳ học
  const handleOpenSemesterFromDashboard = () => {
    setCurrentPage("Kỳ học");
    setHideSidebar(true);
    setShowSemesterCard(true); // khi vào lại, hiển thị lại menu Kỳ học (theo yêu cầu)
  };

  const renderPage = () => {
    switch (currentPage) {
      case "Dashboard":
        return (
          <Dashboard
            setCurrentPage={setCurrentPage}
            setShowSemesterCard={setShowSemesterCard}
            showSemesterCard={showSemesterCard}
            onOpenSemester={handleOpenSemesterFromDashboard}
          />
        );
      case "Kỳ học":
        return <SemesterManagement onView={handleViewSemester} />;
      case "Quản lý Dự án":
        return <ProjectManagement />;
      case "Quản lý Ban":
        return <GroupManagement />;
      case "Quản lý Thành viên":
        return <MemberManagement />;
      default:
        return (
          <Dashboard
            setCurrentPage={setCurrentPage}
            setShowSemesterCard={setShowSemesterCard}
            showSemesterCard={showSemesterCard}
            onOpenSemester={handleOpenSemesterFromDashboard}
          />
        );
    }
  };

  // ...existing code...
  if (!isLoggedIn) {
    return <Login onLogin={handleLogin} />;
  }

  return (
    <div className="d-flex flex-column vh-100">
      <Header onLogout={handleLogout} />
      <div className="d-flex flex-grow-1">
        {!hideSidebar && (
          <Sidebar currentPage={currentPage} setCurrentPage={setCurrentPage} />
        )}
        <div className="flex-grow-1 bg-light">{renderPage()}</div>
      </div>
    </div>
  );
}

export default App;
// ...existing code...