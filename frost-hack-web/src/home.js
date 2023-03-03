import React from "react";
import image from "./image/1.svg";
const Home = () => {
  return (
    <div style={{ display: "flex", alignItems: "center" }}>
      <div style={{ flex: "1" }}>
        <img
          className="home-img"
          src={image}
          alt="My Home"
          style={{ width: "100%", maxWidth: "500px" }}
        />
      </div>
      <div className="Ab" style={{ flex: "1" }}>
        <h1>Welcome to My Home Page</h1>
        <p>This is some text about me and my home.</p>
      </div>
    </div>
  );
};

export default Home;
