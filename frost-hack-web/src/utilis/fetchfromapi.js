const apiUrl = "http://192.168.39.46:8000/api/accounts/signup/";

const userData = {
  username: "example_user",
  full_name: "example_name",
  email: "example_user@example.com",
  password: "example_password",
};

fetch(apiUrl, {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify(userData),
})
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((error) => console.error(error));
