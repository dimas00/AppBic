package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Produto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("controlador")
public class DashboardController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcao = req.getParameter("opcao");
        System.out.println("opção de navegação: " +opcao);

        System.out.println("************");

        System.out.println("user-agent" + req.getHeader("user-agent"));

      RequestDispatcher rd = null;


      if(opcao.equals("cliente") ){

              rd =  req.getRequestDispatcher("/WEB-INF/home/cliente.jsp");

    }else if (opcao.equals("produto")) {

          ProdutoDao produtoDao = new ProdutoDao();

          ArrayList<Produto> produtos = produtoDao.getProdutos();

          System.out.println("qtd de prodtuso: "+produtos.size());

          req.setAttribute("produtos", produtos);

          rd =  req.getRequestDispatcher("/WEB-INF/home/produtos.jsp");

      }else if (opcao.equals("editar ")) {

          ProdutoDao produtoDao = new ProdutoDao();

          ArrayList<Produto> produtos = produtoDao.getProdutos();

          System.out.println("qtd de prodtuso: "+produtos.size());

          req.setAttribute("produtos", produtos);

          rd =  req.getRequestDispatcher("/WEB-INF/home/produtos.jsp");

      }

      else if (opcao.equals("sair")){
          req.getSession().invalidate();
            rd =  req.getRequestDispatcher("/");
        }

      else if(opcao.equals("voltar")){
          rd =  req.getRequestDispatcher("/");
      }

      else if(opcao.equals("cadastro")){
          rd =  req.getRequestDispatcher("/WEB-INF/home/cadastro.jsp");
      }

      else if(opcao.equals("login")){
          rd =  req.getRequestDispatcher("/WEB-INF/home/login.jsp");
      }

      else{
          rd =  req.getRequestDispatcher("/WEB-INF/home/dasbord.jsp");
      }
      
      rd.forward(req, resp);
}


}
