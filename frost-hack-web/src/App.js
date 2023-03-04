import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./navbar";
import Home from "./home";
import { useState, React, useEffect } from "react";
import Login from "./components/login";
import Signup from "./components/signup";
import Notes from "./components/notes";
import UserContext from "./UserContext";
import Notehistory from "./components/notehistory";
import Notfound from "./components/Notfound";

const App = () => {
  // const [token, setToken] = useState(null);
  const [user, setUser] = useState(null);

  const handleLogin = (username) => {
    setUser(username);
  };

  useEffect(() => {
    console.log(user);
  }, [user]);
  return (
    <UserContext.Provider value={{ user, setUser }}>
      <Router>
        <div className="App">
          <Navbar username={user}></Navbar>
          <Routes>
            <Route path="/" exact element={<Home />} />
            <Route
              path="/login"
              exact
              element={<Login onLogin={handleLogin} />}
            />
            <Route
              path="/signup"
              exact
              element={<Signup onLogin={handleLogin} />}
            />
            <Route path="/newnote" exact element={<Notes username={user} />} />
            <Route
              path="/history"
              exact
              element={<Notehistory username={user} />}
            />
            <Route path="*" exact element={<Notfound />} />
          </Routes>
        </div>
      </Router>
    </UserContext.Provider>
  );
};

export default App;
