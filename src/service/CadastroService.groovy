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
                cpf: "111",
                skills: ["Java", "Spring Boot", "MySQL"]
        )

        users << new User(
                nome: "João",
                email: "joao@gmail.com",
                cpf: "222",
                skills: ["C#", "Ruby", "Docker"]
        )

        users << new User(
                nome: "Maria",
                email: "maria@gmail.com",
                cpf: "333",
                skills: ["HTML", "CSS", "JavaScript"]
        )

        users << new User(
                nome: "Ana",
                email: "ana@gmail.com",
                cpf: "444",
                skills: ["Python", "Django", "PostgreSQL"]
        )

        users << new User(
                nome: "Carlos",
                email: "carlos@gmail.com",
                cpf: "555",
                skills: ["Kotlin", "Android", "Firebase"]
        )

        enterprises << new Enterprise(
                nome: "Tech LTDA",
                email: "contato@tech.com",
                cnpj: "1000",
                skills: ["Java", "AWS", "Microservices"]
        )

        enterprises << new Enterprise(
                nome: "DevCorp",
                email: "contato@dev.com",
                cnpj: "2000",
                skills: ["React", "Node.js", "MongoDB"]
        )

        enterprises << new Enterprise(
                nome: "CodeX",
                email: "contato@codex.com",
                cnpj: "3000",
                skills: ["Python", "Machine Learning", "Docker"]
        )

        enterprises << new Enterprise(
                nome: "SoftBR",
                email: "contato@softbr.com",
                cnpj: "4000",
                skills: ["C#", ".NET", "Azure"]
        )

        enterprises << new Enterprise(
                nome: "CloudSys",
                email: "contato@cloud.com",
                cnpj: "5000",
                skills: ["DevOps", "Kubernetes", "Terraform"]
        )
    }
}