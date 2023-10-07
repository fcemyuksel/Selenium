package utilities;

public class ReusableMethods {
    public static void bekle(int saniye) throws InterruptedException {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
