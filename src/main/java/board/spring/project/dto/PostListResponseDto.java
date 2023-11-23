package board.spring.project.dto;

import board.spring.project.entity.Post;
import lombok.Getter;

@Getter
public class PostListResponseDto {
    private final String title;
    private final Long viewCount;
    private final String writer;

    public PostListResponseDto(Post post) {
        this.title = post.getTitle();
        this.viewCount = post.getViewCount();
        this.writer = post.getWriter();
    }
}
