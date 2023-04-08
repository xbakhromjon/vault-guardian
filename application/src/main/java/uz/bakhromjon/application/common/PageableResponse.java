package uz.bakhromjon.application.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    public static <E, GD> PageableResponse<GD> build(PageableResponse<E> page, List<GD> content) {
        return new PageableResponse<>(content, page.getTotalElements(),
                page.getTotalPages(), page.getSize());
    }
}
