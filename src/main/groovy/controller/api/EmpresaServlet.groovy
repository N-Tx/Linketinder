package controller.api

import dao.EmpresaDAO
import model.Enterprise
import service.EmpresaService
import com.google.gson.Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/empresas")
class EmpresaServlet extends HttpServlet {

    private EmpresaService empresaService
    private Gson gson = new Gson()

    @Override
    void init() {
        this.empresaService = new EmpresaService(new EmpresaDAO())
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Enterprise novaEmpresa = gson.fromJson(req.getReader(), Enterprise)

        empresaService.cadastrarEmpresa(novaEmpresa)

        resp.setStatus(HttpServletResponse.SC_CREATED)
        resp.setContentType("application/json")
        resp.setCharacterEncoding("UTF-8")

        resp.getWriter().write(gson.toJson([mensagem: "Empresa cadastrada com sucesso!"]))
    }
}