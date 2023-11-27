package board.spring.project.controller;


import board.spring.project.dto.PostAddDto;
import board.spring.project.dto.PostListResponseDto;
import board.spring.project.dto.PostResponseDto;
import board.spring.project.entity.Post;
import board.spring.project.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Post> save(@RequestBody PostAddDto postAddDto) {
        Post savePost = postService.save(postAddDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savePost);
    }

    @GetMapping
    public ResponseEntity<List<PostListResponseDto>> findAllPost(){
        List<PostListResponseDto> posts = postService.findAll()
                .stream()
                .map(PostListResponseDto::new)
                .toList();
        return ResponseEntity.ok()
                .body(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> findPost(@PathVariable Long id){
        Post post = postService.findById(id);
        return ResponseEntity.ok()
                .body(new PostResponseDto(post));
    }

}
