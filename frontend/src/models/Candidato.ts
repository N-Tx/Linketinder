import { User } from "./User";

export class Candidato extends User {
    constructor(
        nome: string,
        email: string,
        public idade: number,
        estado: string,
        cep: number,
        descricao: string,
        skills: string[]
    ) {
        super(nome, email, estado, cep, descricao, skills);
    }
}