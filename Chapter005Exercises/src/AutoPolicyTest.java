
public class AutoPolicyTest 
{

	public static void main(String[] args) 
	{
	AutoPolicy policy1 = new AutoPolicy(111, "Toyota Camry", "NJ");
	AutoPolicy policy2 = new AutoPolicy(222, "Ford Fusion", "ME");
	
	policyInNoFaultState(policy1);
	policyInNoFaultState(policy2);
	
	policy1.setState("CT");
	
	policyInNoFaultState(policy1);
	
	}

	static void policyInNoFaultState (AutoPolicy policy)
	{
		System.out.printf("The auto policy:%n"
				+ "Account #: %d; Car: %s; State: %s%n"
				+ "Policy %s in a no Fault State.%n%n"
				,policy.getAccountNumber(),policy.getMakeAndModel(),policy.getState(),
				(policy.isNoFaultState() ? "is" : "is not"));
		
		
	}
	
	
	
}
