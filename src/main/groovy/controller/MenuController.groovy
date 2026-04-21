
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
    }
    void CadastroUser() {

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

        println "Idade:"
        def idade = scanner.nextInt()
        scanner.nextLine() // limpa buffer

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
                //falta senha
        )

        service.cadastrarUsuario(novoUsuario)

        println "Candidato cadastrado com sucesso!"
    }
    void cadastroVaga() {
        println "\n=== CADASTRO DE VAGA ==="

        println "Nome da Vaga (Ex: Desenvolvedor Backend):"
        def nome = scanner.nextLine()

        println "Descrição da Vaga:"
        def descricao = scanner.nextLine()


        println "Digite o ID da Empresa dona desta vaga (Verifique o ID lá no pgAdmin):"
        def idEmpresa = scanner.nextInt()
        scanner.nextLine()

        def novaVagaComIdEmpresa = new Vaga(
                nome: nome,
                descricao: descricao,
                idEmpresa: idEmpresa
        )

        service.cadastrarVaga(novaVagaComIdEmpresa)

        println "Vaga cadastrada com sucesso para a empresa ID ${idEmpresa}!"
    }
    void cadastrarCompetenciaManual() {
        println "\n=== CADASTRO DE COMPETÊNCIA ==="
        println "Nome da competência (ex: Java, Python, SQL):"
        def nome = scanner.nextLine()

        // adicionar verificador de competencia se existir.

        def novaCompetencia = new Competencia(nome: nome)
        service.salvarCompetencia(novaCompetencia)

        println  "Competência guardada com sucesso!"
    }

}