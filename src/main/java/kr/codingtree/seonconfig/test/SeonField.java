package kr.codingtree.seonconfig.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SeonField {

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;
}
