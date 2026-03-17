export function cadastrarVaga(event: Event) {
    event.preventDefault(); // Impede a página de recarregar e dar erro

    const titulo = (document.getElementById("titulo") as HTMLInputElement).value;
    const descricao = (document.getElementById("descricao") as HTMLInputElement).value;
    // Pegando as skills e separando por vírgula
    const skills = (document.getElementById("skills") as HTMLInputElement).value.split(",");

    const novaVaga = {
        id: Date.now(),
        titulo,
        descricao,
        skills: skills.map(skill => skill.trim()) // trim() tira espaços em branco sobrando
    };

    // Pega as vagas salvas no navegador (ou cria uma lista vazia se não tiver)
    const vagasSalvas = JSON.parse(localStorage.getItem("vagas") || "[]");
    
    // Adiciona a vaga nova na lista
    vagasSalvas.push(novaVaga);
    
    // Salva a lista atualizada de volta no navegador
    localStorage.setItem("vagas", JSON.stringify(vagasSalvas));

    alert("Vaga cadastrada com sucesso!");
    
    // Limpa o formulário para o próximo cadastro
    (event.target as HTMLFormElement).reset(); 
}