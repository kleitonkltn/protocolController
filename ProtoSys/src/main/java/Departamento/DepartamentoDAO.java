package Departamento;


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
public class DepartamentoDAO extends GenericDAO<Departamento> {

    private EntityManager em;

    public DepartamentoDAO() {
        super(Departamento.class);
        em = getEntityManager();
    }

    public List<Departamento> ListarTodosDepartamentos() {    
        return em.createQuery("SELECT d FROM Departamento d")
                .getResultList();
    }
    

}
