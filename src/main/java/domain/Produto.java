package domain;

import jakarta.persistence.*;

@Table(name = "TB_PRODUTO")
public class Produto {
        
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq") // variavel produto_seq
        @SequenceGenerator(name = "produto_seq", sequenceName = "sq_produto", initialValue =1, allocationSize = 1)   // variavel curso_seq que vai passar o valor pra sq_curso começar com 1 e aumentar 1 de 1
        private Long id;
        
        @Column (name = "CODIGO", length = 10, nullable = false, unique = true)
        private String codigo;
        
        @Column (name = "NOME", length = 50, nullable = false)
        private String nome;
        
        @Column (name = "DESCRICAO", length = 100, nullable = false)
        private String descricao;
}
