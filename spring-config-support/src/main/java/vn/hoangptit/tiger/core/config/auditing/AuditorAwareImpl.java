package vn.hoangptit.tiger.core.config.auditing;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware {

    private static final String SYSTEM_AUDITOR = "SYSTEM";

    @Override
    public Optional getCurrentAuditor() {
        // Lấy thông tin user từ session ....
        // Kiểm tra nếu không có thông tin thì lấy thông tin system
        return Optional.of(SYSTEM_AUDITOR);
    }
}
