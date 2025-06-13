package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "sq_id", initialValue =1, allocationSize = 1)
    private Long id;
    
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    
    @Column (name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;
    
    @Column (name = "SLOGAN", length = 50, nullable = false)
    private String slogan;
    
    @Column(name="NOME", nullable=false)
    private String nome;
    
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
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getSlogan() {
        return slogan;
    }
    
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Carro> getCarros() {
        return carros;
    }
    
    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carro> carros = new ArrayList<>();


}
