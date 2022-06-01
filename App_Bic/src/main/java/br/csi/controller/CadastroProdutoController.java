package br.csi.controller;

import br.csi.dao.ProdutoDao;
import br.csi.model.Produto;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("cadastro_produto")
public class CadastroProdutoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("requisição Get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));
        Float preco = Float.valueOf(req.getParameter("preco"));
        String img = req.getParameter("img");


        RequestDispatcher rd;

        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);

        if(new ProdutoDao().Cadastrar(produto)) {
            System.out.println("cadastrou");
            req.setAttribute("retorno", "Cadastro feito com sucesso");
            rd = req.getRequestDispatcher("/WEB-INF/home/produtos.jsp");
            rd.forward(req, resp);

        }else {

            System.out.println("deu ruim");
            req.setAttribute("retorno", "Erro no cadastro");
            rd = req.getRequestDispatcher("/WEB-INF/home/produtos.jsp");
            rd.forward(req, resp);
        }



    }
}
