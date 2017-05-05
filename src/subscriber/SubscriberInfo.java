package subscriber;

import java.util.Date;

public class SubscriberInfo {
	private long subscriberId;
	private Date subscriberJoinDate;

	public long getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}
	public Date getSubscriberJoinDate() {
		return subscriberJoinDate;
	}
	public void setSubscriberJoinDate(Date subscriberJoinDate) {
		this.subscriberJoinDate = subscriberJoinDate;
	}
	
}
