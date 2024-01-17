package com.tenco.projectinit.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "first_category_tb")
public class FirstCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnoreProperties({ "firstCategory" })
    @OneToMany(mappedBy = "firstCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SecondCategory> secondCategories = new ArrayList<>();
}
