

interface CommunityModel {
    id: number,
    name: string,
    code: number,
    openQuestions: openQuestions[]
    questions: Question[]


}

type openQuestions = {
    id?: number,
    topic: string[]
    content: string
    answers?: string
}

type Question = {
    id?: number
    content: string,
    topic?: string,
    options: Option[]
}

type Option = {
    id?: number
    name?: string,
    content: string,
    isRight: boolean
}

export default CommunityModel



