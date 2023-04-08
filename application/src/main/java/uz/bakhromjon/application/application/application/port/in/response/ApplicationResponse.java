package uz.bakhromjon.application.application.application.port.in.response;

/**
 * @author : Bakhromjon Khasanboyev
 **/

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationResponse {
    private Long id;
    private Long applicantId;
    private String message;

}
