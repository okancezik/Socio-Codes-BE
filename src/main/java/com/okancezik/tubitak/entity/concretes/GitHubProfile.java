package com.okancezik.tubitak.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "github_profiles")
public class GitHubProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private int profileId;

    @Column(name = "github_token")
    private String githubToken;

    @Column(name = "github_username")
    private String githubUsername;

    @Column(name = "profile_url")
    private String profileUrl;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;
}
