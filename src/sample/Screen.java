package sample;

public class Screen implements ScreenSpec {
    public String resolution;
    public int refreshRate;
    public int responseTime;

    @Override
    public String getResolution() {
        return null;
    }

    @Override
    public int getRefreshRate() {
        return 0;
    }

    @Override
    public int getResponseTime() {
        return 0;
    }

    public String toString(String resolution, int refreshRate, int responseTime) {
        return "Resolution:" + resolution +
                "\nRefresh Rate:" + refreshRate +
                "\nResponse Time:" + responseTime;
    }
}
