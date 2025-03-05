import { ChangeEvent, FormEvent, useState } from "react";
import "../index.css";
// import Header from "../Components/Header.tsx";
import { useLocation } from "react-router-dom";
import InputBox from "../Components/InputBox";
import { apiSpring } from "../Services/api";

export default function QuestionDetail() {
  const [box, setBox] = useState(false);
  const [answer, setAnswer] = useState("");

  const location = useLocation();

  const question = location.state?.q;
  const topics = question.topic.split(" ");

  // Handlers
  const handleChange = (e: ChangeEvent<HTMLTextAreaElement>): void => {
    setAnswer(e.target.value);
  };
  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    const response = await apiSpring.post(
      `/api/question/${question.id}/answer`,
      {
        text: answer,
      },
    );

    setBox(false)



    console.log(response.data);

    const regAnswer = response.data.answers.text;
    console.log(regAnswer);
  };
  const handleExitClick = () => {
    setBox(false);
  };

  return (
    <>
      <div className="bg-slate-50 flex flex-col">
        <h2 className="flex flex-row bg-blue-900 h-1/6 p-2 text-center items-center">
          <h1 className="text-2xl font-semibold">Topics</h1>
          {topics.map((t: string) => (
            <h2 className="bg-slate-100 p-1 font-semibold w-fit flex flex-row m-2 rounded">
              {t}
            </h2>
          ))}
        </h2>
        <h1 className="text-lg font-medium flex align-middle p-3 h-screen w-full">
          {question.content}

          {box && (
            <InputBox
              handleChange={handleChange}
              handleSubmit={handleSubmit}
              handleClick={handleExitClick}
            />
          )}
          <button
            onClick={() => {
              setBox(true);
            }}
          >
            Add Answer
          </button>
        </h1>
      </div>
    </>
  );
}
