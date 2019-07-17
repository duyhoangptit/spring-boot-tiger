package vn.hoangptit.tiger.dashboard.util;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import vn.hoangptit.tiger.dashboard.bundle.UTF8ResourceBundle;
import vn.hoangptit.tiger.dashboard.common.Locate;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class BundleUtil {

    private static final Logger logger = LoggerFactory.getLogger(BundleUtil.class);
    private static HashMap<Locate, ResourceBundle> resourceBundleMap;
    private static String languageLocation = "messages";
    private static Locate defaultLocate = new Locate("vi", "VN");

    static {
        resourceBundleMap = Maps.newHashMap();
        resourceBundleMap.put(defaultLocate, new UTF8ResourceBundle(languageLocation,
                new Locale(defaultLocate.getLanguage(), defaultLocate.getCountry())));
    }

    private List<Locate> supportedLanguages;

    public BundleUtil() {

    }

    public static String getText(String key) {
        String result = key;
        try {
            ResourceBundle bundle = resourceBundleMap.get(LocaleContextHolder.getLocale().toString());
            if (key != null) {
                result = bundle.getString(key);
            }
            return result;
        } catch (Exception var4) {
            return key;
        }
    }

    public static String getText(Locate locate, String key) {
        String result = key;

        try {
            ResourceBundle bundle = resourceBundleMap.get(locate);
            if (key != null) {
                result = bundle.getString(key);
            }
            return result;
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
            return key;
        }
    }

    private static <T> T getFieldValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(object);
        } catch (Exception var3) {
            logger.error(var3.getMessage(), var3);
            return null;
        }
    }

    public static Locate getDefaultLocate() {
        return defaultLocate;
    }

    public List<Locate> getSupportedLanguages() {
        return supportedLanguages;
    }

    public void setSupportedLanguages(List<Locate> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
        this.supportedLanguages.forEach(x -> resourceBundleMap.put(x, new UTF8ResourceBundle(languageLocation,
                new Locale(x.getLanguage(), x.getCountry()))));
    }

}
