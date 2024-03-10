package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.CommentService;
import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.business.dtos.responses.CommentListModelResponse;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.ErrorDataResult;
import com.okancezik.tubitak.core.results.Result;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.CommentRepository;
import com.okancezik.tubitak.entity.concretes.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentManager implements CommentService {

    private final CommentRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public Result upload(CommentUploadRequest request) {
        Comment comment = mapperService.forRequest().map(request,Comment.class);
        repository.save(comment);
        return new SuccessDataResult<>(comment, "comment uploaded");
        //TO DO CONTROL
    }

    @Override
    public DataResult<List<CommentListModelResponse>> getCommentsByPostId(int postId) {
        var response = repository.findByPost_Id(postId);
        if(response.isPresent()){
            List<Comment> comments = response.get();
            List<CommentListModelResponse> data = comments.stream().map(
                    comment -> mapperService.forResponse().map(comment,CommentListModelResponse.class)
            ).collect(Collectors.toList());
            return new SuccessDataResult<>(data,"Listed comments");
        }else{
            return new ErrorDataResult<>("Not found comment");
        }

    }
}
