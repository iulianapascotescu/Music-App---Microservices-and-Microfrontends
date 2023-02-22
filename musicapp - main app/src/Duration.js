import React from "react";
import { useEffect, useState } from "react";

function Duration(props) {
    const [duration,setDuration] = useState(0);

  useEffect(() => {
    const durationUrl = "http://localhost:8081/artists/songs/" + props.songId;
    fetch(durationUrl)
      .then((response) => {
        if(!response.ok) { throw new Error("error");}
        return response.json();
      })
      .then((json) => setDuration(json)).catch((e)=>console.log("err"));
  },[setDuration]);

  return (<div>
    {duration} seconds
  </div>)
}

export default Duration;
