import java.util.ArrayList;
public class Chain 
{
	public ArrayList<Block> blockchain=new ArrayList<Block>();
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
			curr.getData();
			curr.setHash();
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

}
