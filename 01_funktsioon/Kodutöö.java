public static int randomInt(int min, int max) {
    return (int)(Math.random() * (max - min + 1)) + min;
}


public static String randomString(int length) {
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
        int index = (int)(Math.random() * chars.length());
        sb.append(chars.charAt(index));
    }
    return sb.toString();
}


public static boolean randomBoolean() {
    return Math.random() < 0.5;
