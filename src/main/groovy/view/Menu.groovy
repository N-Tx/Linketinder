package view


import controller.MenuController
import service.CadastroService

class Menu {

    Scanner scanner = new Scanner(System.in)
    CadastroService service
    MenuController controller


    Menu(CadastroService service) {
        this.service = service
        this.controller = new MenuController(service, scanner)
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
            println "7. Adicionar Vaga"
            println "8. Adicionar Competência (Manual)"
            println "9. Listar Competências"
            println "0. Sair"
            println "==========================="

            def opcaoMenu = scanner.nextInt()
            scanner.nextLine()

            switch (opcaoMenu){
                case 1:
                    println "##################"
                    println "Área do candidato"
                    println "##################"
                    visualizarEmpresas() // refazer area de candidato
                    break
                case 2:
                    println "#################x"
                    println "Área da empresa"
                    println "#################"
                    println()
                    visualizarCandidatos()  // refazer area de empresa

                    break
                case 3:
                    controller.listarEmpresa()
                    break
                case 4:
                    controller.listarCandidato()
                    break
                case 5:
                    controller.CadastroUser()
                    break
                case 6:
                    controller.CadastroEnterprise()
                    break
                case 7:
                    controller.cadastroVaga()
                    break
                case 8:
                    controller.cadastrarCompetenciaManual()
                    break
                case 9:
                    controller.listarCompetencias()
                    break
                case 0:
                    return
            }
        }
    }


}




