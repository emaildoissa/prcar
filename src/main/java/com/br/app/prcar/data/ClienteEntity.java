/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.app.prcar.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")

public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    
    private Date data;
    @NotBlank
    private String marca;
    @NotBlank
    private String placa;
    
    private Integer km;
    @NotBlank
    private String serviço1;
    
    private String serviço2;
    @NotBlank
    private String obs;
}
