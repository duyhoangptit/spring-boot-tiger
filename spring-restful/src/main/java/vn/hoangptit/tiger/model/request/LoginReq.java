package vn.hoangptit.tiger.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Create file LoginReq
 *
 * @author duyhoangptit
 * @since 6/22/2019
 */
@Data
public class LoginReq implements Serializable {
    private String username;
    private String password;
    private Boolean isRemember;
}
