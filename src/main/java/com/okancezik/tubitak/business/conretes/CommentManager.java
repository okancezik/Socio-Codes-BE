package com.okancezik.tubitak.business.conretes;

import com.okancezik.tubitak.business.abstracts.CommentService;
import com.okancezik.tubitak.business.dtos.requests.CommentUploadRequest;
import com.okancezik.tubitak.core.results.DataResult;
import com.okancezik.tubitak.core.results.SuccessDataResult;
import com.okancezik.tubitak.core.utils.mappers.ModelMapperService;
import com.okancezik.tubitak.dataAccess.CommentRepository;
import com.okancezik.tubitak.entity.concretes.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentManager implements CommentService {

    private final CommentRepository repository;
    private final ModelMapperService mapperService;

    @Override
    public DataResult<Comment> upload(CommentUploadRequest request) {
        Comment comment = mapperService.forRequest().map(request,Comment.class);
        repository.save(comment);
        return new SuccessDataResult<>(comment, "comment uploaded");
        //TO DO CONTROL
    }
}
