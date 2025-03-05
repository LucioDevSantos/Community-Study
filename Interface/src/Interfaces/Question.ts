type Question = {
  id?: number;
  content: string;
  topic: string;
  Answers?: Answers[];
};

type Answers = {
  id?: number;
  text: string;
  question_id?: number;
};

export default Question;
