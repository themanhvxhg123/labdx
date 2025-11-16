import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "bootstrap/dist/css/bootstrap.min.css";
import "./index.css"; // nếu bạn có custom styles - nếu chưa, tạo file rỗng hoặc bỏ dòng này

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<App />);
