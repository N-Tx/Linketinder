package service

import model.User
import model.Enterprise
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

class CadastroServiceTest {

    CadastroService service

    @BeforeEach
    void setup() {
        service = new CadastroService()
    }

    @Test
    void deveCadastrarNovoUsuario() {
        int tamanhoInicial = service.users.size()

        def novoUser = new User(
                nome: "Pedro",
                email: "pedro@gmail.com",
                cpf: "999999",
                idade: 30,
                estado: "RJ",
                cep: "00000-000",
                descricao: "Backend developer",
                skills: ["Java", "Spring"]
        )

        service.cadastrarUsuario(novoUser)


        assertEquals(tamanhoInicial + 1, service.users.size())


        assertTrue(service.users.contains(novoUser))
    }


}