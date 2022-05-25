package br.csi.dao;

import br.csi.model.Usuario;

import java.sql.*;


public class UsuarioDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String status;


    public Usuario getUsuario(String email) {

        Usuario usuario = null;

        try (Connection connection = new ConectaDB().getConexao()) {

            this.sql = "SELECT id_usuario, nome, email, senha  FROM usuario WHERE email = ? ; ";
            System.out.println(this.sql);
            preparedStatement = connection.prepareStatement(this.sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            System.out.println(email);
            while (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome").toLowerCase());
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public String cadastrar(Usuario usuario) {



        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "INSERT INTO usuario (nome, email, senha, data_cadastro, ativo )"+
                    "  values (?, ?, ?, current_date , ?)";

            this.preparedStatement = connection.prepareStatement(this.sql, preparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1, usuario.getNome());
            this.preparedStatement.setString(2, usuario.getEmail());
            this.preparedStatement.setString(3, usuario.getSenha());
            this.preparedStatement.setBoolean(4, usuario.isAtivo());

            this.preparedStatement.execute();
            this.resultSet = this.preparedStatement.getGeneratedKeys();
            this.resultSet.next();
            if(this.resultSet.getInt(1) > 0){

                usuario.setId(this.resultSet.getInt(1));
                this.status = "ok";
            }

            if(this.status. equals("ok")){
                this.sql = "insert into permissao(id_usuario, id_permissao)" + "= values (?, ?) ";
                this.preparedStatement = connection.prepareStatement(this.sql);
                this.preparedStatement.setInt(1, usuario.getId());
                this.preparedStatement.setInt(2,2);
                this.status = "ok";
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            this.status = "deu ruim";
        }

        return this.status;
    }
}
