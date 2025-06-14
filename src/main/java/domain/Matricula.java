package domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "TB_MATRICULA")
public class Matricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matri_seq")
    @SequenceGenerator(name = "matri_seq", sequenceName = "sq_matricula", initialValue =1, allocationSize = 1)
    private Long id;
    
    @Column (name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    
    @Column (name = "DATA_MATRICULA" , nullable = false)
    private Instant dataMatricula;
    
    @Column (name = "VALOR" , nullable = false)
    private double valor;
    
    @Column(name = "STATUS" , nullable = false)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "id_curso_fk", nullable = false,
            foreignKey = @ForeignKey(name = "fk_curso_matricula"))
    private Curso curso;
    
    @OneToOne
    @JoinColumn(name = "id_aluno_fk", nullable = false,
            foreignKey = @ForeignKey(name = "fk_aluno_matricula"))
    private Aluno aluno;
    
    
    public Curso getCurso() {
        return curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public Instant getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(Instant dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
