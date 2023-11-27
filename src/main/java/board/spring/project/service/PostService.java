package board.spring.project.service;

import board.spring.project.dto.PostAddDto;
import board.spring.project.dto.PostModifyDto;
import board.spring.project.entity.Post;
import board.spring.project.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id + "post"));
    }

    @Transactional
    public Post modify(Long id, PostModifyDto postModifyDto){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found " + id + "post"));
        post.modify(postModifyDto.getTitle(), postModifyDto.getContent());

        return post;
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }
}
