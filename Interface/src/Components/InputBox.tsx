import { ChangeEvent, FormEvent } from "react";
import "../index.css";
import { X } from "lucide-react";

// enum Typos {
//   ANSWER,
//   HELP,
//   MESSAGE,
// }

type props = {
  handleChange: (e: ChangeEvent<HTMLTextAreaElement>) => void;
  handleSubmit: (e: FormEvent<HTMLFormElement>) => void;
  handleClick: () => void;
};

export default function InputBox({
  handleChange,
  handleSubmit,
  handleClick,
}: props) {
  return (
    <>
      <form
        onSubmit={handleSubmit}
        className="bg-gray-800 w-2/6 h-3/6 rounded rounded-r-none rounded-b-none rounded-bl rounded-tr flex flex-col align-middle items-center"
      >
        <div className="w-full flex items-end ">
          <button onClick={handleClick}>
            <X />
          </button>
        </div>

        <textarea
          className="resize-none w-5/6 text-lg p-1 h-3/4 bg-gray-500 rounded font-normal"
          onChange={handleChange}
        ></textarea>
        <button
          type="submit"
          className="bg-blue-800 w-fit h-fit px-3 py-1 m-1 rounded text-lg font-medium "
        >
          Submit Answer
        </button>
      </form>
    </>
  );
}
