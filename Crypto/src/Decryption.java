/**
 * This class provides the methods for decryption
 * @author Kevin Qi
 *
 */
public class Decryption {
	
	public static String ungroupify(String text) 
	{
		String ungroupifiedTextSpace = text.replace(" ", "");
		String ungroupifiedText = ungroupifiedTextSpace.replace("x", "");
		return ungroupifiedText;
	}
	
	public static String unobify(String text) 
	{
		String unobifiedTextOs = text.replace("OBO", "O");
		String unobifiedText = unobifiedTextOs.replace("OB", "");
		return unobifiedText;
	}
	
	public static String uncaesarify(String text, int shift) 
	{
		int shiftValue = shift % 26;
		String safeText = "";
		for(Character c: text.toCharArray()) 
		{
	
			char shiftedLetter = (char) ( (((int)(c) - shiftValue) ));
			if (shiftedLetter>'Z') 
			{
				shiftedLetter -= 26;
			}
			if (shiftedLetter < 'A') 
			{
				shiftedLetter += 26;
			}
			
			safeText += shiftedLetter;
		}
		return safeText;
	}
	
	public static String decryptString(String text, int shift) {

	String ungroupifiedText = ungroupify(text);
	String uncaesarifiedText = uncaesarify(ungroupifiedText, shift);
	String decryptedText = unobify(uncaesarifiedText);
	return decryptedText;
	}
}
