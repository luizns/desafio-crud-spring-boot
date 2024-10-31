package com.github.luizns.desafiocrud.DTO;

import com.github.luizns.desafiocrud.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido ")
    private String name;
    @CPF
    private String cpf;
    @Positive(message = "Renda deve ser positivo")
    private Double income;
    @PastOrPresent
    private LocalDate birthDate;
    @Positive(message = "Número de filhos deve ser positivo")
    private Integer children;

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
