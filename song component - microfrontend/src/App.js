import React, { useEffect, useState } from "react";

function App(props) {
  const [duration, setDuration] = useState(0);
  useEffect(() => {
    let url = "http://localhost:8081/artists/songs/" + props.songId;
    fetch(url, { headers: { "Authorization" : "Basic cm9vdDpyb290" } })
      .then((res) => res.json())
      .then(
        (result) => {
          console.log(result);
          setDuration(result);
        },
        (error) => {
          console.log("Error fetching the duration " + error);
        }
      );
  }, [setDuration]);
  console.log(props.songId);
  return <div>{duration} seconds</div>;
}
export default App;
