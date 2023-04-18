package uz.bakhromjon.application.passport.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassportSearchCriteria {
    private String search;
    private Integer page;
    private Integer size;
}
