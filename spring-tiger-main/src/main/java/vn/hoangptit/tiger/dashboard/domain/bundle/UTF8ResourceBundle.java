package vn.hoangptit.tiger.dashboard.domain.bundle;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class UTF8ResourceBundle extends ResourceBundle {

    public UTF8ResourceBundle(String baseName, Locale locale) {
        this.setParent(ResourceBundle.getBundle(baseName, locale,
                new UTF8ResourceBundle.UTF8Control("properties")));
    }

    protected Object handleGetObject(String key) {
        return this.parent.getObject(key);
    }

    public Enumeration<String> getKeys() {
        return this.parent.getKeys();
    }

    private class UTF8Control extends Control {
        private final String resource;

        public UTF8Control(String resourceName) {
            this.resource = resourceName;
        }

        public ResourceBundle newBundle(String baseName, Locale locale, String format,
                                        ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            String bundleName = this.toBundleName(baseName, locale);
            String resourceName = this.toResourceName(bundleName, this.resource);
            ResourceBundle bundle = null;
            InputStream stream = null;
            if (reload) {
                URL url = loader.getResource(resourceName);
                if (url != null) {
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        stream = connection.getInputStream();
                    }
                }
            } else {
                stream = loader.getResourceAsStream(resourceName);
            }

            if (stream != null) {
                try (InputStreamReader inputStream = new InputStreamReader(stream, "UTF-8")) {
                    bundle = new PropertyResourceBundle(inputStream);
                } finally {
                    stream.close();
                }
            }

            return bundle;
        }
    }

}
