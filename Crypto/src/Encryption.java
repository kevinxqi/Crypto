/**
 * This class provides the methods for encryption 
 * @author Kevin Qi
 *
 */
public class Encryption {
	
	public static String normalizeText(String s) 
	{
		String withoutSpace = s.replace(" ", "");
		String withoutSpaceAndPunc = "";
		for(Character c: withoutSpace.toCharArray()) 
		{
			if(Character.isLetter(c)) 
			{
				withoutSpaceAndPunc += c;
			}
		}
		String normalizedText = withoutSpaceAndPunc.toUpperCase();
		return normalizedText;
	}
	
	public static String obify(String text) {
		String obifyedText = "";
		for (int k=0; k<text.length(); k++) 
		{
			if (text.charAt(k) == 'A' || text.charAt(k) == 'E' || text.charAt(k) == 'I' || text.charAt(k) == 'O' || text.charAt(k) == 'U' || text.charAt(k) == 'Y') 
			{
				obifyedText += "OB" + text.charAt(k);
			}
			else 
			{
				obifyedText += text.charAt(k);
			}
		}
		return obifyedText;
	}
	
	public static String caesarify(String rawText, int shift) 
	{
		int shiftValue = shift % 26;
		String safeText = "";
		for(Character c: rawText.toCharArray()) 
		{
	
			char shiftedLetter = (char) ( (((int)(c) + shiftValue) ));
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
	
	public static String groupify(String text, int lettersPerGroup) 
	{
		String splitText = "";
		for(int i=0; i<text.length(); i+= lettersPerGroup) 
		{
			if(i+lettersPerGroup > text.length()) 
			{
				splitText += text.substring(i);
				for(int j = 1; j + text.substring(i).length() <= lettersPerGroup; j++) {
					splitText += "x";
				}
			}
			else 
			{
			splitText += text.substring(i, i+lettersPerGroup) + " ";
			}
		}
		
		return splitText;
	}
	
	public static String encryptString(String text, int shift, int groupSize) {
		String normalizedText = normalizeText(text);
		String obifiedText = obify(normalizedText);
		String caesarifiedText = caesarify(obifiedText, shift);
		String encryptedText = groupify(caesarifiedText, groupSize);
		return encryptedText;
		
	}

}
