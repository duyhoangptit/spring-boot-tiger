package vn.hoangptit.tiger.dashboard.domain.dto;

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
