package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clean_category_tb")
public class CleanCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cleanCategories;

    @Builder
    public CleanCategory(Integer id, String cleanCategories) {
        this.id = id;
        this.cleanCategories = cleanCategories;
    }
}
