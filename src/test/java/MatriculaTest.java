import dao.*;
import domain.Aluno;
import domain.Computador;
import domain.Curso;
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
        em.createQuery("DELETE FROM Aluno").executeUpdate();
        em.createQuery("DELETE FROM Curso").executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
        


    }
    
    private ImatriculaDao matriculaDao;
    
    private ICursoDao cursoDao;
    
    private IAlunoDao alunoDao;
    
    private IComputadorDao computadorDao;
    
    public MatriculaTest()
    {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
        computadorDao = new ComputadorDao();
    }
    
    @Test
    public void cadastrar()
    {
        Curso curso = criarCurso("12");
        Aluno aluno = criarAluno("12");
        Matricula mat = new Matricula();
        mat.setCodigo("12");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(200d);
        mat.setCurso(curso);
        mat.setAluno(aluno);
        aluno.setMatricula(mat);
        mat = matriculaDao.cadastrar(mat);
        Computador comp = criarComputador("A1");
  
        
        assertNotNull(mat);
        assertNotNull(mat.getId());
    }
    
    private Computador criarComputador(String codigo) {
        Computador comp = new Computador();
        comp.setCodigo(codigo);
        comp.setDescricao("Comp 1");
        return comp;
    }
    
    private Aluno criarAluno(String number) {
        Computador comp = criarComputador("a1");
        Aluno aluno = new Aluno();
        aluno.setCodigo(number);
        aluno.setMatricula(null);
        aluno.setNome("Pedro");
        aluno.setComputadores(null);
        aluno.add(comp);
        return alunoDao.cadastrar(aluno);
    }
    
    private Curso criarCurso(String codigo)
    {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setNome("Antes");
        curso.setDescricao("Descrição Antes");
        return cursoDao.cadastrar(curso);
    }
}
