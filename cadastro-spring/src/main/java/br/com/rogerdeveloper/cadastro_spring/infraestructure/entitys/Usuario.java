package br.com.rogerdeveloper.cadastro_spring.infraestructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter // chama metodo getter
@Setter // chama metodo setter
@AllArgsConstructor // construtores para acessar a classe
@NoArgsConstructor
@Builder // update
@Table(name = "usuario") // indicar que é uma tabela
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // Column - Define as colunas
    @Column(name = "email", unique = true) // unique = UNICO, nao pode ser cadastrado com o mesmo email!!!
    private String email;

    @Column(name = "nome")
    private String nome;
}
