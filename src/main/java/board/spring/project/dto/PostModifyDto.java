package board.spring.project.dto;

import lombok.Getter;

@Getter
public class PostModifyDto {
    private final String title;
    private final String content;


    public PostModifyDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
