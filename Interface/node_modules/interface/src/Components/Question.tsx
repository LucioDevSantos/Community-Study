import { useState } from "react";
import "../index.css"
import useValidateParams from "../Hooks/useValidateParams";

type question = {
    id: number;
    topic: string;
    content: string;
    options: Array<option>;
    community_id: number;
}

type option = {
    id: number;
    name: string;
    content: string;
    isRight: boolean;
    questions: string;
}








export default function Question( prop: question ){



    const [selectedOpt, setSelected] = useState<option>({
    id: 0,
    name: '',
    content: '',
    isRight: false,
    questions: ''
 })



    const topics = prop.topic.split(' ')

    const handleSelect = (option: option) =>{
            setSelected(option)
    }

    const community = useValidateParams(prop.community_id)



const testHandle = () => {
    console.log('tested')
}



    return(
        <>
        <div key={prop.id} className="w-2/4 h-full bg-slate-400 rounded-lg m-5">
            <div className="bg-slate-600 font-semibold rounded-tr-lg rounded-tl-lg h-1/5 flex flex-row">

{
        topics.map(topi => {
            return(<p className="m-2 bg-slate-50 h-fit p-1 rounded">
                {topi}
            </p>)
        })




}
            </div>
            <div className="">
            <h2 className="m-2 font-semibold">
                {prop.content}

            </h2>
            </div>


            <div className="flex flex-col ">
                {prop.options.map((opt)=>(
                    
                    <div key={opt.id} style={{
                        background: selectedOpt?.id == opt.id ?'lightblue' : 'none'
                    }} className="flex flex-row items-center text-center hover:bg-white cursor-pointer m-1 rounded-xl " onClick={() => handleSelect(opt)}>
                        

                        <div className="border border-blue-950 p-2 w-8 h-8 rounded-full flex text-center items-center justify-center m-2">
                            {opt.name}
                            </div>
                        <div>
                            {opt.content}
                        </div>
                    </div>

                ))}

                <div>
                    {community}
                </div>
                <button className="bg-blue-800 w-1/5 m-2 text-center rounded font-RadioCanada text-white" onClick={testHandle}>
                    Responder
                </button>
            </div>

            
        </div>
        </>
    )
}
