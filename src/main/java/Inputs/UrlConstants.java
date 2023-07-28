package Inputs;

public enum UrlConstants {

    BASE_URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    private String url;
    UrlConstants(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
