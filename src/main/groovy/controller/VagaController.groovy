package controller

import model.Vaga
import service.VagaService

class VagaController {
    private VagaService vagaService

    VagaController(VagaService service) {
        this.vagaService = service
    }

    void cadastrarVaga(Vaga vaga) {
        vagaService.cadastrarVaga(vaga)
    }

    List<Vaga> listar() {
        return vagaService.buscarVagas()
    }
}