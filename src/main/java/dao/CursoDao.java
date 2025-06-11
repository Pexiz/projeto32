package dao;

import domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;

public class CursoDao implements ICursoDao{
    
    @Override
    public Curso cadastrar(Curso curso) {
        
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(curso);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return curso;
    }
    
    @Override
    public Curso pesquisar(long id) {
        
        
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        Curso c = entityManager.find(Curso.class,id);
        
        entityManager.close();
        entityManagerFactory.close();
        
        return c;
        
    }
    
    @Override
    public Curso deleter(Curso curso) {
        
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        em.getTransaction().begin();
        
        Curso cursoBeDeleted;
        try {
            
            if (em.contains(curso))
            {
                cursoBeDeleted = curso;
            }
            else cursoBeDeleted = em.merge(curso);
            
            return cursoBeDeleted;
        }
        
        finally{
        em.close();
        entityManagerFactory.close();
        
       }   }
    
    
    @Override
    public Curso atualizar(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // 1) traz a entidade do banco para o contexto
            Curso gerenciado = em.find(Curso.class, curso.getId());
            if (gerenciado == null) {
                throw new EntityNotFoundException(
                        "Não existe Curso com id = " + curso.getId());
            }
            
            gerenciado.setCodigo(curso.getCodigo());
            gerenciado.setNome(curso.getNome());
            gerenciado.setDescricao(curso.getDescricao());
            
            em.getTransaction().commit();
            return gerenciado;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    
    
    
    public Curso atualizarCampos(Curso curso, String novoNome, String novaDescricao)
    {
        
        curso.setNome(novoNome);
        curso.setDescricao(novaDescricao);
        
        
        return curso;
    }
}
