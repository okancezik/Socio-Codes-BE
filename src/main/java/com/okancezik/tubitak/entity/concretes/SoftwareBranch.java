package com.okancezik.tubitak.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "software_branches")
public class SoftwareBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private int rank;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "point")
    private int point;

    @Column(name = "icon_url")
    private String iconUrl;

    @OneToMany(mappedBy = "branch")
    private List<Post> posts;

    @OneToMany(mappedBy = "branch")
    private List<Course> courses;

}
