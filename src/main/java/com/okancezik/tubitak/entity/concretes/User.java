package com.okancezik.tubitak.entity.concretes;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "title")
    private String title;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "bio")
    private String bio;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "point")
    private int point;

    @Column(name = "follower_count")
    private int followerCount;

    @Column(name = "following_count")
    private int followingCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "github_profile_id", referencedColumnName = "profile_id")
    private GitHubProfile github;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

}
