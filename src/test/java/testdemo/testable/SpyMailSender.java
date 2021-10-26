package testdemo.testable;

public class SpyMailSender implements MailSender {
    public int counter;

    @Override
    public void sendMail(String recipient, String content) {
        counter++;
    }
}
