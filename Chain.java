import java.util.ArrayList;
import java.sql.Timestamp;
public class Chain 
{
	public ArrayList<Block> blockchain=new ArrayList<Block>();
	public void PrintChain()
	{
		for(int i=0; i<this.blockchain.size();i++)
		{
			blockchain.get(i).PrintBlock();
		}
	}
	public boolean validateblocks()
	{
		Block curr;
		Block prev;
		for(int i=1;i<blockchain.size();i++)
		{
			curr=blockchain.get(i);
			prev=blockchain.get(i-1);
			curr.getData();
			curr.setHash();
			prev.getData();
			prev.setHash();
			if(curr.getHash()!=blockchain.get(i).getHash())
			{
				System.out.println("Blockchain Not Valid!");
				return false;
			}
			if(prev.getHash()!=blockchain.get(i-1).getHash())
			{
				System.out.println("Blockchain Not Valid!");
				return false;
			}
			
		}
		System.out.println("Validated\n");
		return true;
	}
	public void Block(String data)
	{
		Block b=new Block();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		if (this.blockchain.size()==0)
		{
			b.setPrevhash("0");
			b.setData(data);
			b.setHash();
			b.setTimestamp(timestamp);
			b.setIndex(this.blockchain.size());
			b.MineBlock(2);
			this.blockchain.add(b);
		}
		else
		{
			b.setPrevhash(this.blockchain.get(this.blockchain.size()-1).getHash());
			b.setData(data);
			b.setHash();
			b.setTimestamp(timestamp);
			b.setIndex(this.blockchain.size());
			b.MineBlock(2);
			this.blockchain.add(b);
		}
	}

}
