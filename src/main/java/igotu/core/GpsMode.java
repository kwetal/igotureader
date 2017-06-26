package igotu.core;

/**
 * Created by in568bax on 2017-06-26.
 */
public enum GpsMode {
    GpsDongleMode(0x00),
    GpsTracerMode(0x01),
    GpsConfigureMode(0x03);
    private final byte mode;
    GpsMode(int xx) {
        mode = (byte)xx;
    }
}
