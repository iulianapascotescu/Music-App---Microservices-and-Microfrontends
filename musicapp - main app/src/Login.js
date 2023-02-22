import React, { useState } from "react";
import "./Login.css";

function Login(props) {
  let credentialsHandler = props.credentialsHandler;
  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");

  const usernameHandler = (event) => {
    console.log(event.target.value);
    setUsername(event.target.value);
  };
  const passwordHandler = (event) => {
    console.log(event.target.value);
    setPassword(event.target.value);
  };

  const loginHandler = () => {
    credentialsHandler(username, password);
  };

  return (
    <div className="form-container">
      <input
        type="text"
        placeholder="Username"
        onChange={usernameHandler}
      ></input>
      <input
        type="password"
        placeholder="Password"
        onChange={passwordHandler}
      ></input>
      <div className="btn-login" onClick={() => loginHandler()}>
        Login
      </div>
    </div>
  );
}

export default Login;
