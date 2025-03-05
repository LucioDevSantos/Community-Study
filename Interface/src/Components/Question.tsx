import "../index.css";
import Question from "../Interfaces/Question";

export default function QuestionComp(prop: Question) {
  const topics = prop.topic.split(" ");

  return (
    <>
      <div key={prop.id} className="w-5/6 h-min bg-slate-400 rounded-lg m-5">
        <div className="bg-slate-600 font-semibold rounded-tr-lg rounded-tl-lg h-1/5 flex flex-row">
          {topics.map((topi) => {
            return <p className="m-2 bg-slate-50 h-fit p-1 rounded">{topi}</p>;
          })}
        </div>
        <div className="">
          <h2 className="m-2 font-semibold">{prop.content}</h2>
        </div>

        <div className="flex flex-col ">
          {prop.Answers?.map((opt) => (
            <div key={opt.id}>
              <div>{opt.text}</div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}
