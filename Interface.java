
public class Interface
{
	public static void main(String[] args)
	{
		Chain c=new Chain();
		c.Block("a");
		c.Block("b");
		c.Block("c");
		c.PrintChain();
		c.blockchain.get(0).MineBlock(4);

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
