import React, { useState } from "react";
import Login from "./Login";
import { Buffer } from "buffer";
import "./App.css";
import ListArtists from "./ListArtists";

function App() {
  const [isConnected, setIsConnected] = useState(false);
  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");
  const [tokenId, setTokenId] = useState("");
  const credentialsHandler = (username, password) => {
    let url = "http://localhost:8081/login";
    fetch(url, {
      headers: {
        Authorization:
          "Basic " + Buffer.from(username + ":" + password).toString("base64"),
      },
    })
      .then((response) => {
        return response.text();
      })
      .then(
        (result) => {
          setTokenId(
            "Basic " + Buffer.from(username + ":" + password).toString("base64")
          );
          setUsername(username);
          setPassword(password);
          setIsConnected(true);
        },
        (error) => {
          console.log("Error fetching the artists " + error);
        }
      );
  };

  return (
    <div className="container">
      {isConnected ? (
        <div className="container-child">
          <div class="header">
            <h1 class="display-4">Favourite artists</h1>
          </div>
          <ListArtists
            username={username}
            password={password}
            tokenId={tokenId}
          />
        </div>
      ) : (
        <Login credentialsHandler={credentialsHandler} />
      )}
    </div>
  );
}

export default App;
