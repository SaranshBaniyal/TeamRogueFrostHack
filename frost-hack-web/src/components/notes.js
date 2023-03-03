import React, { useState } from "react";

const Notes = ({ username }) => {
  console.log(username + "hello");

  const [entry, setentry] = useState("");
  const handleInputChange = (event) => {
    setentry(event.target.value);
  };
  const handleSubmit = (event) => {
    event.preventDefault();

    const apiUrl = "192.168.39.46:8000/api/accounts/input/";
    const requestData = { username, text: entry };
    fetch(apiUrl, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(requestData),
    })
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((error) => console.error(error));
  };

  return (
    <div className="create">
      <form onSubmit={handleSubmit}>
        <h1>Enter your today's diary</h1>
        <textarea
          required
          name="diary"
          className="diary"
          rows="30"
          value={entry}
          onChange={handleInputChange}
          placeholder="Today's journal entry"
        />
        <button type="submit">Add journal entry</button>
      </form>
    </div>
  );
};

export default Notes;
