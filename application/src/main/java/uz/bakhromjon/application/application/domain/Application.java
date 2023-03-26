package uz.bakhromjon.application.application.domain;

/**
 * @author : Bakhromjon Khasanboyev
 **/

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id", "applicantId", "message", "isDeleted"})
public class Application {
    private Long id;
    private Long applicantId;
    private String message;
    private Boolean isDeleted = Boolean.FALSE;

}
