import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import "./login.module.css";
import UserContext from "../UserContext";

const Login = ({ onLogin }) => {
  const { setUser } = useContext(UserContext);
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
    const apiUrl = "http://192.168.39.46:8000/api/accounts/login/";
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
      setUser(data.username);
      onLogin(data.token); // pass the token to the parent component
      navigate("/");
      localStorage.setItem("token", data.token);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className="container">
      <div className="innerbox">
        <h1>Login</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <label htmlFor="username">Username</label>
            <input
              type="text"
              name="username"
              value={loginData.username}
              onChange={handleChange}
              required
              placeholder="Enter username"
            />
          </div>
          <div>
            <label htmlFor="password">Password</label>
            <input
              type="password"
              name="password"
              value={loginData.password}
              onChange={handleChange}
              required
              placeholder="Enter password"
            />
          </div>
          <div className="footer">
            <button>Login</button>
            <p>
              New to Emosense!!
              <span>
                <Link to="/signup">Signup</Link>
              </span>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
