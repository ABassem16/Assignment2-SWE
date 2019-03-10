import java.util.*;
public class Interface
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Add Number of Candidates");
		int cand=scan.nextInt();
		Vote v=new Vote();
		int x=scan.nextInt();
		for(int i=0;i<cand;i++)
			{
				Chain c=new Chain();
				v.candidates.add(c);
			}
		while(true)
		{
			if(x==0)
			{
				break;
			}
			if(x==1)
			{
				System.out.println("Pick Your Candidate or end vote 0");
				int vote=-1;
				while(vote!=0)
				{
				vote=scan.nextInt();
				if(vote>=cand || vote<0)
				{
					System.out.println("Invalid Choice");
					break;
				}
				v.candidates.get(vote+1).Block(Integer.toString(vote));
				}
			}
			if(x==2)
			{
				for(int i=0;i<v.candidates.size();i++)
				{
					int max=v.candidates.get(i).blockchain.get(0).getIndex();
					for(int j=1;j<v.candidates.get(i).blockchain.get(j).getIndex();j++)
					{
						if(max<v.candidates.get(i).blockchain.get(j).getIndex())
						{
							max=v.candidates.get(i).blockchain.get(j).getIndex();
						}
					}
					
				}
			}
		}
		scan.close();
	}
}
/*
Data: b
Hash: 3e23e816039594a33894f6564e1b1348bbd7a088d42c4acb73eeaed59c09d
Previous Hash: ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb
Timestamp: 2019-03-07 15:37:40.433
Index: 1

Data: 1
Hash: 6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b
Previous Hash: 3e23e816039594a33894f6564e1b1348bbd7a088d42c4acb73eeaed59c09d
Timestamp: 2019-03-07 15:37:40.433
Index: 2

Data: a
Hash: ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb
Previous Hash: 0
Timestamp: 2019-03-07 15:37:40.418
Index: 0
*/
