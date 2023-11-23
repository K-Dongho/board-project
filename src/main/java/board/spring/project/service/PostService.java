package board.spring.project.service;

import board.spring.project.dto.PostAddDto;
import board.spring.project.entity.Post;
import board.spring.project.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(PostAddDto postAddDto) {
        return postRepository.save(postAddDto.toEntity());
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
