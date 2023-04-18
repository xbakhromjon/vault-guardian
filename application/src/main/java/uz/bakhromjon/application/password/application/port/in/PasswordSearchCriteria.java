package uz.bakhromjon.application.password.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordSearchCriteria {
    private String search;
    private Integer page;
    private Integer size;
}
