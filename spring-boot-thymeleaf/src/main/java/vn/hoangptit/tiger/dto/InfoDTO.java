package vn.hoangptit.tiger.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class InfoDTO implements Serializable {
    private String key;
    private String value;
}
