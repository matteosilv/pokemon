package org.matteosilv;

public class Translation {
    public Contents contents;

    public Contents getContents() {
        return contents;
    }

    public static class Contents {
        public String translated;

        public String getTranslated() {
            return translated;
        }
    }
}
