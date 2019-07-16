package vn.hoangptit.tiger.dashboard.domain.util;



import vn.hoangptit.tiger.dashboard.domain.common.Locate;

import java.text.MessageFormat;

public class LanguageBundleUtil {

    public static Locate getLocate() {
        return BundleUtil.getDefaultLocate();
    }

    public static String getText(String key) {
        return BundleUtil.getText(getLocate(), key);
    }

    public static String getText(String key, Object... params) {
        return MessageFormat.format(getText(key), params);
    }

}
