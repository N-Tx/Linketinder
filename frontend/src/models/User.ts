export abstract class User {
    // 1. Primeiro declaramos as variáveis (propriedades)
    public nome: string;
    public email: string;
    public estado: string;
    public cep: number;
    public descricao: string;
    public skills: string;

    // 2. O construtor apenas recebe os valores e atribui com o 'this'
    constructor(
        nome: string, 
        email: string, 
        estado: string, 
        cep: number, 
        descricao: string, 
        skills: string
    ) {
        this.nome = nome;
        this.email = email;
        this.estado = estado;
        this.cep = cep;
        this.descricao = descricao;
        this.skills = skills;
    }
}