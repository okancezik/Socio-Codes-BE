package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.UserService;

import com.okancezik.tubitak.business.dtos.requests.UserUpdateInfoRequest;
import com.okancezik.tubitak.business.dtos.responses.UserDetailResponse;
import com.okancezik.tubitak.business.dtos.responses.UserScoreModelResponse;
import com.okancezik.tubitak.core.results.*;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.UserRepository;
import com.okancezik.tubitak.entity.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final ModelMapperService mapper;

    @Override
    public DataResult<List<UserScoreModelResponse>> getUserScoreList() {
        List<User> users = repository.findAll(Sort.by(Sort.Direction.DESC,"point"));
        List<UserScoreModelResponse> userScoreModelResponses = users.stream()
                .map(user -> mapper.forResponse().map(user, UserScoreModelResponse.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<>(userScoreModelResponses,"Listed user score list");
    }

    @Override
    public DataResult<UserDetailResponse> getUserDetailById(int id) {
        Optional<User> foundUser = repository.findById(id);
        if(foundUser.isPresent()){
            User u = foundUser.get();
            UserDetailResponse userDetail = mapper.forResponse().map(u, UserDetailResponse.class);
            return new SuccessDataResult<UserDetailResponse>(userDetail, "User listed");
        }else{
            return new ErrorDataResult<>("Not found user");
        }
    }

    @Override
    public DataResult<UserDetailResponse> updateUserInfo(UserUpdateInfoRequest user) {
        Optional<User> foundUser = repository.findById(user.getId());
        if(foundUser.isPresent()){
            User u = foundUser.get();
            u.setTitle(user.getTitle());
            u.setFullName(user.getFullName());
            u.setBio(user.getBio());
            repository.save(u);
            UserDetailResponse userDetail = mapper.forResponse().map(u, UserDetailResponse.class);
            return new SuccessDataResult<>(userDetail, "User updated succesfully");
        }else{
            return new ErrorDataResult<>("Not found user");
        }

    }

    /*
    @Override
    public DataResult<User> updateGithubInfo(UserUpdateGithubInfoRequest user) {
         Optional<User> foundUser = repository.findById(user.getId());
         if(foundUser.isPresent()){
             User u = foundUser.get();
             u.setAvatarUrl(user.getAvatarUrl());
             u.setGithub(new GitHubProfile() {});
             u.getGithub().setGithubUsername(user.getGithubGithubUsername());
             u.getGithub().setProfileUrl(user.getGithubProfileUrl());
             repository.save(u);
             return new SuccessDataResult<>(u,"Listed user");
         }else{
             return new ErrorDataResult<>("User not found");
         }
    }

     */

}
