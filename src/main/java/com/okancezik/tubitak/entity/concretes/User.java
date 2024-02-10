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
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_full_name")
    private String userFullName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_title")
    private String userTitle;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_bio")
    private String userBio;

    @Column(name = "background_url")
    private String backgroundUrl;

    @Column(name = "user_avatar_url")
    private String userAvatarUrl;

    @Column(name = "user_rank")
    private int userRank;

    @Column(name = "user_point")
    private int userPoint;

    @Column(name = "user_follower_count")
    private int userFollowerCount;

    @Column(name = "user_following_count")
    private int userFollowingCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "github_profile_id", referencedColumnName = "profile_id")
    private GitHubProfile github;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
