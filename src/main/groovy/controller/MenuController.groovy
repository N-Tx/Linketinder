
package controller

import model.Competencia
import model.Enterprise
import model.User
import model.Vaga
import service.CadastroService


class MenuController {

    CadastroService service
    Scanner scanner

    MenuController(CadastroService service, Scanner scanner) {
        this.service = service
        this.scanner = scanner
    }

    void listarCandidato() {
        println "\n==== Lista de candidatos ===="
        List<User> lista = service.buscarUser()

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
        List<Competencia> lista = service.buscarCompetencias()

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
        List<Enterprise> lista = service.buscarEmpresa()

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
            String nome = scanner.nextLine()

            println "Email:"
            String email = scanner.nextLine()

            println "Telefone:"
            String telefone = scanner.nextLine()

            println "CNPJ:"
            String cnpj = scanner.nextLine()

            println "País:"
            String pais = scanner.nextLine()

            println "Estado:"
            String estado = scanner.nextLine()

            println "CEP:"
            String cep = scanner.nextLine()

            println "Descrição:"
            String descricao = scanner.nextLine()

            println "Skills (separadas por vírgula):"
            String skillsInput = scanner.nextLine()
            List<String> skills = skillsInput.split(",")*.trim()

            Enterprise novaEmpresa = new Enterprise(
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
            String nome = scanner.nextLine()

            println "Sobrenome"
            String sobrenome = scanner.nextLine()

            println "CPF:"
            String cpf = scanner.nextLine()

            println "Email:"
            String email = scanner.nextLine()

            println "Telefone:"
            String telefone= scanner.nextLine()

            println "Data de nascimento (yyyy-mm-dd):"
            String data_nascimento= scanner.nextLine()

            println "País:"
            String pais= scanner.nextLine()

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
            String estado = scanner.nextLine()

            println "CEP:"
            String cep = scanner.nextLine()

            println "Descrição:"
            String descricao = scanner.nextLine()

            println "Skills (separadas por vírgula):"
            String skillsInput = scanner.nextLine()
            List<String> skills = skillsInput.split(",")*.trim()

            User novoUsuario = new User(
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
            String nome = scanner.nextLine()

            println "Descrição da Vaga:"
            String descricao = scanner.nextLine()

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

            Vaga novaVaga = new Vaga(
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
            String nome = scanner.nextLine()

            Competencia novaCompetencia = new Competencia(nome: nome)
            service.salvarCompetencia(novaCompetencia)

            println "Competência guardada com sucesso!"

        } catch (Exception e) {
            println "Erro ao cadastrar competência: ${e.message}"
        }
    }
}