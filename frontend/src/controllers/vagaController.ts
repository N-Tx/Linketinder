export function cadastrarVaga(event: Event) {
    event.preventDefault(); 

    const titulo = (document.getElementById("titulo") as HTMLInputElement).value;
    const descricao = (document.getElementById("descricao") as HTMLInputElement).value;
  
    const skills = (document.getElementById("skills") as HTMLInputElement).value.split(",");

    const novaVaga = {
        id: Date.now(),
        titulo,
        descricao,
        skills: skills.map(skill => skill.trim()) // trim() tira espaços em branco sobrando
    };

    
    const vagasSalvas = JSON.parse(localStorage.getItem("vagas") || "[]");
    
    
    vagasSalvas.push(novaVaga);
    
    
    localStorage.setItem("vagas", JSON.stringify(vagasSalvas));

    alert("Vaga cadastrada com sucesso!");
    
    // Limpa o formulário para o próximo cadastro
    (event.target as HTMLFormElement).reset(); 
}