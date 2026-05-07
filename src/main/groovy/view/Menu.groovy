package view

import controller.MenuController
import model.*
import service.CadastroService

class Menu {

    Scanner scanner = new Scanner(System.in)
    MenuController controller

    Menu(CadastroService service) {
        this.controller = new MenuController(service)
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

    // --- MÉTODOS DE EXIBIÇÃO ---

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

    // --- MÉTODOS DE ENTRADA DE DADOS ---

    void telaCadastroCandidato() {
        println "\n--- CADASTRO DE CANDIDATO ---"
        println "Nome:"
        String nome = scanner.nextLine()
        println "Sobrenome:"
        String sobrenome = scanner.nextLine()
        println "Email:"
        String email = scanner.nextLine()
        println "CPF:"
        String cpf = scanner.nextLine()
        println "Data nascimento:"
        String data_nasc = scanner.nextLine()
        println "Telefone:"
        String telefone = scanner.nextLine()
        println "País"
        String pais = scanner.nextLine()
        println "CEP"
        String cep = scanner.nextLine()



        User novo = new User(nome: nome, sobrenome: sobrenome, email: email, cpf: cpf, data_nascimento: data_nasc, telefone: telefone, pais: pais, cep: cep)
        controller.cadastrarUsuario(novo)
        println "Candidato cadastrado com sucesso!"
    }

    void telaCadastroEmpresa() {
        println "\n--- CADASTRO DE EMPRESA ---"
        println "Nome da Empresa:"
        String nome = scanner.nextLine()
        println "CNPJ:"
        String cnpj = scanner.nextLine()
        println "Descrição:"
        String desc = scanner.nextLine()

        Enterprise nova = new Enterprise(nome: nome, cnpj: cnpj, descricao: desc, telefone: telefone, pais: pais, cep: cep, desc:descricao )
        controller.cadastrarEmpresa(nova)
        println "Empresa cadastrada com sucesso!"
    }

    void telaCadastroVaga() {
        println "\n--- CADASTRO DE VAGA ---"
        println "Nome da Vaga:"
        String nome = scanner.nextLine()
        println "Descrição:"
        String desc = scanner.nextLine()
        println "ID da Empresa:"
        int idEmp = scanner.nextLine().toInteger()

        Vaga vaga = new Vaga(nome: nome, descricao: desc, idEmpresa: idEmp)
        controller.cadastrarVaga(vaga)
        println "Vaga cadastrada!"
    }

    void telaCadastroCompetencia() {
        println "\n--- NOVA COMPETÊNCIA ---"
        println "Nome da Competência:"
        String nome = scanner.nextLine()

        Competencia comp = new Competencia(nome: nome)
        controller.cadastrarCompetencia(comp)
        println "Competência salva!"
    }
}