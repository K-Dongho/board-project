package board.spring.project.controller;


import board.spring.project.dto.AddPostDto;
import board.spring.project.entity.Post;
import board.spring.project.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<Post> save(@RequestBody AddPostDto addPostDto) {
        Post savePost = postService.save(addPostDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savePost);
    }

}
