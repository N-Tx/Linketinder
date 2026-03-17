import { Empresa } from "../models/Empresa";
// dbFake não é mais estritamente necessário se usarmos localStorage, mas vamos manter a lógica

export function cadastrarEmpresa(event: Event) {
    event.preventDefault(); // Impede o recarregamento da página

    const nome = (document.getElementById("nome") as HTMLInputElement).value;
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const cnpj = (document.getElementById("cnpj") as HTMLInputElement).value;
    const estado = (document.getElementById("estado") as HTMLInputElement).value;
    const cep = Number((document.getElementById("cep") as HTMLInputElement).value);
    const descricao = (document.getElementById("descricao") as HTMLInputElement).value;
    const skills = (document.getElementById("skills") as HTMLInputElement).value.split(",");

    const nova = new Empresa(nome, email, cnpj, estado, cep, descricao, skills);

    // Pega as empresas que já existem no navegador (ou cria um array vazio)
    const empresasSalvas = JSON.parse(localStorage.getItem("empresas") || "[]");
    empresasSalvas.push(nova);
    
    // Salva o array atualizado de volta no navegador
    localStorage.setItem("empresas", JSON.stringify(empresasSalvas));

    alert("Empresa cadastrada com sucesso!");
    (event.target as HTMLFormElement).reset(); // Limpa o formulário
}