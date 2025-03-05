import { ChangeEvent, FormEvent, useState } from "react";
import { apiSpring } from "../../Services/api";
import { CommunityUrl } from "../Home";
import { useNavigate } from "react-router-dom";

type CommunityInput = {
  name: string;
};

export default function CommunityCreate() {
  const [community, setCommunity] = useState<CommunityInput | null>(null);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(false);

  const handleChange = (e: ChangeEvent<HTMLInputElement>): void => {
    setCommunity({ ...community, name: e.target.value });
    console.log(community);
  };

  const navigate = useNavigate();

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    setLoading(true);

    try {
      const HTTPresponse = await apiSpring.post(
        `${CommunityUrl}/create`,
        community,
      );

      console.log(HTTPresponse.data.id);
      const comData = HTTPresponse.data;

      navigate(`/community/${HTTPresponse.data.code}`, { state: comData });
    } catch (err) {
      setError(err instanceof Error ? err.message : "unknownn error");
    } finally {
      setLoading(false);
    }
  };

  if (error) {
    return (
      <>
        <p>{error}</p>
      </>
    );
  }
  if (loading) {
    return (
      <>
        <h3>Loading...</h3>
      </>
    );
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <input type="text" onChange={handleChange} />

        <button>Create community</button>
      </form>
    </>
  );
}
