package uz.bakhromjon.persistence.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageableResponse<T> {
    private List<T> content;
    private Long totalElements;
    private Integer totalPages;
    private Integer size;


    public static <T> PageableResponse<T> build(Page<T> page) {
        return new PageableResponse<>(page.getContent(), page.getTotalElements(),
                page.getTotalPages(), page.getContent().size());
    }
}
