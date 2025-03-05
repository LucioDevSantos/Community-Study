import "../index.css"
import Header from "../Components/Header.tsx"
import { useEffect, useState } from "react"
import { apiSpring } from "../Services/api.ts";
import Question from "../Components/Question.js";
// import { useParams } from "react-router-dom";
type Option = {
    id: number;
    name: string;
    content: string;
    isRight: boolean;
    questions: string;
}

type Question = {
    id: number;
    topic: string;
    content: string;
    optionsList: Array<Option>;
    community_id: number;
}




export default function Questions(){

    const [questions, setQuestions] = useState<Question[]>([]);



    useEffect(()=>{
        getQuestions()
    }, [])

    async function getQuestions() {
        const response = await apiSpring.get('/guide/questions');
        
        setQuestions(response.data)
        console.log(response.data)


    }


    return(
        <>
        <Header/>
<div className="flex flex-col items-center bg-slate-900">
    
            {questions.map((question)=>{
                
                return(
                        <Question
                            key={question.id}
                            topic={question.topic}
                            content={question.content} id={question.id} options={question.optionsList} 
                            community_id={question.community_id}                
                         />
                    )
                    }
            )}
</div>

            



      
        </>
    )
}