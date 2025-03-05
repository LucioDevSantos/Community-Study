
import { apiSpring } from "../Services/api";


const useValidateParams = async (id: number)=>{

     const response = await apiSpring.get(`/community/${id}`)


     return response
}

export default useValidateParams


