import { User } from './User';

export class Candidato extends User {
    public idade: number; // Declarado fora

    constructor(
        nome: string,
        email: string,
        idade: number,
        estado: string,
        cep: number,
        descricao: string,
        skills: string
    ) {
        // 1. Passa os dados para o pai (User)
        super(nome, email, estado, cep, descricao, skills);
        
        // 2. Atribui a idade manualmente
        this.idade = idade;
    }
}