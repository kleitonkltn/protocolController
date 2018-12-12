package Usuarios;


import app.GenericDAO;
import java.util.List;

import javax.persistence.EntityManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NVIDIA
 */
public class UsuarioDAO extends GenericDAO<Usuarios> {

    EntityManager em;
    Usuarios newUsuario;

    public UsuarioDAO() {
        super(Usuarios.class);
        em = getEntityManager();
    }

    public void inserirUsuario(List<Usuarios> list) {
        newUsuario = new Usuarios();
        em.getTransaction().begin();
        for (int i = 0; i < list.size(); i++) {
            newUsuario = new Usuarios();
            newUsuario.setNome(list.get(i).getNome());
            newUsuario.setSobrenome(list.get(i).getSobrenome());
            newUsuario.setDepartamento(list.get(i).getDepartamento());
            newUsuario.setSenha(list.get(i).getSenha());
            newUsuario.setEmail(list.get(i).getEmail());
            em.persist(newUsuario);
        }
        em.getTransaction().commit();
    }

    public List<Usuarios> listarTodos() {
        em.getTransaction().begin();
        return em.createQuery("SELECT u FROM Usuarios u")
                .getResultList();
        
    }

}
