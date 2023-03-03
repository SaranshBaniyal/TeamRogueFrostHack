// import React from "react";
// import { Link } from "react-router-dom";
// // import fetchfromapi from "../utilis/fetchfromapi";

// const Signup = () => {
//   const handlesubmit = () => {
//     const apiUrl = "http://192.168.39.46:8000/api/accounts/signup/";

// const userData = {
//   username: "example_user",
//   full_name: "example_name",
//   email: "example_user@example.com",
//   password: "example_password",
// };

//     fetch(apiUrl, {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(userData),
//     })
//       .then((response) => response.json())
//       .then((data) => console.log(data))
//       .catch((error) => console.error(error));
//   };
//   return (
//     <div className="container">
//       <div className="innerbox">
//         <h1>signup</h1>
//         <form onSubmit={handlesubmit}>
//           <input type="text" placeholder="Enter username" />
//           <input type="text" placeholder="Enter name" />
//           <input type="email" placeholder="Enter your email id" />
//           <input type="password" placeholder="Enter password" />
//           <div className="footer">
//             <button>Signup</button>
//             <p>
//               Already have an account?{" "}
//               <span>
//                 <Link to="/login">Login</Link>
//               </span>
//             </p>
//           </div>
//         </form>
//       </div>
//     </div>
//   );
// };

// export default Signup;
import React, { useState } from "react";
import { Link } from "react-router-dom";
import signupimg from "../image/2.svg";
const Signup = () => {
  const [userData, setUserData] = useState({
    username: "",
    full_name: "",
    email: "",
    password: "",
  });

  const handleChange = (event) => {
    setUserData({
      ...userData,
      [event.target.name]: event.target.value,
    });
  };

  const handlesubmit = (event) => {
    event.preventDefault();

    const apiUrl = "http://192.168.39.46:8000/api/accounts/signup/";

    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userData),
    })
      .then((response) => response.json())
      .then((response) => console.log(response))
      .then((data) => console.log(data))
      .catch((error) => console.error(error));
  };

  return (
    <section className="signup">
      <div className="container mt-5">
        <div className="signup-content">
          .
          <div className="signup-form">
            <h2 className="form-title">Sign-up</h2>
            <form id="register-form" className="register-form">
              <div className="form-group">
                <label htmlFor="name">
                  <i class="zmdi zmdi-account material-icons-name"></i>
                </label>
                <input
                  type="text"
                  name="username"
                  id="username"
                  autoComplete="off"
                  placeholder="Enter your Username "
                  value={userData.username}
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="name">
                  <i class="zmdi zmdi-account material-icons-name"></i>
                </label>
                <input
                  type="text"
                  name="name"
                  id="name"
                  autoComplete="off"
                  placeholder="Enter name"
                  value={userData.full_name}
                  onChange={handleChange}
                />
              </div>
              <div className="form-group">
                <label htmlFor="name">
                  <i class="zmdi zmdi-account material-icons-name"></i>
                </label>
                <input
                  type="email"
                  name="name"
                  id="name"
                  autoComplete="off"
                  placeholder="Enter your name "
                />
              </div>
              <div className="form-group">
                <label htmlFor="name">
                  <i class="zmdi zmdi-account material-icons-name"></i>
                </label>
                <input
                  type="text"
                  name="name"
                  id="name"
                  autoComplete="off"
                  placeholder="Enter your name "
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Signup;

/*
<h1>signup</h1>
          <form onSubmit={handlesubmit}>
            <div>
              <input
                type="text"
                name="username"
                placeholder="Enter username"
                value={userData.username}
                onChange={handleChange}
              />
            </div>
            <div>
              <input
                type="text"
                name="full_name"
                placeholder="Enter name"
                value={userData.full_name}
                onChange={handleChange}
              />
            </div>
            <div>
              <input
                type="email"
                name="email"
                placeholder="Enter your email id"
                value={userData.email}
                onChange={handleChange}
              />
            </div>
            <div>
              <input
                type="password"
                name="password"
                placeholder="Enter password"
                value={userData.password}
                onChange={handleChange}
              />
            </div>
            <div className="footer">
              <button type="submit">Signup</button>
              <p>
                Already have an account?{" "}
                <span>
                  <Link to="/login">Login</Link>
                </span>
              </p>
            </div>
          </form>*/
