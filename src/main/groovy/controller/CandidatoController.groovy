package controller

import model.User
import service.CandidatoService

class CandidatoController {

    private CandidatoService candidatoService

    CandidatoController(CandidatoService candidatoservice){
        this.candidatoService = candidatoservice
    }

    void cadastrar(User user) {
        candidatoService.cadastrarUsuario(user)
    }


    List<User> listar() {
        return candidatoService.buscarUsuarios()
    }
}