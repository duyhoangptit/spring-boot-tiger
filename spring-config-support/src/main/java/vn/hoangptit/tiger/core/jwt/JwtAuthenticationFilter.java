package vn.hoangptit.tiger.core.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.hoangptit.tiger.core.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create file JwtAuthenticationFilter
 *
 * @author duyhoangptit
 * @since 7/3/2019
 */
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String KEY_HEADER_AUTH = "Authorization";
    private final String KEY_HEADER_BEARER = "Bearer ";

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            // Lấy token từ request
            String jwt = this.getTokenFromRequest(httpServletRequest);

            if (StringUtils.hasText(jwt) && this.jwtTokenProvider.validateToken(jwt)) {
                // Lấy id user từ jwt
                Long userId = this.jwtTokenProvider.getUserIdFromToken(jwt);
                // Lấy thông tin user by userId
                UserDetails userDetails = this.userService.findUserByUserId(userId);

                if (userDetails != null) {
                    // Nếu người dùng hợp lệ, set thông tin security cho context
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null,
                                    userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (Exception e) {
            this.logger.error(e.getMessage());
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    /**
     * Lấy mã jwt từ header request
     *
     * @param request
     * @return
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        String bearToken = request.getHeader(KEY_HEADER_AUTH);

        // Kiểm tra xem header Authen có chứa thông tin jwt hay không
        if (StringUtils.hasText(bearToken) && bearToken.startsWith(KEY_HEADER_BEARER)) {
            return bearToken.substring(7);
        }

        return null;
    }
}
