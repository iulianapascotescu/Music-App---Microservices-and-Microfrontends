import React, { useEffect, useState } from "react";
import Music from "./Music";
import "./App.css";

function ListArtists(props) {
  const [artists, setArtists] = useState([]);
  const [showMusic, setShowMusic] = useState([]);
  const url = "http://localhost:8081/artists";

  useEffect(() => {
    fetch(url, { headers: { Authorization: props.tokenId } })
      .then((response) => response.json())
      .then((json) => setArtists(json));
  }, [setArtists]);

  const showSongsOfArtist = (artistId) => {
    if (showMusic.includes(artistId)) {
      setShowMusic(showMusic.filter((sid) => sid !== artistId));
    } else {
      let newShowMusic = [...showMusic];
      newShowMusic.push(artistId);
      setShowMusic(newShowMusic);
    }
  };

  return (
    <div className="artists-container">
      {artists.map((artist) => (
        <div className="card" key={artist.artistId}>
          <div
            className="card-header"
            onClick={() => showSongsOfArtist(artist.artistId)}
          >
           {artist.artistId}. {artist.name}
          </div>
          <div>
            {showMusic.includes(artist.artistId) ? (
              <Music artistId={artist.artistId}></Music>
            ) : null}
          </div>
        </div>
      ))}
    </div>
  );
}

export default ListArtists;
