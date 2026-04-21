
package controller

import model.Competencia
import model.Enterprise
import model.User
import model.Vaga
import service.CadastroService
import java.util.Scanner

class MenuController {

    CadastroService service
    Scanner scanner

    MenuController(CadastroService service, Scanner scanner) {
        this.service = service
        this.scanner = scanner
    }

    void listarCandidato() {
        println "\n==== Lista de candidatos ===="
        def lista = service.buscarUser()

        if (lista.isEmpty()) {
            println "Nenhuma competência cadastrada no banco."
        } else {
            lista.each {
                println "ID: ${it.id} | Nome: ${it.nome}"
            }
        }
    }
    void listarCompetencias() {
        println "\n=== CATÁLOGO DE COMPETÊNCIAS ==="
        def lista = service.buscarCompetencias()

        if (lista.isEmpty()) {
            println "Nenhum candidato cadastrada no banco."
        } else {
            lista.each {
                println "ID: ${it.id} | Nome: ${it.nome}"
            }
        }
    }
    void listarEmpresa() {
        println "\n==== Lista de Empresas ===="
        def lista = service.buscarEmpresa()

        if (lista.isEmpty()) {
            println "Nenhuma empresa cadastrada no banco."
        } else {
            lista.each {
                println "ID: ${it.id} | Nome: ${it.nome}"
            }
        }
    }
    void CadastroEnterprise() {
        try {
            println "Nome da empresa:"
            def nome = scanner.nextLine()

            println "Email:"
            def email = scanner.nextLine()

            println "Telefone:"
            def telefone = scanner.nextLine()

            println "CNPJ:"
            def cnpj = scanner.nextLine()

            println "País:"
            def pais = scanner.nextLine()

            println "Estado:"
            def estado = scanner.nextLine()

            println "CEP:"
            def cep = scanner.nextLine()

            println "Descrição:"
            def descricao = scanner.nextLine()

            println "Skills (separadas por vírgula):"
            def skillsInput = scanner.nextLine()
            def skills = skillsInput.split(",")*.trim()

            def novaEmpresa = new Enterprise(
                    nome: nome,
                    email: email,
                    cnpj: cnpj,
                    telefone: telefone,
                    pais: pais,
                    estado: estado,
                    cep: cep,
                    descricao: descricao,
                    skills: skills
            )

            service.cadastrarEmpresa(novaEmpresa)

            println "Empresa cadastrada com sucesso!"

        } catch (Exception e) {
            println "Erro ao cadastrar empresa: ${e.message}"
        }
    }

    void CadastroUser() {
        try {
            println "Nome do candidato:"
            def nome = scanner.nextLine()

            println "Sobrenome"
            def sobrenome = scanner.nextLine()

            println "CPF:"
            def cpf = scanner.nextLine()

            println "Email:"
            def email = scanner.nextLine()

            println "Telefone:"
            def telefone= scanner.nextLine()

            println "Data de nascimento (yyyy-mm-dd):"
            def data_nascimento= scanner.nextLine()

            println "País:"
            def pais= scanner.nextLine()

            int idade
            try {
                println "Idade:"
                idade = scanner.nextInt()
                scanner.nextLine()
            } catch (Exception e) {
                println "Idade inválida! Digite um número."
                scanner.nextLine()
                return
            }

            println "Estado:"
            def estado = scanner.nextLine()

            println "CEP:"
            def cep = scanner.nextLine()

            println "Descrição:"
            def descricao = scanner.nextLine()

            println "Skills (separadas por vírgula):"
            def skillsInput = scanner.nextLine()
            def skills = skillsInput.split(",")*.trim()

            def novoUsuario = new User(
                    nome: nome,
                    sobrenome: sobrenome,
                    email: email,
                    telefone: telefone,
                    data_nascimento: data_nascimento,
                    pais: pais,
                    cpf: cpf,
                    idade: idade,
                    estado: estado,
                    cep: cep,
                    descricao: descricao,
                    skills: skills
            )

            service.cadastrarUsuario(novoUsuario)

            println "Candidato cadastrado com sucesso!"

        } catch (Exception e) {
            println "Erro ao cadastrar usuário: ${e.message}"
        }
    }
    void cadastroVaga() {
        try {
            println "\n=== CADASTRO DE VAGA ==="

            println "Nome da Vaga:"
            def nome = scanner.nextLine()

            println "Descrição da Vaga:"
            def descricao = scanner.nextLine()

            int idEmpresa
            try {
                println "Digite o ID da Empresa:"
                idEmpresa = scanner.nextInt()
                scanner.nextLine()
            } catch (Exception e) {
                println "ID inválido! Digite um número."
                scanner.nextLine()
                return
            }

            def novaVaga = new Vaga(
                    nome: nome,
                    descricao: descricao,
                    idEmpresa: idEmpresa
            )

            service.cadastrarVaga(novaVaga)

            println "Vaga cadastrada com sucesso!"

        } catch (Exception e) {
            println "Erro ao cadastrar vaga: ${e.message}"
        }
    }

    void cadastrarCompetenciaManual() {
        try {
            println "\n=== CADASTRO DE COMPETÊNCIA ==="
            println "Nome da competência:"
            def nome = scanner.nextLine()

            def novaCompetencia = new Competencia(nome: nome)
            service.salvarCompetencia(novaCompetencia)

            println "Competência guardada com sucesso!"

        } catch (Exception e) {
            println "Erro ao cadastrar competência: ${e.message}"
        }
    }
}