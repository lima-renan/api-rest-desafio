package com.desafio.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocsController {

    @GetMapping("/docs")
    @ResponseBody
    public String docs() {
        return """
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <title>Documentação da API</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #ffffff;
                        margin: 0;
                        padding: 20px;
                    }
                    h1 {
                        color: #2c3e50;
                    }
                    h2 {
                        color: #34495e;
                    }
                    p, li {
                        color: #555;
                        font-size: 16px;
                    }
                    ul {
                        list-style-type: none;
                        padding: 0;
                    }
                    li {
                        margin: 10px 0;
                    }
                    .endpoint {
                        background-color: #ecf0f1;
                        padding: 10px;
                        border-radius: 5px;
                        margin-bottom: 10px;
                    }
                    a {
                        text-decoration: none;
                        color: #3498db;
                    }
                </style>
            </head>
            <body>
                <h1>Documentação da API</h1>
                <p>Bem-vindo à documentação da API da Empresa de Vendas Online.</p>

                <h2>Endpoints Disponíveis:</h2>
                <ul>
                    <li class="endpoint">
                        <strong>GET /</strong> - Página inicial da API.
                    </li>
                    <li class="endpoint">
                        <strong>GET /docs</strong> - Esta documentação de endpoints.
                    </li>
                    <li class="endpoint">
                        <strong>GET /customers</strong> - Listar todos os clientes.
                    </li>
                    <li class="endpoint">
                        <strong>POST /customers</strong> - Criar um novo cliente.
                    </li>
                    <li class="endpoint">
                        <strong>GET /customers/{id}</strong> - Buscar cliente por ID.
                    </li>
                    <li class="endpoint">
                        <strong>PUT /customers/{id}</strong> - Atualizar cliente por ID.
                    </li>
                    <li class="endpoint">
                        <strong>DELETE /customers/{id}</strong> - Deletar cliente por ID.
                    </li>
                </ul>

                <p>Para mais informações ou dúvidas, entre em contato com o time de integração.</p>

                <footer style="margin-top: 30px; font-size: 14px; color: #aaa;">
                    © 2025 Empresa de Vendas Online - Integrações API
                </footer>
            </body>
            </html>
        """;
    }
}
