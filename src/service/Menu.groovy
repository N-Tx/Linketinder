package service

import java.util.Scanner

class Menu {

    CadastroService service
    Scanner scanner = new Scanner(System.in)

    // CONSTRUTOR OBRIGATÓRIO
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
                    break
                case 3:
                    listAllEmpresas()
                    break
                case 4:
                    listAllCandidato()
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

}