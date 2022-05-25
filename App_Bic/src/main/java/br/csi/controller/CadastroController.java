package br.csi.controller;

import br.csi.model.Usuario;
import br.csi.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("cadastro")
public class CadastroController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("requisição Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");
        String nome = req.getParameter("nome");

        System.out.println("email: " + email+ "" +"senha: "+senha );

        Usuario u = new Usuario();

        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);

        new UsuarioService().CadastrarUsuario(u);


    }
}