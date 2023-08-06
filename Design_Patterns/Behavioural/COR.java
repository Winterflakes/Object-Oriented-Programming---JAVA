package Design_Patterns.Behavioural;

class LeaveRequest {
    private int days;
        public LeaveRequest(int days) {
    this.days = days;
    }
    
    public int getDays() {
    return days;
    }
    
    public void setDays(int days) {
    this.days = days;
    }
}

abstract class Approver {
	protected Approver nextApprover; 
	public void approveRequest(LeaveRequest request){
		nextApprover.approveRequest(request);
	}
	public void setNext(Approver approver){
		this.nextApprover = approver;
	}
}


class TeamLeader extends Approver {
 
    @Override
    public void approveRequest(LeaveRequest request) {
        if (request.getDays() <= 5) {
    System.out.println("Leave request approved for " + request.getDays() + " days by Supervisor");
    }
    else {
    super.approveRequest(request);
    }
    
    }
 
}
class Manager extends Approver {
 
    @Override
    public void approveRequest(LeaveRequest request) {
    if (request.getDays() <= 15 && request.getDays() > 5) {
    System.out.println("Leave request approved for " + request.getDays() + " days by Manager");
    } 
    else {
    super.approveRequest(request);
    }
    }
}

class AccountHead extends Approver {
 
    @Override
    public void approveRequest(LeaveRequest request) {
    if (request.getDays() > 15) {
    System.out.println("Leave request approved for " + request.getDays() + " days by AccountHead");
    } 
    else {
    super.approveRequest(request);
    } 
    }
 }

public class COR {
public static void main(String[] args) 
{ 
Approver teamLead = new TeamLeader();
Approver manager = new Manager();
Approver accountHead = new AccountHead();
 
teamLead.setNext(manager);
manager.setNext(accountHead);
 
teamLead.approveRequest(new LeaveRequest(4));
teamLead.approveRequest(new LeaveRequest(40));
teamLead.approveRequest(new LeaveRequest(12));
 
}
 
}

