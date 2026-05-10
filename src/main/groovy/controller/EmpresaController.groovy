package controller

import model.Enterprise
import service.EmpresaService

class EmpresaController {
    private EmpresaService empresaService

    EmpresaController(EmpresaService service) {
        this.empresaService = service
    }

    void cadastrar(Enterprise enterprise) {
        empresaService.cadastrarEmpresa(enterprise)
    }

    List<Enterprise> listar() {
        return empresaService.buscarEmpresas()
    }
}