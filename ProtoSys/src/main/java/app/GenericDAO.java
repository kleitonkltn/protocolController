package app;



import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author NVIDIA
 */
public class GenericDAO<T> {

    private EntityManager em;
    private Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        em = FabricaDeGerenciadorDeEntidades.getEntityManager();
        this.clazz = clazz;
    }

    public void abrirTransacao() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void inserir(T t) {
        abrirTransacao();      
        em.persist(t);
        commit();
    }
   
    public T buscarPorId(Long id) {
        return em.find(clazz, id);
    }

    public List<T> listarTodos() {
        return em.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t")
                .getResultList();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
