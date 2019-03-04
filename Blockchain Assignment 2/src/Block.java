
public class Block
{
	private int index;
	private int timestamp;
	private String data;
	private int hash;
	private int prevhash;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getPrevhash() {
		return prevhash;
	}
	public void setPrevhash(int prevhash) {
		this.prevhash = prevhash;
	}
	public int getHash() {
		return hash;
	}
	public void setHash(int hash) {
		this.hash = hash;
	}
}
