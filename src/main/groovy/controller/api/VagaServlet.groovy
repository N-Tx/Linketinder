package controller.api

import dao.VagaDAO
import model.Vaga
import service.VagaService
import com.google.gson.Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/vagas")
class VagaServlet extends HttpServlet {

    private VagaService vagaService
    private Gson gson = new Gson()

    @Override
    void init() {
        this.vagaService = new VagaService(new VagaDAO())
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Vaga novaVaga = gson.fromJson(req.getReader(), Vaga)

        vagaService.cadastrarVaga(novaVaga)

        resp.setStatus(HttpServletResponse.SC_CREATED)
        resp.setContentType("application/json")
        resp.setCharacterEncoding("UTF-8")

        resp.getWriter().write(gson.toJson([mensagem: "Vaga criada com sucesso!"]))
    }
}