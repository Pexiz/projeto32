import dao.ImatriculaDao;
import dao.MatriculaDao;
import domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {
    
    @Before
    public void limpaBanco() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Matricula").executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    
    private ImatriculaDao matriculaDao;
    public MatriculaTest()
    {
        matriculaDao = new MatriculaDao();
    }
    
    @Test
    public void cadastrar()
    {
        Matricula mat = new Matricula();
        mat.setCodigo("A");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(200d);
        mat = matriculaDao.cadastrar(mat);
  
        
        assertNotNull(mat);
        assertNotNull(mat.getId());
    }
}
