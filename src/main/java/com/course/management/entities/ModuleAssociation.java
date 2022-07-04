package com.course.management.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.course.management.entities.shared.BaseEntity;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "module_associations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleAssociation extends BaseEntity {

    private String code;
    @NotNull				//There will be atleast one module in every Course
    private String moduleCode;

    @NotNull
    private String courseCode;

    public ModuleAssociation(String moduleCode, String courseCode) {
        this.moduleCode = moduleCode;
        this.courseCode = courseCode;
    }
}
