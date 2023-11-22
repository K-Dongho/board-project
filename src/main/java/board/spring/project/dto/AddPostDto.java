package board.spring.project.dto;

import board.spring.project.entity.Post;
import board.spring.project.entity.User;
import lombok.Builder;
import lombok.Getter;


@Getter
public class AddPostDto {
    private final String title;
    private final String content;
    private final User user;

    @Builder
    public AddPostDto(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }

}
