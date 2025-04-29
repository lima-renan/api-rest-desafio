package com.desafio.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
            <!DOCTYPE html>
            <html lang="pt-BR">
            <head>
                <meta charset="UTF-8">
                <title>Bem-vindo à Plataforma de Integração</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f2f2f2;
                        text-align: center;
                        padding: 50px;
                    }
                    h1 {
                        color: #333;
                    }
                    p {
                        color: #666;
                        font-size: 18px;
                    }
                    footer {
                        margin-top: 30px;
                        font-size: 14px;
                        color: #aaa;
                    }
                </style>
            </head>
            <body>
                <h1>Bem-vindo à API da Empresa de Vendas Online</h1>
                <p>Esta API permite o acesso seguro aos dados de clientes, pedidos e logística,<br/>
                integrando nossos serviços com parceiros de Marketing, Logística e muito mais.</p>
                <p><strong>Explore os nossos endpoints e conecte-se ao nosso ecossistema!</strong></p>
                <footer>© 2025 Empresa de Vendas Online - Todos os direitos reservados.</footer>
            </body>
            </html>
        """;
    }
}
