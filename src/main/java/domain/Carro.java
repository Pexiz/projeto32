package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TB_CARRO")
public class Carro {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue =1, allocationSize = 1)
    private Long id;
    
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    
    @Column (name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;
    
    @OneToMany(
            mappedBy = "carro",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Acessorio> acessorios = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "marca_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_carro_marca"))
    private Marca marca;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public List<Acessorio> getAcessorios() {
        return acessorios;
    }
    
    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void adicionarAcessorio(Acessorio a) {
        a.setCarro(this);
        this.acessorios.add(a);
    }
 
}
