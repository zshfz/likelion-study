package java_basic;

public class SendMain {
	public static void main(String[] args) {
		Sender[] senders = { new EmailSender(), new SmsSender(), new FaceBookSender() };
		for (Sender sender : senders) {
			sender.sendMessage("환영합니다!");
		}
	}
}

class EmailSender implements Sender{

	@Override
	public void sendMessage(String message) {
		System.out.println("메일을 발송합니다: " + message);
	}
	
}

class SmsSender implements Sender{
	@Override
	public void sendMessage(String message) {
		System.out.println("SMS를 발송합니다: " + message);
	}
}

class FaceBookSender implements Sender{
	@Override
	public void sendMessage(String message) {
		System.out.println("페이스북에 발송합니다: " + message);
	}
}