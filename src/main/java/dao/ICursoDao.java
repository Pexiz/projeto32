package dao;

import domain.Curso;

public interface ICursoDao {
    
    public Curso cadastrar (Curso curso);
    
    public Curso pesquisar (long id);
    
    public Curso deleter (Curso curso);
    
    public Curso atualizar (Curso curso);
    
}
