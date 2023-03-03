import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./navbar";
import Home from "./home";
import { useState, React, useEffect } from "react";
import Login from "./components/login";
import Signup from "./components/signup";
import Notes from "./components/notes";
import UserContext from "./UserContext";

const App = () => {
  const [token, setToken] = useState(null);
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storedToken = localStorage.getItem("token");
    if (storedToken) {
      setToken(storedToken);
    }
  }, []);
  const handleLogin = (username) => {
    setUser(username);
  };

  return (
    <UserContext.Provider value={{ user, setUser }}>
      <Router>
        <div className="App">
          <Navbar isLoggedIn={token}></Navbar>
          <Routes>
            <Route path="/" exact element={<Home />} />
            <Route
              path="/login"
              exact
              element={<Login onLogin={handleLogin} />}
            />
            <Route path="/signup" exact element={<Signup />} />
            <Route path="/newnote" exact element={<Notes username={``} />} />
          </Routes>
        </div>
      </Router>
    </UserContext.Provider>
  );
};

export default App;
