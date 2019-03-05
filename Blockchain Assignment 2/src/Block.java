import java.sql.Timestamp;
import java.security.MessageDigest;
public class Block
{
	private int index;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String data;
	private String hash;
	private String prevhash;
	public void sha(String input)
	{
	try 
	{
		
	MessageDigest digest = MessageDigest.getInstance("SHA-256");
	byte[] sha = digest.digest(input.getBytes());
	System.out.println(sha);
	}
	catch(Exception ex)
	{
		throw new RuntimeException(ex);
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
	public void setPrevhash(String prevhash) {
		this.prevhash = prevhash;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public static void main(String[] args)
	{
		Block b=new Block();
		Timestamp ts=b.getTimestamp();
		System.out.println(ts);
		String x="Hello";
		b.sha(x);
	}
}
