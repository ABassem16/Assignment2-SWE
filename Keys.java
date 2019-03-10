import java.security.*;
import java.util.Base64;
public class Keys 
{
	private PrivateKey prvkey;
	private String prvkeystr;
	public String pubkeystr;
	public PublicKey pubkey;
	public Keys()
	{
		KeyGenerator();
	}
	public void KeyGenerator()
	{
		try
		{
				KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
				keyGen.initialize(2048);
		        KeyPair keyPair = keyGen.generateKeyPair();
		        prvkey = keyPair.getPrivate();
		        pubkey = keyPair.getPublic();
		        pubkeystr=Base64.getEncoder().encodeToString(pubkey.getEncoded());
		        prvkeystr=Base64.getEncoder().encodeToString(prvkey.getEncoded());
			}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	public String getPrvkeystr() {
		return prvkeystr;
	}
	public void setPrvkeystr(String prvkeystr) {
		this.prvkeystr = prvkeystr;
	}
}

