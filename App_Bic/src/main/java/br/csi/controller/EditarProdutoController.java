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

@WebServlet("editar")
public class EditarProdutoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("requisição Get");

        int id = Integer.parseInt(req.getParameter("id")) ;
        Produto produto = new ProdutoDao().getProduto1(id);
        req.setAttribute("produto",produto);


        RequestDispatcher rd;


        rd = req.getRequestDispatcher("/WEB-INF/home/editar.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id_produto"));
        String nome = req.getParameter("nome");
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));
        Float preco = Float.valueOf(req.getParameter("preco"));

       // String img = req.getParameter("img");


        RequestDispatcher rd;

        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        produto.setId(id);


        if(new ProdutoDao().Editar(produto)) {
            System.out.println("cadastrou");
            req.setAttribute("retorno", "Edição realizada com sucesso");

            rd = req.getRequestDispatcher("controlador?opcao=produto");
            rd.forward(req, resp);

        }else {

            System.out.println("deu ruim");
            req.setAttribute("retorno", "Erro ao editar");
            rd = req.getRequestDispatcher("/WEB-INF/home/editar.jsp");
            rd.forward(req, resp);
        }






    }
}
