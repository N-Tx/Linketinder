package view

import controller.MenuController
import model.*

class Menu {
    Scanner scanner = new Scanner(System.in)
    MenuController controller

    Menu(MenuController controller) {
        this.controller = controller
    }

    void iniciar() {
        while (true) {
            println "\n==========================="
            println "      LINKETINDER"
            println "==========================="
            println "1. Listar Empresas"
            println "2. Listar Candidatos"
            println "3. Listar Competências"
            println "4. Cadastrar Candidato"
            println "5. Cadastrar Empresa"
            println "6. Cadastrar Vaga"
            println "7. Cadastrar Competência"
            println "0. Sair"
            println "==========================="
            print "Escolha uma opção: "

            String opcao = scanner.nextLine()

            switch (opcao) {
                case "1": exibirEmpresas(); break
                case "2": exibirCandidatos(); break
                case "3": exibirCompetencias(); break
                case "4": telaCadastroCandidato(); break
                case "5": telaCadastroEmpresa(); break
                case "6": telaCadastroVaga(); break
                case "7": telaCadastroCompetencia(); break
                case "0": println "Saindo..."; return
                default: println "Opção inválida!"
            }
        }
    }

    void exibirCandidatos() {
        println "\n==== LISTA DE CANDIDATOS ===="
        List<User> lista = controller.listarCandidatos()
        if (lista.isEmpty()) {
            println "Nenhum candidato cadastrado."
        } else {
            lista.each { println "ID: ${it.id} | Nome: ${it.nome} ${it.sobrenome}" }
        }
    }

    void exibirEmpresas() {
        println "\n==== LISTA DE EMPRESAS ===="
        List<Enterprise> lista = controller.listarEmpresas()
        if (lista.isEmpty()) {
            println "Nenhuma empresa cadastrada."
        } else {
            lista.each { println "ID: ${it.id} | Nome: ${it.nome} | CNPJ: ${it.cnpj}" }
        }
    }

    void exibirCompetencias() {
        println "\n==== CATÁLOGO DE COMPETÊNCIAS ===="
        List<Competencia> lista = controller.listarCompetencias()
        if (lista.isEmpty()) {
            println "Nenhuma competência encontrada."
        } else {
            lista.each { println "ID: ${it.id} | Nome: ${it.nome}" }
        }
    }

    void telaCadastroCandidato() {
        println "\n--- CADASTRO DE CANDIDATO ---"
        print "Nome: "; String nome = scanner.nextLine()
        print "Sobrenome: "; String sobrenome = scanner.nextLine()
        print "Email: "; String email = scanner.nextLine()
        print "CPF: "; String cpf = scanner.nextLine()
        print "Data nascimento: "; String data_nasc = scanner.nextLine()
        print "Telefone: "; String telefone = scanner.nextLine()
        print "País: "; String pais = scanner.nextLine()
        print "CEP: "; String cep = scanner.nextLine()

        User novo = new User(nome: nome, sobrenome: sobrenome, email: email, cpf: cpf, data_nascimento: data_nasc, telefone: telefone, pais: pais, cep: cep)
        controller.cadastrarUsuario(novo)
        println "Candidato cadastrado com sucesso!"
    }

    void telaCadastroEmpresa() {
        println "\n--- CADASTRO DE EMPRESA ---"
        print "Nome da Empresa: "; String nome = scanner.nextLine()
        print "CNPJ: "; String cnpj = scanner.nextLine()
        print "Descrição: "; String desc = scanner.nextLine()
        print "Telefone: "; String telefone = scanner.nextLine()
        print "País: "; String pais = scanner.nextLine()
        print "CEP: "; String cep = scanner.nextLine()

        Enterprise nova = new Enterprise(nome: nome, cnpj: cnpj, descricao: desc, telefone: telefone, pais: pais, cep: cep)
        controller.cadastrarEmpresa(nova)
        println "Empresa cadastrada com sucesso!"
    }

    void telaCadastroVaga() {
        println "\n--- CADASTRO DE VAGA ---"
        print "Nome da Vaga: "; String nome = scanner.nextLine()
        print "Descrição: "; String desc = scanner.nextLine()
        print "ID da Empresa: "; int idEmp = scanner.nextLine().toInteger()

        Vaga vaga = new Vaga(nome: nome, descricao: desc, idEmpresa: idEmp)
        controller.cadastrarVaga(vaga)
        println "Vaga cadastrada!"
    }

    void telaCadastroCompetencia() {
        println "\n--- NOVA COMPETÊNCIA ---"
        print "Nome da Competência: "; String nome = scanner.nextLine()

        Competencia comp = new Competencia(nome: nome)
        controller.cadastrarCompetencia(comp)
        println "Competência salva!"
    }
}