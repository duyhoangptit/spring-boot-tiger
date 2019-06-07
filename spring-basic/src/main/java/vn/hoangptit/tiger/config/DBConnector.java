package vn.hoangptit.tiger.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DBConnector {

    private String url;

    public abstract void connect();
}
