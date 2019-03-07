import java.sql.Timestamp;
import com.google.gson.*;
import java.security.MessageDigest;
public class Block
{
	//Variables
	private int index;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String data;
	private String hash;
	private String prevhash;
	private Chain c=new Chain();
	//Variables
	public void PrintBlock()
	{
		String data=this.getData();
		String hash=this.getHash();
		String prevhash=this.getPrevhash();
		Timestamp ts = this.getTimestamp();
		int index=this.getIndex();
		System.out.println("Data: " + data);
		System.out.println("Hash: " +hash);
		System.out.println("Previous Hash: " + prevhash);
		System.out.println("Timestamp: " + ts);
		System.out.println("Index: " + index);
		System.out.println();
	}
	public Block(String data,Chain c)
	{
		if (c.blockchain.size()==0)
		{
			prevhash="0";
			this.data=data;
			setHash(data);
			setTimestamp(timestamp);
			this.setIndex(c.blockchain.size());
			c.blockchain.add(this);
			System.out.println();
		}
		else
		{
			prevhash=c.blockchain.get(c.blockchain.size()-1).getHash();
			this.data=data;
			setHash(data);
			setTimestamp(timestamp);
			this.setIndex(c.blockchain.size());
			c.blockchain.add(this);
			System.out.println();
		}
	}
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getPrevhash() {
		return prevhash;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = HashBlock(hash);
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
