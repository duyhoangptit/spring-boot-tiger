package vn.hoangptit.tiger.core.authen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Create file LoginResponseDto
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Data
@AllArgsConstructor
public class LoginResponseDto implements Serializable {
    private String token;
}
