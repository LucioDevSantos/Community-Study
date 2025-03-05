import { useEffect, useState } from "react";
import socket from "../../Services/websocket";


const CommunityChat = () => {
    
    const [isConnected, setConnected] = useState(socket.connected)




    useEffect(()=>{
        function onConnect(){
            setConnected(true)
        }


        socket.on('connect', onConnect)
    }, [])

    

    return (
        <>
        <h1>
            chat test
            {isConnected}
            
        </h1>
        </>
    );
};

export default CommunityChat;