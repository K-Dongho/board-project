package board.spring.project.service;

import board.spring.project.dto.AddPostDto;
import board.spring.project.entity.Post;
import board.spring.project.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(AddPostDto addPostDto) {
        return postRepository.save(addPostDto.toEntity());
    }
}
