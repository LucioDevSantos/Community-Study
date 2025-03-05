// import { Link } from "react-router-dom";
import "../index.css";
import "../styles/main.css";
import { ChangeEvent } from "react";

type CallBackProps = {
  handleChange: (e: ChangeEvent<HTMLInputElement>) => void;
  handleSearch: () => void;
};

export default function Header({ handleChange, handleSearch }: CallBackProps) {
  return (
    <>
      <nav className="w-full h-1/6 bg-blue-800  flex flex-row items-center justify-center">
        <input
          type="text"
          className="w-1/3 h-1/3 px-2 border-black border-2 border-r-0 rounded-sm rounded-r-none "
          onChange={handleChange}
        />
        <button
          className="bg-slate-100 h-1/3 px-2 border-black border-2 rounded rounded-l-none "
          onClick={handleSearch}
        >
          Search
        </button>
      </nav>
    </>
  );
}
