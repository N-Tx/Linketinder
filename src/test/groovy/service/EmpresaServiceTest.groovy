package service

import model.Enterprise
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.mockito.Mockito.*

import dao.EmpresaDAO

class EmpresaServiceTest {

    EmpresaService service
    EmpresaDAO empresaDAOMock

    @BeforeEach
    void setup() {
        empresaDAOMock = mock(EmpresaDAO)
        service = new EmpresaService(empresaDAOMock)
    }

    @Test
    void deveCadastrarEmpresa() {
        def empresa = new Enterprise(
                nome: "Pastelsoft",
                email: "pastel@gmail.com",
                cnpj: "10000323"
        )

        service.cadastrarEmpresa(empresa)

        verify(empresaDAOMock, times(1)).salvar(empresa)
    }

    @Test
    void deveListarEmpresas() {
        def listaMock = [new Enterprise(nome: "Empresa X")]
        when(empresaDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarEmpresas()

        assert resultado.size() == 1
        assert resultado[0].nome == "Empresa X"
    }
}