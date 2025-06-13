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
    
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carro> carros = new ArrayList<>();


}
