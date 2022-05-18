package br.csi.dao;

import br.csi.model.Permissao;
import br.csi.model.Usuario;
import br.csi.service.UsuarioService;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDao{

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

        public Usuario getUsuario(String email){

            Usuario usuario = null;

            try(Connection connection = new ConectaDB().getConexao()){

                this.sql = "SELECT * FROM usuario WHERE email = ?; ";
                preparedStatement = connection.prepareStatement(this.sql);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                System.out.println(getUsuario(String email));
                while (resultSet.next()){
                    usuario = new Usuario();
                    usuario.setNome(WordUtils.captalize(resulSet.getString("nome").toLowerCase()));
                    usuario.setEmail(resultSet.get.String("email"));

                }


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