
import React, { useState, useEffect } from "react";
const RemoteApp = React.lazy(() => import("Remote/App"));
import LoadingSpinner from "./LoadingSpinner";

function RemoteWrapper(props) {
  // const [loaded,setLoaded] = useState(false);
  // setTimeout(()=>{
  //     setLoaded(true);
  // },1000);
  // return (
  //   <div style={{border: "1px solid red", background: "white"}}>
  //     {loaded ? <RemoteApp songId={props.songId}/> : null}
  //   </div>
  // );

  const [wait, setWait] = useState(true);

    useEffect(() => {
        const timer = setTimeout(() => {
            setWait(false);
        }, 1000);
        return () => clearTimeout(timer);
    }, [setWait]);
    return (
        <div>
            {wait ? <LoadingSpinner /> : <RemoteApp songId={props.songId}/>}
        </div>
    );
}

export default RemoteWrapper;
