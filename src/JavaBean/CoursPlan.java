package JavaBean;

public class CoursPlan {

	private int planId;
	
	private String batchId;
	
	private int daynumber;
	
	private String topic;
	
	private String date;
	
	private boolean status;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public int getDaynumber() {
		return daynumber;
	}

	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "CoursPlan [planId=" + planId + ", batchId=" + batchId + ", daynumber=" + daynumber + ", topic=" + topic
				+ ", date=" + date + ", status=" + status + "]";
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
