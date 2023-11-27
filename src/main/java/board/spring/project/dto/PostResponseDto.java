package board.spring.project.dto;

import board.spring.project.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private final String title;
    private final String content;
    private final Long viewCount;
    private final String writer;
    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;



    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.viewCount = post.getViewCount();
        this.writer = post.getWriter();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
