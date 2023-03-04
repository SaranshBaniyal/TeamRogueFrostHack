import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import "./login.module.css";
import UserContext from "../UserContext";

const Login = ({ onLogin }) => {
  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const apiUrl = "http://192.168.89.46:8000/api/accounts/login/";
    try {
      const response = await fetch(apiUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(loginData),
      });
      if (!response.ok) {
        throw new Error("Invalid login credentials");
      }
      const data = await response.json();
      onLogin(loginData.username);
      console.log(loginData.username);
      navigate("/");
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="login-page">
      <div className="form">
        <span className="Logintext">Login</span>
        <br />
        <br />
        <br />
        <br />
        <form className="login-form" onSubmit={handleSubmit}>
          <div>
            <input
              type="text"
              name="username"
              id="username"
              value={loginData.username}
              onChange={handleChange}
              required
              autoComplee="off"
              placeholder="Enter username"
            />
          </div>
          <br />
          <br />
          <div>
            <input
              type="password"
              name="password"
              id="password"
              value={loginData.password}
              autoComplee="off"
              onChange={handleChange}
              required
              placeholder="Enter password"
            />
          </div>
          <br />
          <br />
          <div className="footer">
            <button type="submit" className="loginbtn">
              Login
            </button>
            <p>
              New to Emosense!!
              <span>
                <Link to="/signup" className="signuplink">
                  Signup
                </Link>
              </span>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
