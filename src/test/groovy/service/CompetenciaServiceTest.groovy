package service

import model.Competencia
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.mockito.Mockito.*

import dao.CompetenciaDAO

class CompetenciaServiceTest {

    CompetenciaService service
    CompetenciaDAO competenciaDAOMock

    @BeforeEach
    void setup() {
        competenciaDAOMock = mock(CompetenciaDAO)
        service = new CompetenciaService(competenciaDAOMock)
    }

    @Test
    void deveSalvarCompetencia() {
        def comp = new Competencia(nome: "TypeScript")

        service.salvarCompetencia(comp)

        verify(competenciaDAOMock, times(1)).salvar(comp)
    }

    @Test
    void deveListarCompetencias() {
        def listaMock = [] // Testando retorno de lista vazia
        when(competenciaDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarCompetencias()

        assert resultado.isEmpty()
    }
}