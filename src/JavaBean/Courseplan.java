package JavaBean;

public class Courseplan {

	private int planId;
	private String batchId;
	private int daynumber;
	private String topic;
    private String status;
	
    
    public Courseplan(int planId, String batchId, int daynumber, String topic, String status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}


	public Courseplan() {
		// TODO Auto-generated constructor stub
	}


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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Courseplan [planId=" + planId + ", batchId=" + batchId + ", daynumber=" + daynumber + ", topic=" + topic
				+ ", status=" + status + "]";
	}


	public void setBatchId(int batchId2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
