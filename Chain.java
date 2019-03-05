import java.util.ArrayList;
public class Chain 
{
	private ArrayList<Block> blockchain=new ArrayList<Block>();

	public ArrayList<Block> getBlockchain() {
		return blockchain;
	}

	public void setBlockchain(ArrayList<Block> blockchain)
	{
		this.blockchain = blockchain;
	}
}
