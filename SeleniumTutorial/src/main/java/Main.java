import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main( String args[] ) {

        LOG.trace("log trace");
        LOG.trace("log trace with arguments '{}'", "arg");

        LOG.warn("log warn");
        LOG.warn("log warn with arguments '{}'", "arg");

        LOG.info("log info");
        LOG.info("log info with arguments '{}'", "arg");

        LOG.debug("log debug");
        LOG.debug("log debug with arguments '{}", "arg");

        LOG.error("log error");
        LOG.error("log error with arguments '{}'", "arg");
    }
}