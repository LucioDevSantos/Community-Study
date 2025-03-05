import socket from "../Services/socket"

export default function SocketTest(){

        const connect = () => {
            socket.onopen = () => {
                console.log("nice")
                socket.send("test")
            }
        }

        const disconnect = () =>{
            socket.onclose = () => {
                console.log("test")
            }
        }

        socket.onmessage = (event) => {
            console.log("Mensagem recebida:", event.data);
          };

    return (
        <>
        <button onClick={connect} className="w-1/6 bg-green-600 m-2">connect</button>
        <button onClick={disconnect} className="w-1/6 bg-red-600 m-2">disconnect</button>
        
        </>
    )
}

