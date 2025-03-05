import { ChangeEvent, useEffect, useState } from "react";
import { apiSpring } from "../Services/api";
import Header from "../Components/Header";
import Question from "../Interfaces/Question";
import QuestionComp from "../Components/Question";
import { Link } from "react-router-dom";

export const CommunityUrl = "/community";

export default function Home() {
  const [content, setContent] = useState("");
  const [questions, setResponse] = useState<Question[]>([]);
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleChange = (e: ChangeEvent<HTMLInputElement>): void => {
    setContent(e.target.value);
  };

  const handleClick = async () => {
    setLoading(true);

    try {
      const response = await apiSpring.get(`/api/questions/${content}`);
      setResponse(response.data);
    } catch (error) {
      console.error(error);
      setError(true);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    if (questions) {
      console.log(questions);
    }
  }, [questions]);

  return (
    <>
      <div
        className="bg-slate-50
        h-screen "
      >
        <Header handleChange={handleChange} handleSearch={handleClick} />

        {loading && <div>Carregando...</div>}
        {error && <div>Erro encontrado :/</div>}
        {questions.length > 0 &&
          questions != null &&
          questions?.map((q) => (
            <Link to={`/${q.id}`} state={{ q }}>
              <QuestionComp
                id={q.id}
                content={q.content}
                topic={q.topic}
                Answers={q.Answers}
              />
            </Link>
          ))}
      </div>
    </>
  );
}
