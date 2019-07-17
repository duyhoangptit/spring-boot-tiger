package vn.hoangptit.tiger.dashboard.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String description;
}
