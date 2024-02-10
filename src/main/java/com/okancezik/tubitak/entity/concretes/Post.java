package com.okancezik.tubitak.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String postContent;

    @Column(name = "repositoryUrl")
    private String repositoryUrl;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "likeCount")
    private int likeCount;

    @Column(name = "commentCount")
    private int commentCount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "branchId", referencedColumnName = "id")
    private SoftwareBranch branch;

}
