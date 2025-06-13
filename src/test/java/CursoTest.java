import dao.CursoDao;
import dao.ICursoDao;
import domain.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CursoTest {
    
    private ICursoDao cursoDao = new CursoDao();
    
    @Before
    public void limpaBanco() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Matricula").executeUpdate();
        em.createQuery("DELETE FROM Aluno").executeUpdate();
        em.createQuery("DELETE FROM Curso").executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    @Test
    public void cadastrar()
    {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso Teste");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
        
    }
    @Test
    public void pesquisar()
    {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso Teste");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);
        curso = cursoDao.pesquisar(curso.getId());
        
        assertNotNull(curso);
        assertNotNull(curso.getId());
        
    }
    
    @Test
    public void deletar()
    {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("Curso Teste");
        curso.setNome("Curso de Java Backend");
        curso = cursoDao.cadastrar(curso);
        cursoDao.deleter(curso);
        
        Curso cursoTest = cursoDao.pesquisar(curso.getId());
        assertNotNull(cursoTest);
    }
    
    @Test
    public void atualizar() {

        Curso curso = new Curso();
        curso.setCodigo("1");
        curso.setNome("Antes");
        curso.setDescricao("Descrição Antes");
        Curso salvo = cursoDao.cadastrar(curso);
        
        Curso mod = new Curso();
        mod.setId(salvo.getId());
        mod.setCodigo("1");
        mod.setNome("Depois");
        mod.setDescricao("Descrição Depois");
        
        Curso atualizado = cursoDao.atualizar(mod);
        
        // 3) valida que os campos foram alterados
        assertNotNull(atualizado);
        assertEquals(salvo.getId(), atualizado.getId());
        assertEquals("Depois", atualizado.getNome());
        assertEquals("Descrição Depois", atualizado.getDescricao());
    }
    
}
