package vn.hoangptit.tiger.core.authen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hoangptit.tiger.core.authen.dto.UserDto;
import vn.hoangptit.tiger.core.authen.dto.LoginRequestDto;
import vn.hoangptit.tiger.core.authen.dto.LoginResponseDto;
import vn.hoangptit.tiger.core.config.jwt.JwtTokenProvider;

import javax.validation.Valid;

/**
 * Create file AuthenController
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@RestController
@RequestMapping("tiger")
public class AuthenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // login
    @PostMapping("login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto loginRequest) {
        // Xác thực từ username, password
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                ));

        // Nếu không có exception thì user là hợp lệ.
        // Set thông tin authen cho security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt token cho người dùng
        String jwtToken = this.jwtTokenProvider.generateToken(((UserDto) authentication
                .getPrincipal()).getUserEntity().getUserId());

        return new LoginResponseDto(jwtToken);
    }

    // auth

    // logout


}
