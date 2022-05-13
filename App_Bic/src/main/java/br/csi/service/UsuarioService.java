package br.csi.service;

import br.csi.dao.UsuarioDao;
import br.csi.model.Usuario;

public class UsuarioService {

    private UsuarioDao dao;

    public  Usuario autenticado (String email, String senha){


                Usuario u = new UsuarioDao().getUsuario(email);

        if(u.getEmail().equals(email)&&
                u.getSenha().equals(senha)){
            return u;
        }
        else{
            return null;
        }
    }


}
