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
@Table(name = "github_profiles")
public class GitHubProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profileId")
    private int profileId;

    @Column(name = "githubToken")
    private String githubToken;

    @Column(name = "githubUsername")
    private String githubUsername;

    @Column(name = "profileUrl")
    private String profileUrl;

    @OneToOne(mappedBy = "github")
    private User user;

}
