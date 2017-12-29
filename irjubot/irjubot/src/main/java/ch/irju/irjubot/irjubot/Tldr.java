package ch.irju.irjubot.irjubot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handles TLDR commands.
 * 
 * @author poco
 */
final class Tldr {
	private static final String ADD = "add";
	private static final String REMOVE = "remove";
	private static final String DIR = "." + File.separator + "tldr";
	
	static String processTldrCommand(String message, Long chatId) {
		if ("/tldr".equals(message.toLowerCase().trim())) {
			return listTldr(chatId);
		}
		
		String[] splittedMessage = message.split(" ");
		
		if (splittedMessage.length > 1 && ADD.equals(splittedMessage[1].toLowerCase().trim())) {
			return addTldr(message.substring(message.indexOf(ADD) + ADD.length() + 1), chatId);
		} else if (splittedMessage.length > 1 && REMOVE.equals(splittedMessage[1].toLowerCase().trim())) {
			if (splittedMessage.length > 2 && isAnInteger(splittedMessage[2])) {
				int lineNumber = Integer.parseInt(splittedMessage[2]);
				return removeTldr(message, lineNumber, chatId);
			} else {
				return unknownTldr(message); 
			}
		} else {
			return unknownTldr(message);
		}
	}
	
	private static boolean isAnInteger(String token) {
		try {
			return token != null && token.length() > 0 && Integer.parseInt(token) > 0;
		} catch (NumberFormatException anException) {
			return false;
		}	
	}

	private static String listTldr(Long chatId) {
		File file = getFile(chatId);
		
		if (!file.exists()) {
			return "*TLDR* - ERR: Le TLDR est vide!";
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("*TLDR*\n\n");

			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = null;
				int counter = 1;
				
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(counter++ + ": " + line + "\n");
				}
				
				reader.close();
			} catch (IOException anException) {
				return "*TLDR* - ERR: " + anException.getMessage();
			}
			
			return stringBuilder.toString();
		}
	}

	private static String addTldr(String message, Long chatId) {
		File file = getFile(chatId);
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.append(message + "\n");
			writer.flush();
			writer.close();
		} catch (IOException anException) {
			return "*TLDR* - ERR: " + anException.getMessage();
		}
		
		return "*TLDR* - Message ajouté au TLDR!";
	}

	private static String removeTldr(String message, int lineToDelete, Long chatId) {
		File file = getFile(chatId);
		StringBuilder content = new StringBuilder();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			int counter = 1;
			
			while ((line = reader.readLine()) != null) {
				if (lineToDelete != counter++) {
					content.append(line + "\n");
				}
			}
			
			reader.close();
			
			FileWriter writer = new FileWriter(file);
			writer.write(content.toString());
			writer.flush();
			writer.close();
		} catch (IOException anException) {
			return "*TLDR* - ERR: " + anException.getMessage();
		}

		return "*TLDR* - Ligne " + lineToDelete + " effacée du TLDR!";
	}

	private static String unknownTldr(String message) {
		return "*TLDR* - ERR: commande inconnue";
	}
	
	private static File getFile(Long chatId) {
		File dir = new File(DIR);

		if (!dir.exists()) {
			dir.mkdir();
		}
	
		return new File(dir, "messages." + chatId + ".tldr");
	}
}
