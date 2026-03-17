import { User } from "./User";

export class Empresa extends User {
    constructor(
        nome: string,
        email: string,
        public cnpj: string,
        estado: string,
        cep: number,
        descricao: string,
        skills: string[]
    ) {
        super(nome, email, estado, cep, descricao, skills);
    }
}