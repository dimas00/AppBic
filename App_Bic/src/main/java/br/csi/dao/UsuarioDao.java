package br.csi.dao;

import br.csi.model.Permissao;
import br.csi.model.Usuario;

import java.sql.Date;


public class UsuarioDao{

        public Usuario getUsuario(String email){

            // abrir conecção com banco
            // gerar sql
            // executar sql...
            // selec * from usuario, permissão
            // where email


            Usuario u = new Usuario();
            u.setEmail(email);
            u.setAtivo(true);
            u.setId(13);
            u.setSenha("123");
            u.setDataCadastro(new Date(2022, 06, 05));
            u.setPermissao(new Permissao(1, "ADMIN"));

            return u;
        }

    }

