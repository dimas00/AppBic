package br.csi.dao;

import br.csi.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProdutoDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String status;


    public Produto getProduto(String id_produto) {

        Produto produto = null;

        try (Connection connection = new ConectaDB().getConexao()) {

            this.sql = "SELECT id_produto, nome, quantidade, preco  FROM usuario WHERE id_produto = ? ; ";
            System.out.println(this.sql);
            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, id_produto);
            resultSet = preparedStatement.executeQuery();
            System.out.println(id_produto);
            while (resultSet.next()) {
                produto = new Produto();
                produto.setId(resultSet.getInt("id_produto"));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return produto;
    }

    public boolean Cadastrar(Produto produto) {



        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "INSERT INTO produtos (nome, preco, quantidade )"+
                    "  values (?, ?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, preparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, produto.getNome());
            this.preparedStatement.setFloat(2, produto.getPreco());
            this.preparedStatement.setInt(3, produto.getQuantidade());


            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();
            if(this.resultSet.getInt(1) > 0){

                produto.setId(this.resultSet.getInt(1));
                this.status = "ok";
            }

            if(this.status. equals("ok")){
                this.sql = "insert into permissao(id_usuario, id_permissao) values (?, ?); ";
                this.preparedStatement = connection.prepareStatement(this.sql);
                this.preparedStatement.setInt(1, produto.getId());
                this.preparedStatement.setInt(2,2);
                this.status = "ok";
                return true;
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "erro";
            return false;
        }

        return false;
    }
}
