import { Link } from "react-router-dom"


type data = {
    id: number
    name:string,
    code:number
}




export default function CommunityIcon(data: data){
    return(
        <>

            
            <div className="bg-blue-800 rounded-lg flex  m-5 items-center  ">

                <h1 className="m-5 font-bold text-center text-2xl ">{data.name}</h1>

                <button className="m-10 bg-white rounded p-1 font-semibold align-middle">
            
                 <Link to={`/community/${data.code}`} state={{comData: data}}>Enter</Link>
                </button>
            </div>

        </>
    )
}
