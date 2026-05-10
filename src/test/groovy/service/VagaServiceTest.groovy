package service

import model.Vaga
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.mockito.Mockito.*

import dao.VagaDAO

class VagaServiceTest {

    VagaService service
    VagaDAO vagaDAOMock

    @BeforeEach
    void setup() {
        vagaDAOMock = mock(VagaDAO)
        service = new VagaService(vagaDAOMock)
    }

    @Test
    void deveCadastrarVaga() {
        def vaga = new Vaga(
                nome: "Desenvolvedor Backend",
                descricao: "Vaga para Groovy/Java",
                idEmpresa: 1
        )

        service.cadastrarVaga(vaga)

        verify(vagaDAOMock, times(1)).salvar(vaga)
    }

    @Test
    void deveListarVagas() {
        def listaMock = [new Vaga(nome: "Desenvolvedor Backend", idEmpresa: 1)]
        when(vagaDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarVagas()

        assert resultado.size() == 1
        assert resultado[0].nome == "Desenvolvedor Backend"
    }
}