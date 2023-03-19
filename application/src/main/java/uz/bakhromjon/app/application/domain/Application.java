package uz.bakhromjon.app.application.domain;

/**
 * @author : Bakhromjon Khasanboyev
 **/

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id", "applicantId", "message"})
public class Application {
    private Long id;
    private Long applicantId;
    private String message;
    private Boolean isDeleted = Boolean.FALSE;

}
