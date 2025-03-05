import "../../../index.css"
import "../../../styles/main.css"
import { ChangeEvent, FormEvent, useState } from "react"
import { apiSpring } from "../../../Services/api"
import { House } from "lucide-react"
import { Link, useLocation } from "react-router-dom"



type Question = {
    content: string,
    topic: string,
    options: Option[]
}

type Option = {
    name?: string,
    content: string,
    isRight: boolean
}



export default function CreateQuestion(){

    const [question, setQuestions] = useState<Question>({
        topic: '',
        content: '',
        options: []
    });

    const [options, setOptions] = useState<Option[]>([
        {
            name: 'A',
            content: '',
            isRight: false
        },
        {
            name: 'B',
            content: '',
            isRight: false
        },
        {
            name: 'C',
            content: '',
            isRight: false
        },
        {
            name: 'D',
            content: '',
            isRight: false
        },
        {
            name: 'E',
            content: '',
            isRight: false
        }
    ]) 

    const locateData = useLocation()

const comData = locateData.state || {}




    const handleChangeOpt = (e:ChangeEvent<HTMLInputElement>): void => {

        const { name, value, checked } = e.target


            const optionsUpdated = options.map((opt) => {
                if(opt.name == name){
                    if(checked){
                        return {...opt, isRight: true}
                    }else{
                        return {...opt, content: value}
                    }


                }
                return opt
            })
            setOptions(optionsUpdated)

            console.log(optionsUpdated)


    }


    const handleChange = (
        e: ChangeEvent<HTMLInputElement> | ChangeEvent<HTMLTextAreaElement>,   
    ) => {

            setQuestions({...question, [e.target.name]: e.target.value })
            
            console.log(question)
    }

    



    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault()
        const questionComplete = {
            topic: question.topic,
            content: question.content,
            optionsList: options
        }



        try{
            const response = await apiSpring.post('/guide/question', {
                questionComplete,
                id: comData.id,
            } );
            console.log(response.data)
        } catch(error) {
            console.error(error)
        }
        
        
    }


    return(
        < >
        <div 
        className="flex 
        flex-row 
        w-screen 
        h-screen 
        items-center 
        align-middle 
        justify-center
        bg-slate-900
        "
        >

        
            <Link to={"/"}>
            <House className="text-white bg-slate-950 h-full "/>    
            </Link>


            <aside 
            className="
            w-1/4 
            h-1/2 
            bg-slate-600 
            border border-slate-600 rounded-tl-xl rounded-bl-xl 
            flex 
            text-center items-center justify-center ">

                <h1 
                className="text-white font-bold font-RadioCanada text-3xl ">
                    Create Question
                </h1>

            </aside>

          <article className="w-2/3 h-1/2 bg-slate-500 border border-slate-600 rounded-tr-xl rounded-br-xl overflow-auto flex flex-col items-center justify-center">
                
                      <form className="  flex flex-col w-full h-full border-slate-600 items-center justify-start" id="questionSubmit" onSubmit={handleSubmit}>

               <input 
               type="text" 
               name="topic"
               placeholder="topic" 
               
               className=" 
               bg-slate-700
               font-RadioCanada
             text-white 
             rounded 
             h-15 w-4/5 m-2 
             text-xl 
             p-2 " 
                onChange={handleChange}
               />         
              <textarea 
              placeholder="Question content" 
              name="content" 
              id="QuestionContent" 
              className="bg-slate-300 rounded w-4/5 resize-none p-1 m-3 "
              onChange={handleChange}
              />

        <div className=" w-full flex flex-row items-center justify-center">
    
                    <label 
                    htmlFor="A" 
                    className="border border-spacing-10 border-white p-3 rounded-full w-5 h-5 text-center flex align-middle justify-center items-center font-mono text-white">
                        A
                        </label>
    
                    <input 
                    type="text" 

                    name="A" 
                    id="A"
                    className="bg-slate-700 m-2 rounded-lg h-7 w-4/5 p-2 font-mono text-white " 

                    onChange={handleChangeOpt}
                    />

            <input type="checkbox" name="A" id="A" onChange={handleChangeOpt} />

</div>

                <div className=" w-full flex flex-row items-center justify-center">

                    <label 
                    htmlFor="B" 

                    className="border border-spacing-10 border-white p-3 rounded-full w-5 h-5 text-center flex align-middle justify-center items-center font-mono text-white ">
                        B
                    </label>

                    <input 
                    type="text" 

                    name="B" 

                    className="bg-slate-700 m-2 rounded-lg h-7 w-4/5 text-white  p-2 "


                    onChange={handleChangeOpt}
                    />

            <input type="checkbox" name="B" id="B" onChange={handleChangeOpt}/>
                </div>


                <div className=" w-full flex flex-row items-center justify-center">

                    <label 
                    htmlFor="C" 
                    className="border border-spacing-10 border-white p-3 rounded-full w-5 h-5 text-center flex align-middle justify-center items-center font-mono text-white ">
                        C
                    </label>
                    <input 
                    type="text" 

                    name="C" 

                    className="bg-slate-700 m-2 rounded-lg h-7 w-4/5 text-white  p-2 "


                    onChange={handleChangeOpt}
                    />

            <input type="checkbox" name="C" id="C" onChange={handleChangeOpt} />
                </div>


                <div className=" w-full flex flex-row items-center justify-center">
                    <label 
                    htmlFor="D" 
                    className="border border-spacing-10 border-white p-3 rounded-full w-5 h-5 text-center flex align-middle justify-center items-center font-mono text-white ">
                        D
                        </label>
                    <input 
                    type="text" 
                    
                    name="D" 
                    
                    className="bg-slate-700 m-2 rounded-lg h-7 w-4/5 text-white  p-2 "
                    


                    onChange={handleChangeOpt}
                    />

            <input type="checkbox" name="D" id="D" onChange={handleChangeOpt}/>
                </div>


                <div className=" w-full flex flex-row items-center justify-center">
                    <label 
                    
                    htmlFor="E" 
                
                    className="border border-spacing-10 border-white p-3 rounded-full w-5 h-5 text-center flex align-middle justify-center items-center font-mono text-white ">
                        E
                    </label>
                    <input 
                    type="text" 
                    
                    name="E" 
                    className="bg-slate-700 m-2 rounded-lg h-7 w-4/5 text-white  p-2"
                    

                    onChange={handleChangeOpt}
                    />
                    
                            <input type="checkbox" name="E" id="E" onChange={handleChangeOpt}/>
                </div>
                    <button 
                    className="bg-blue-400 px-5 py-2 rounded-xl font-semibold text-lg " 
                    type="submit">
                        Submit Question
                    </button>

                      </form>

          </article>

        </div>

        </>
    )
}