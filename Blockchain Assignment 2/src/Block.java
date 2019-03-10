import java.sql.Timestamp;
import java.security.MessageDigest;
public class Block
{
	//Variables
	private int index;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String data;
	private String hash;
	private String prevhash;
	private int nonce;
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
	public void MineBlock(int difficulty)
	{
		String zeros = new String(new char[difficulty]).replace('\0', '0'); 
		while(!this.hash.substring( 0, difficulty).equals(zeros))
		{
			nonce ++;
			setHash();
			hash=getHash();
		}
		System.out.println("Block Signed.");
		System.out.println("New Hash = " + this.hash);
		System.out.println(nonce);
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
	public void setPrevhash(String prev)
	{
		this.prevhash=prev;
	}
	public String getHash() {
		return hash;
	}
	public void setHash() {
		this.hash = HashBlock(this.data + this.prevhash + this.timestamp.toString() + this.nonce);
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
}
