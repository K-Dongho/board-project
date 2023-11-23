package board.spring.project.dto;

import board.spring.project.entity.Post;
import lombok.Builder;
import lombok.Getter;


@Getter
public class PostAddDto {
    private final String title;
    private final String content;
    private final String writer;

    @Builder
    public PostAddDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
