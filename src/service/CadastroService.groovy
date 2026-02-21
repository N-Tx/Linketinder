package service

import model.User
import model.Enterprise
import model.MatchCandidato
import model.MatchEmpresa

class CadastroService {

    List<User> users = []
    List<Enterprise> enterprises = []


    List<Enterprise> matchesCandidato = []
    List<User> matchesEmpresa = []


    void cadastrar(){

        users << new User(
                nome: "Nathan",
                email: "nathan@gmail.com",
                cpf: "1113333333",
                idade: 34,
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de uma vaga backend",
                skills: ["Java", "Spring Boot", "MySQL"]
        )

        users << new User(
                nome: "João",
                email: "joao@gmail.com",
                cpf: "2223333333",
                idade: 24,
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura uma vaga para trabalho backend",
                skills: ["C#", "Ruby", "Docker"]
        )

        users << new User(
                nome: "Maria",
                email: "maria@gmail.com",
                cpf: "33333333",
                idade: 44,
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de uma vaga Junior front end",
                skills: ["HTML", "CSS", "JavaScript"]
        )

        users << new User(
                nome: "Ana",
                email: "ana@gmail.com",
                cpf: "444333333",
                idade: 18,
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de uma vaga de analise de dados",
                skills: ["Python", "Django", "PostgreSQL"]
        )

        users << new User(
                nome: "Carlos",
                email: "carlos@gmail.com",
                cpf: "555656",
                idade: 19,
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de estágio para desenvolvimento mobile",
                skills: ["Kotlin", "Android", "Firebase"]
        )

        enterprises << new Enterprise(
                nome: "Tech LTDA",
                email: "contato@tech.com",
                cnpj: "1000",
                pais: "Brasil",
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de estagiarios motivados para trabalho backend",
                skills: ["Java", "AWS", "Microservices"]
        )

        enterprises << new Enterprise(
                nome: "DevCorp",
                email: "contato@dev.com",
                cnpj: "2000",
                pais: "Brasil",
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de estagiarios motivados para trabalho frontend",
                skills: ["React", "Node.js", "MongoDB"]
        )

        enterprises << new Enterprise(
                nome: "CodeX",
                email: "contato@codex.com",
                cnpj: "3000",
                pais: "Brasil",
                estado: "São paulo",
                cep: "2660-2001",
                descricao: "A procura de DEV Junior para vaga de analise de dados",
                skills: ["Python", "Machine Learning", "Docker"]
        )

        enterprises << new Enterprise(
                nome: "SoftBR",
                email: "contato@softbr.com",
                cnpj: "4000",
                pais: "Brasil",
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de um Pleno com boas softskills",
                skills: ["C#", ".NET", "Azure"]
        )

        enterprises << new Enterprise(
                nome: "CloudSys",
                email: "contato@cloud.com",
                cnpj: "5000",
                pais: "Brasil",
                estado: "Rio de Janeiro",
                cep: "2660-2001",
                descricao: "A procura de estagiarios para area de frontend",
                skills: ["DevOps", "Kubernetes", "Terraform"]
        )
    }
}