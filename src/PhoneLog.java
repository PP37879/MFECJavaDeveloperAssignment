import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneLog {
	private long callingTime;
	private transient Date startTime;
	private transient Date endTime;
	private String phoneNumber;
	private String promotion;
	private String startT;
	private String endT;
	private String day;
	private int callFee;
	
	public PhoneLog(String day,String startT, String endT, String phoneNumber, String promotion) {
		this.day = day;
		this.startT = startT;
		this.endT = endT;
		this.phoneNumber = phoneNumber;
		this.promotion = promotion;
		this.callFee = 0;
	}

	public PhoneLog(String phoneNumber,int callFee,int callingTime) {
		this.phoneNumber = phoneNumber;
		this.callFee = callFee;
		this.callingTime = callingTime;
	}
	
	public long getCallingTime() {
		return callingTime;
	}

	public void setCallingTime(long callingTime) {
		this.callingTime = callingTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public String getStartT() {
		return startT;
	}

	public void setStartT(String startT) {
		this.startT = startT;
	}

	public String getEndT() {
		return endT;
	}

	public void setEndT(String endT) {
		this.endT = endT;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	public void setCallFee(int callFee) {
		this.callFee = callFee;
	}
	
	public int getCallFee() {
		return callFee;
	}
	
	public void calculateCallingTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			this.startTime = format.parse(startT);
			this.endTime = format.parse(endT);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		callingTime = endTime.getTime() - startTime.getTime();
		callingTime = callingTime/(60*1000)%60;
		if(callingTime == 1) {
			callFee = 3;
		}else {
			int restFee = (int)callingTime-1;
			callFee = 3+restFee;
		}
	}
	
}
