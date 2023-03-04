import { color } from "framer-motion";
import React, { useState, useEffect, Component } from "react";
import { Link } from "react-router-dom";

const Navbar = ({ username }) => {
  const [userName, setUserName] = useState("");
  useEffect(() => {
    if (username) {
      setUserName(username);
    }
  }, [username]);
  const handleLogout = () => {
    setUserName(null);
    username = null;
    // localStorage.removeItem("token");
    window.location.reload();
  };
  return (
    <nav className="navbar">
      <a href="">
        <svg
          id="logo-15"
          width="49"
          height="48"
          viewBox="0 0 49 48"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          {" "}
          <path
            d="M24.5 12.75C24.5 18.9632 19.4632 24 13.25 24H2V12.75C2 6.53679 7.03679 1.5 13.25 1.5C19.4632 1.5 24.5 6.53679 24.5 12.75Z"
            class="ccustom"
            fill="white"
            stop-color="white"
          ></path>{" "}
          <path
            d="M24.5 35.25C24.5 29.0368 29.5368 24 35.75 24H47V35.25C47 41.4632 41.9632 46.5 35.75 46.5C29.5368 46.5 24.5 41.4632 24.5 35.25Z"
            class="ccustom"
            fill="white"
            stop-color="white"
          ></path>{" "}
          <path
            d="M2 35.25C2 41.4632 7.03679 46.5 13.25 46.5H24.5V35.25C24.5 29.0368 19.4632 24 13.25 24C7.03679 24 2 29.0368 2 35.25Z"
            class="ccustom"
            fill="white"
            stop-color="white"
          ></path>{" "}
          <path
            d="M47 12.75C47 6.53679 41.9632 1.5 35.75 1.5H24.5V12.75C24.5 18.9632 29.5368 24 35.75 24C41.9632 24 47 18.9632 47 12.75Z"
            class="ccustom"
            fill="white"
            stop-color="white"
          ></path>{" "}
        </svg>{" "}
        <h1 style={{ color: "white" }}>Emosense</h1>
      </a>
      <div className="as">
        <ul id="navbar">
          <li>
            <Link className="active" to="/">
              Home
            </Link>
          </li>
          {username && (
            <>
              <li>
                <Link
                  to="/newnote"
                  style={{
                    color: "white",
                    backgroundColor: "#17cf97",
                    borderRadius: "8px",
                    padding: "5px",
                  }}
                >
                  New note
                </Link>
              </li>
              <li>
                <Link>About</Link>
              </li>
              <li>
                <Link>Contact us</Link>
              </li>
              <li>
                <Link to="/history">Journal's history</Link>
              </li>
              <span style={{ fontSize: "1.3rem", color: "white" }}>
                Welcome, {userName}!
              </span>
              <button
                style={{
                  color: "white",
                  backgroundColor: "#17cf97",
                  borderRadius: "8px",
                  fontSize: "1.3rem",
                  padding: "5px",
                }}
                onClick={handleLogout}
              >
                Logout
              </button>
            </>
          )}
          {!username && (
            <>
              <li>
                <button
                  style={{
                    color: "white",
                    backgroundColor: "#17cf97",
                    borderRadius: "8px",
                    fontSize: "1.3rem",
                    padding: "5px",
                  }}
                >
                  <Link to="/login">Login</Link>
                </button>
              </li>
              <li>
                <button
                  style={{
                    color: "white",
                    backgroundColor: "#17cf97",
                    borderRadius: "8px",
                    fontSize: "1.3rem",
                    padding: "5px",
                  }}
                >
                  <Link to="/signup">Signup</Link>
                </button>
              </li>
            </>
          )}{" "}
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
