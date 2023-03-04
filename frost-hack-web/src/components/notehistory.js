import React, { useState, useEffect } from "react";

function NoteHistory({ username }) {
  const [notes, setNotes] = useState([]);

  const url = "http://192.168.89.46:8000/api/accounts/outputall/";

  useEffect(() => {
    async function fetchData() {
      const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username: username }),
      };
      const response = await fetch(url, requestOptions);
      const data = await response.json();
      setNotes(data);
      console.log(notes);
    }
    fetchData();
  }, [username]);

  return (
    <div>
      <h2>Note History for {username}</h2>
      {notes?.map((note, index) => (
        <div key={index} className="card">
          <p>{note.date}</p>
          <p>{note.entry}</p>
          <span className="label">{note.label}</span>
        </div>
      ))}
    </div>
  );
}

export default NoteHistory;
