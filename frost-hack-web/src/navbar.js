import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
// const Navbar = (isLoggedIn) => {
//   useEffect(() => {
//     if (isLoggedIn) {
//       fetch("http://192.168.39.46:8000/api/accounts/profile/", {
//         headers: {
//           Authorization: `Token ${localStorage.getItem("token")}`,
//         },
//       })
//         .then((response) => response.json())
//         .then((data) => {
//           setUser(data.username);
//         })
//         .catch((error) => console.error(error));
//     }
//   }, [isLoggedIn]);
//   const [user, setUser] = useState(null);
//   const handleLogout = () => {
//     setUser(null);
//     localStorage.removeItem("token");
//   };
//   return (
//     <nav className="navbar">
//       <h1>Emosense</h1>
//       <div className="as">
//         <Link to="/">Home</Link>
//         {isLoggedIn && (
//           <>
//             <Link
//               to="/noteshistory"
//               style={{
//                 color: "white",
//                 backgroundColor: "black",
//                 borderRadius: "8px",
//               }}
//             >
//               New note
//             </Link>
//             <span>Welcome, {user}!</span>
//           </>
//         )}
//         {!isLoggedIn && (
//           <>
//             <Link to="/login">Login</Link>
//             <Link to="/signup">Signup</Link>
//           </>
//         )}
//       </div>
//     </nav>
//   );
// };

// export default Navbar;

const Navbar = ({ isLoggedIn }) => {
  const [userName, setUserName] = useState("");

  useEffect(() => {
    if (isLoggedIn) {
      fetch("http://192.168.39.46:8000/api/accounts/profile/", {
        headers: {
          Authorization: `Token ${localStorage.getItem("token")}`,
        },
      })
        .then((response) => response.json())
        .then((data) => {
          setUserName(data.username);
        })
        .catch((error) => console.error(error));
    }
  }, [isLoggedIn]);
  const handleLogout = () => {
    setUserName(null);
    localStorage.removeItem("token");
    window.location.reload();
  };
  return (
    <nav className="navbar">
      <h1>Emosense</h1>
      <div className="as">
        <Link to="/">Home</Link>

        {isLoggedIn && (
          <>
            <Link
              to="/newnote"
              style={{
                color: "white",
                backgroundColor: "black",
                borderRadius: "8px",
              }}
            >
              New note
            </Link>
            <span>Welcome, {userName}!</span>
            <button onClick={handleLogout}>Logout</button>
          </>
        )}
        {!isLoggedIn && (
          <>
            <Link to="/login">Login</Link>
            <Link to="/signup">Signup</Link>
          </>
        )}
      </div>
    </nav>
  );
};

export default Navbar;
