import { apiSpring } from "../Services/api"


const useAddAnswer = async (questionId: number) => {
    const response = await apiSpring.post(`/answer/${questionId}`)

    return response.data.name
}

export default useAddAnswer