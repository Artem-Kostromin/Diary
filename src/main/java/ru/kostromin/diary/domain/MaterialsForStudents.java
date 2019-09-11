package ru.kostromin.diary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaterialsForStudents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filename;
    private String description;

    public MaterialsForStudents() {
    }

    public MaterialsForStudents(String filename, String description) {
        this.filename = filename;
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
