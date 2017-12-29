package ch.irju.irjubot.irjubot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * IRJU bot.
 * <p>
 * Based on Telegram Bot Java Library
 * 
 * @see https://github.com/rubenlagus/TelegramBots
 * @see https://github.com/rubenlagus/TelegramBots/wiki/Getting-Started
 */
public class IrjuBot extends TelegramLongPollingBot  {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		
		try {
			telegramBotsApi.registerBot(new IrjuBot());
		} catch (TelegramApiException exception) {
			exception.printStackTrace();
		}
	}	

	@Override
	public String getBotToken() {
//		return Config.TEST_BOT_TOKEN;
		return Config.REAL_BOT_TOKEN;
	}
	
	public String getBotUsername() {
		return Config.BOT_NAME;
	}
	
	public void onUpdateReceived(Update update) {
		BotApiMethod<?> method = UpdateProcessor.process(update);
		
		if (method != null) {
			try {
				execute(method);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}
}
