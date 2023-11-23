package board.spring.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")
public class Post extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "view_count")
    @ColumnDefault("0")
    private Long viewCount;

    @Column(name = "writer")
    private String writer;

    @OneToMany(mappedBy = "post", fetch = EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comment = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    private User user;

    @Builder
    public Post(Long id, String title, String content, Long viewCount, List<Comment> comment, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.comment = comment;
        this.writer = writer;
    }
}





