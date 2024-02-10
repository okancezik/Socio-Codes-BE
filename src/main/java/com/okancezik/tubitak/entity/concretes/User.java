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
    @Column(name = "userId")
    private int userId;

    @Column(name = "userFullName")
    private String userFullName;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userTitle")
    private String userTitle;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "userBio")
    private String userBio;

    @Column(name = "backgroundUrl")
    private String backgroundUrl;

    @Column(name = "userAvatarUrl")
    private String userAvatarUrl;

    @Column(name = "userRank")
    private int userRank;

    @Column(name = "userPoint")
    private int userPoint;

    @Column(name = "userFollowerCount")
    private int userFollowerCount;

    @Column(name = "userFollowingCount")
    private int userFollowingCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "githubProfileId", referencedColumnName = "profileId")
    private GitHubProfile github;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}
