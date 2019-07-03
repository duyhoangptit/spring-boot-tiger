package vn.hoangptit.tiger.core.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Create file LoginRequestDto
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Data
public class LoginRequestDto implements Serializable {
    private String username;
    private String password;
}
