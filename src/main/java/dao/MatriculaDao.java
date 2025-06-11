package dao;

import domain.Curso;
import domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MatriculaDao implements ImatriculaDao{
    @Override
    public Matricula cadastrar(Matricula mat) {
         
            EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("ExemploJPA");
            
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            
            entityManager.getTransaction().begin();
            entityManager.persist(mat);
            entityManager.getTransaction().commit();
            
            entityManager.close();
            entityManagerFactory.close();
            
            return mat;
        }
}
