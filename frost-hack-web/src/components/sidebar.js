// import React, { Children } from "react";
// import { FaBars, FaTh, FaThList, FaUserAlt } from "react-icons/fa";
// import { NavLink } from "react-router-dom";
// const Sidebar = ({ Children }) => {
//   const menuItem = [
//     {
//       path: "/",
//       name: "Home",
//       icon: <FaTh />,
//     },
//     {
//       path: "/about",
//       name: "About",
//       icon: <FaUserAlt />,
//     },
//     {
//       path: "/notes",
//       name: "Past Notes",
//       icon: <FaThList />,
//     },
//   ];
//   return (
//     <div className="container">
//       <div className="sidebar">
//         <div className="top_section">
//           <div className="bars">
//             <FaBars />
//           </div>
//         </div>
//         {menuItem.map((item, index) => (
//           <NavLink
//             to={item.path}
//             key={index}
//             className="link"
//             activeclassname="active"
//           >
//             <div className="icon">{item.icon}</div>
//             <div className="link_text">{item.name}</div>
//           </NavLink>
//         ))}
//       </div>
//       <main>{Children}</main>
//     </div>
//   );
// };

// export default Sidebar;
import React from "react";
import { Menu } from "antd";
const Sidebar = () => {
  return (
    <div>
      <Menu>
        items=
        {[
          { label: "Home" },
          { label: "Dashboard" },
          { label: "Users list" },
          { label: "Profile" },
          { label: "About" },
        ]}
      </Menu>
    </div>
  );
};

export default Sidebar;
