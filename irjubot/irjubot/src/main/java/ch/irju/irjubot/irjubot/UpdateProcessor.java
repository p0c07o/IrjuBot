package ch.irju.irjubot.irjubot;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;

class UpdateProcessor {
	private static final TrustManager[] trustAllCerts = new TrustManager[] { 
		new X509TrustManager() {
			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
			}
	
			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
			}
	
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return new java.security.cert.X509Certificate[] {};
			}
		} 
	};

	private static final SSLContext trustAllSslContext;

	static {
		try {
			trustAllSslContext = SSLContext.getInstance("SSL");
			trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (NoSuchAlgorithmException | KeyManagementException e) {
			throw new RuntimeException(e);
		}
	}

	private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();

	private UpdateProcessor() {
		// Hidden constructor.
	}

	static BotApiMethod<?> process(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			String messageText = update.getMessage().getText();
			String fromUser = update.getMessage().getFrom().getUserName();
			CommandType commandType = CommandType.getCommandType(messageText.toLowerCase());
			Long chatId = update.getMessage().getChatId();

			switch (commandType) {
			case TLDR:
				String message = Tldr.processTldrCommand(messageText, chatId);
				return getSendMessage(chatId, message, "Markdown");
			case GOODBYE:
				return getSendMessage(chatId, Messages.getGoodByeMessage(fromUser), "Markdown");
			case HELLO:
				return getSendMessage(chatId, Messages.getHelloMessage(fromUser), "Markdown");
			case URL:
				return getSendMessage(chatId, Messages.getUrlMessage(), "Markdown");
			case IRJU:
				return getSendMessage(chatId, Messages.getIrjuMessage(), "Markdown");
			case BURGER:
				return getSendMessage(chatId, Messages.getBurgerMessage(), null);
			case ZELLO:
				return getSendMessage(chatId, Messages.getZelloMessage(), "Markdown");
			case RESWUE:
				return getSendMessage(chatId, Messages.getReswueMessage(), "Markdown");
			case HELP:
				return getSendMessage(chatId, Messages.getHelpMessage(), "Markdown");
			case WHOCARES:
				return getSendMessage(chatId, Messages.getWhoCaresMessages(), null);
			case NOSHIT:
				return getSendMessage(chatId, Messages.getNoShitMessage(), null);
			// case PROFILE:
			// return getSendPhoto(chatId);
			case SMALLDICK:
				return getSendMessage(chatId, Messages.getWhoGotASmallDickMessage(), null);
			case DREDRE:
				return getSendMessage(chatId, Messages.getDredreMessage(), null);
			case HQ:
				return getSendMessage(chatId, Messages.getHeadquartersMessage(), null);
			case BOULET:
				return getSendMessage(chatId, Messages.getBouletMessage(), null);
			case IRJUBOT:
				return getSendMessage(chatId, Messages.getIrjuBotMessage(), null);
			case ROPLOPLO:
				return getSendMessage(chatId, Messages.getRoploploMessage(), null);
			// case DICTIONARY:
			// return getSendMessage(chatId, Messages.getCorrectedMessage(aText, fromUser),
			// "Markdown");
//			case CP:
//				return getSendMessage(chatId, getSepticycles(), null);
			case OTHER:
			default:
				return null;
			}
		}

		return null;
	}

	private static SendMessage getSendMessage(Long chatId, String message, String parseMode) {
		return new SendMessage().setChatId(chatId).setText(message).disableWebPagePreview().setParseMode(parseMode);
	}

	// private static SendPhoto getSendPhoto(Long chatId) {
	// return new SendPhoto()
	// .setChatId(chatId)
	// .setNewPhoto(new File(IrjuCommand.class.getResource("irju.png").getFile()));
	// }

	private static String getSepticycles() {
		// try {
		// SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		// long baseSeptiDate = format.parse("19.12.2017 00:00:00").getTime();
		// long diff = System.currentTimeMillis() - baseSeptiDate;
		//
		// } catch (ParseException e) {
		// e.printStackTrace();
		// return "ERR";
		// }

		try {
//			OkHttpClient client = new OkHttpClient();
			OkHttpClient client = trustAllSslClient(new OkHttpClient());			
			Request request = new Request.Builder().url("http://septicycl.es/").build();

			Response response = client.newCall(request).execute();
System.out.println(response.body().string());			
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
			return "ERR";
		}
	}

	private static OkHttpClient trustAllSslClient(OkHttpClient client) {
		Builder builder = client.newBuilder();
		builder.sslSocketFactory(trustAllSslSocketFactory, (X509TrustManager) trustAllCerts[0]);
		builder.hostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});
		return builder.build();
	}
}
