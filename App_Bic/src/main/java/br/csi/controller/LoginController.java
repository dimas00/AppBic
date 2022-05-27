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
@WebServlet("login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("requisição Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senha = req.getParameter("senha");
        String email = req.getParameter("email");

        //System.out.println("email: " + email+ "" +"senha: "+senha );

        RequestDispatcher rd;

        Usuario usuario = new UsuarioService().autenticado(email, senha);

        if(usuario != null){
            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario_logado", usuario);
             rd = req.getRequestDispatcher("/WEB-INF/home/dasbord.jsp");


        }else {
            req.setAttribute("erro", "USUÁRIO OU SENHA INCORRETO");
                  rd = req.getRequestDispatcher("/WEB-INF/cadastro.jsp");

        }
        rd.forward(req, resp);



    }
}
