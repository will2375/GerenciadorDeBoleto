package com.gerenciadorDeBoleto.controle.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table
public class ContasReceber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String recebimento;
    @Column @NotNull
    private BigDecimal valorRecebimento;
    @Column @NotNull @NotBlank
    private String tipoRecebimento;
    @Column @NotNull
    private LocalDate dataDeVencimento;
    @Column
    private LocalDateTime dataDeRecebimento;
    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "contas_id", referencedColumnName = "id")
    private Usuario usuario;
}
