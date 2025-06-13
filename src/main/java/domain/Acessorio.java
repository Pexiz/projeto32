package domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acess_seq")
    @SequenceGenerator(name = "acess_seq", sequenceName = "sq_acessorio",
            initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "carro_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_acessorio_carro"))
    
    private Carro carro;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Carro getCarro() { return carro; }
    public void setCarro(Carro carro) { this.carro = carro; }
}
