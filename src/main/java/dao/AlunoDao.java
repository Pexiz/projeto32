package dao;

import domain.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlunoDao implements IAlunoDao {
    @Override
    public Aluno cadastrar(Aluno aluno) {
        
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return aluno;
    }
    }
    
    

