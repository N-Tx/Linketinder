import { User } from './User';

export class Empresa extends User {
    public cnpj: string;

    constructor(
        nome: string,
        email: string,
        cnpj: string,
        estado: string,
        cep: number,
        descricao: string,
        skills: string
    ) {
        super(nome, email, estado, cep, descricao, skills);
        this.cnpj = cnpj;
    }
}