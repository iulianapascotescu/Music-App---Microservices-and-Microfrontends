import { useEffect, useState } from "react";
import React from "react";
import RemoteWrapper from "./RemoteWrapper";
import "./App.css";

function Music(props) {
  const [songs, setSongs] = useState([]);
  const [showDuration, setShowDuration] = useState([]);
  useEffect(() => {
    const songsUrl =
      "http://localhost:8081/artists/" + props.artistId + "/songs";
    fetch(songsUrl, { headers: { "Authorization" : "Basic cm9vdDpyb290" } })
      .then((response) => response.json())
      .then((json) => setSongs(json));
  }, [setSongs]);

  const showDurationClickHandler = (songId) => {
    if (showDuration.includes(songId)) {
      setShowDuration(showDuration.filter((sid) => sid !== songId));
    } else {
      let newShowDuration = [...showDuration];
      newShowDuration.push(songId);
      setShowDuration(newShowDuration);
    }
  };

  return (
    <div className="artist">
      {songs.map((song) => (
        <div key={song.songId}>
          - {song.name}, {song.releaseYear}
          <button onClick={() => showDurationClickHandler(song.songId)}>
            Show duration
          </button>
          <div>
            {showDuration.includes(song.songId) ? (
              <RemoteWrapper songId={song.songId}></RemoteWrapper>
            ) : null}
          </div>
        </div>
      ))}
    </div>
  );
}

export default Music;
