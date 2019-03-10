import java.security.*;
import java.security.spec.ECGenParameterSpec;
public class Keys 
{
	public PrivateKey prvkey;
	public PublicKey pubkey;
	public Keys()
	{
		KeyGenerator();
	}
	public void KeyGenerator()
	{
		try {
				KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
				keyGen.initialize(ecSpec, random);
				KeyPair keyPair = keyGen.generateKeyPair();
	        	prvkey = keyPair.getPrivate();
	        	pubkey = keyPair.getPublic();
			}
		catch(Exception e)
			{
				throw new RuntimeException(e);
			}
	}
}

