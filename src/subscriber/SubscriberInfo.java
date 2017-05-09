package subscriber;

import java.time.LocalDate;

public class SubscriberInfo {
	private long subscriberId;
	private LocalDate subscriberJoinDate;

	public long getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}
	public LocalDate getSubscriberJoinDate() {
		return subscriberJoinDate;
	}
	public void setSubscriberJoinDate(LocalDate subscriberJoinDate) {
		this.subscriberJoinDate = subscriberJoinDate;
	}
	
}
