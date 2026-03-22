
export const RegexPadroes = {
    email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
    cpf: /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/,
    cnpj: /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}$/,
    telefone: /^\(?\d{2}\)?\s?\d{4,5}-?\d{4}$/,
    cep: /^\d{5}-?\d{3}$/,
    linkedin: /^https:\/\/(www\.)?linkedin\.com\/in\/[a-z0-9_-]+\/?$/i
};