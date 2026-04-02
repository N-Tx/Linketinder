package service

import model.Enterprise
import model.User

import java.util.Scanner

class Menu {


    Scanner scanner = new Scanner(System.in)
    CadastroService service

    Menu(CadastroService service) {
        this.service = service
    }

    void iniciar() {
        while (true){

            println "==========================="
            println "Bem-vindo ao Linketinder"
            println "==========================="

            println "1. Candidato"
            println "2. Empresa"
            println "3. Listar empresas"
            println "4. Listar candidatos"
            println "5. Adicionar candidato"
            println "6. Adicionar empresa"
            println "0. Sair"
            println "==========================="

            def opc = scanner.nextInt()
            scanner.nextLine()

            switch (opc){
                case 1:
                    println "##################"
                    println "Área do candidato"
                    println "##################"
                    visualizarEmpresas()
                    break
                case 2:
                    println "#################x"
                    println "Área da empresa"
                    println "#################"
                    println()
                    visualizarCandidatos()

                    break
                case 3:
                    listAllEmpresas()
                    break
                case 4:
                    listAllCandidato()
                    break
                case 5:
                    CadastroUser()
                    break
                case 6:
                    CadastroEnterprise()
                    break
                case 0:
                    return
            }
        }
    }

    void listAllEmpresas() {
        service.enterprises.each {
            println it.nome

        }
    }

    void listAllCandidato(){
        service.users.each {
            println it.getNome()
        }

    }

    void visualizarEmpresas() {

        if (service.enterprises.isEmpty()) {
            println "Nenhuma empresa cadastrada."
            return
        }

        int index = 0

        while (index < service.enterprises.size()) {

            def empresa = service.enterprises[index]

            println "\n===== EMPRESA ${index + 1} ====="
            println "Nome: ${empresa.nome}"
            println "Email: ${empresa.email}"
            println "CNPJ: ${empresa.cnpj}"
            println "Pais: ${empresa.pais}"
            println "Estado: ${empresa.estado}"
            println "Cep: ${empresa.cep}"
            println "Descrição: ${empresa.descricao}"
            println "Skills desejadas: ${empresa.skills}"

            println "\nPressione 1 para dar match ou 2 para passar"
            def entrada = scanner.nextLine()

            if (entrada == "1") {
                service.matchesCandidato << empresa
                println "✅ Match realizado!"

            index++
        }
    }
    }
    void visualizarCandidatos() {

        if (service.users.isEmpty()) {
            println "Nenhum candidato cadastrado."
            return
        }

        int index = 0

        while (index < service.users.size()) {

            def user = service.users[index]

            println "\n===== CANDIDATO ${index + 1} ====="
            println "Nome: ${user.nome}"
            println "Email: ${user.email}"
            println "CPF: ${user.cpf}"
            println "Idade: ${user.idade}"
            println "CEP: ${user.cep}"
            println "Descrição: ${user.descricao}"
            println "Skills: ${user.skills}"

            println "\nPressione 1 para dar match ou 2 para passar"
            def entrada = scanner.nextLine()

            if (entrada == "1") {
                service.matchesEmpresa << user
                println "✅ Match realizado!"
            }

            index++
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

}


