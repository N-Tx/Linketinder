export abstract class User {
    constructor(
        public nome: string,
        public email: string,
        public estado: string,
        public cep: number,
        public descricao: string,
        public skills: string[]
    ) {}
}