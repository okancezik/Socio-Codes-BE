package com.okancezik.tubitak.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


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
    private String content;

    @Column(name = "repository_url")
    private String repositoryUrl;

    @Column(name = "created_date")
    private LocalDateTime loadDate = LocalDateTime.now();

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "comment_count")
    private int commentCount;

    @Column(name = "repository_star_count")
    private String repositoryStarCount;

    @Column(name = "repository_fork_count")
    private String repositoryForkCount;

    @Column(name = "repository_updated_date")
    private String repositoryUpdatedDate;

    @Column(name = "repository_description")
    private String repositoryDescription;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private SoftwareBranch branch;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

}
