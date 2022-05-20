package br.csi.dao;

import br.csi.model.Permissao;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;

import javax.xml.transform.Result;
import java.sql.*;


public class UsuarioDao{

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

        public Usuario getUsuario(String email){

            Usuario usuario = null;

            try(Connection connection = new ConectaDB().getConexao()){

                this.sql = "SELECT id_usuario, nome, email, senha  FROM usuario WHERE email = ? ; ";
                System.out.println(this.sql);
                preparedStatement = connection.prepareStatement(this.sql);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                System.out.println(email);
                while (resultSet.next()){
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

    }

// abrir conecção com banco
// gerar sql
// executar sql...
// selec * from usuario, permissão
// where email

          /*  Usuario u = new Usuario();
            u.setEmail(email);
            u.setAtivo(true);
            u.setId(13);
            u.setSenha("123");
            u.setDataCadastro(new Date(2022, 06, 05));
            u.setPermissao(new Permissao(1, "ADMIN"));

            return u;*/