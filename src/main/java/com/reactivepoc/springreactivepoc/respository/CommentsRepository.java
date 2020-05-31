package com.reactivepoc.springreactivepoc.respository;

import com.reactivepoc.springreactivepoc.model.Comments;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends ReactiveCrudRepository<Comments, Long> {

}