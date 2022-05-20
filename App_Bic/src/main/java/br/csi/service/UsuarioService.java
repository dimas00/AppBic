package br.csi.service;

import br.csi.dao.UsuarioDao;
import br.csi.model.Usuario;

public class UsuarioService {

   // private UsuarioDao dao;

    public  Usuario autenticado (String email, String senha){


                Usuario usuario = new UsuarioDao().getUsuario(email);



        try {
            if(usuario.getEmail().equals(email)&&
                    usuario.getSenha().equals(senha)){
                return usuario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
