package com.github.luizns.desafiocrud.DTO;

import com.github.luizns.desafiocrud.entities.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "não pode ser vazio")
    private String name;
    private String cpf;
    @Positive(message = "Renda deve ser positivo")
    private Double income;
    @PastOrPresent(message = "não pode ser data futura")
    private LocalDate birthDate;
    @PositiveOrZero(message = "Número de filhos deve ser zero ou positivo")
    private Integer children;

    public ClientDTO() {
    }

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
