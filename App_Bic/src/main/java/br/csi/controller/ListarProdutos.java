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

@WebServlet("/")
public class ListarProdutos extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ProdutoDao produtoDao = new ProdutoDao();

        ArrayList<Produto> produtos = produtoDao.getProdutos();

        System.out.println("qtd de prodtuso: "+produtos.size());

        req.setAttribute("produtos", produtos);

        RequestDispatcher rd = req.getRequestDispatcher("VisualizarProduto.jsp");


        System.out.println();
        rd.forward(req,resp);

    }
}
