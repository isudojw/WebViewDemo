package cc.jerrywang.webviewdemo.web.config;


public enum WhiteDomain {

    // TODO : add or rewrite website domain name at here
    GITHUB ("github.com"),
    GOOGLE ("google.com");

    String domainName;

    WhiteDomain(String domainName) {
        this.domainName = domainName;
    }

    public static Boolean containsName(String domainName) {
        for (WhiteDomain name : WhiteDomain.values()) {
            if (name.toString().contains(domainName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
