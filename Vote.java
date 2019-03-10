import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;

public class Vote
{
	public String voterpublickey;
	private String choice;
	private String Signature;
	protected ArrayList<Chain> candidates=new ArrayList<>();
	private Block b=new Block();
	private static int voteid;
	protected Keys k=new Keys();
	public String HashBlock(String input)
	{	try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			/*StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++)
			{
				String hex = Integer.toHexString(0xff & hash[i]);
				hexString.append(hex);
			}*/
			String hashtext="";
			for(int i=0;i<hash.length;i++)
			{
				String hexa=Integer.toHexString(0xff & hash[i]);
				hashtext+=hexa;
			}
			return hashtext;
		}
		catch(Exception e) {
		throw new RuntimeException(e);
		}
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature() {
		Signature = generateSignature();
	}
	public Vote()
	{
		this.voterpublickey=Base64.getEncoder().encodeToString(k.pubkey.getEncoded());
        this.voteid++;
        setSignature();
        this.Signature=getSignature();
	}
	public static int getVoteid() {
		return voteid;
	}
	public static void setVoteid(int voteid) {
		Vote.voteid = voteid;
	}
	public String generateSignature()
	{
		String data =voterpublickey+ Integer.toString(voteid);
		data=HashBlock(data);
		return data;
	}
	public Block getB() {
		return b;
	}
	public void setB(Block b) {
		this.b = b;
	}
}