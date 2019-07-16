package vn.hoangptit.tiger.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * Create file Status
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
public enum Status {
    INACTIVE(0),
    ACTIVE(1);

    private final int statusCode;

    Status(int statusCode) {
        this.statusCode = statusCode;
    }

    @JsonCreator
    public static Status statusOf(int statusCode) {
        // Duyệt danh sách values của enum. Kiểm tra nếu Status nào có statusCode = input thì return trả về.
        return Arrays.stream(values()).filter((status) -> status.statusCode == statusCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unsupported status code " + statusCode));
    }

    @JsonValue
    public int toValue() {
        return this.statusCode;
    }
}
