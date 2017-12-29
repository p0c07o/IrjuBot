package ch.irju.irjubot.irjubot;

import static ch.irju.irjubot.irjubot.Emoji.BURGER;
import static ch.irju.irjubot.irjubot.Emoji.FACE_THROWING_A_KISS;
import static ch.irju.irjubot.irjubot.Emoji.FACE_WITH_TEARS_OF_JOY;
import static ch.irju.irjubot.irjubot.Emoji.GRINNING_FACE_WITH_SMILING_EYES;
import static ch.irju.irjubot.irjubot.Emoji.RAISED_HAND;
import static ch.irju.irjubot.irjubot.Emoji.RELIEVED_FACE;
import static ch.irju.irjubot.irjubot.Emoji.SMILING_FACE_WITH_HEART_SHAPED_EYES;
import static ch.irju.irjubot.irjubot.Emoji.SMIRKING_FACE;

final class Messages {
	private Messages() {
		// Hidden constructor.
	}
	
	static String getHelpMessage() {
		StringBuilder aText = new StringBuilder();
		aText.append("Bonjour, je suis le bot IRJU! Je suis là pour vous aider et pour rendre votre vie plus bleue! " 
			+ GRINNING_FACE_WITH_SMILING_EYES + "\n\n");
		aText.append("Voici la liste des commandes:\n\n");
		aText.append("[/help](tg://bot_command?command=help&bot=irju) - Liste des commandes\n");
		aText.append("[/zello](tg://bot_command?command=zello&bot=irju) - Instructions Zello\n");
		aText.append("[/reswue](tg://bot_command?command=reswue&bot=irju) - Instructions Reswue\n");
		aText.append("[/irju](tg://bot_command?command=irju&bot=irju) - Infos IRJU\n");
		aText.append("[/url](tg://bot_command?command=url&bot=irju) - Adresses importantes\n");
		aText.append("[/tldr](tg://bot_command?command=tldr&bot=irju) - Liste le contenu du TLDR\n");
		aText.append("/tldr add Xxxxx - Ajoute le message Xxxxx à la fin du TLDR\n");
		aText.append("/tldr remove n - Efface le message numéro n du TLDR\n\n");
		aText.append("Je contiens plein d'autres fonctionnalités cachées... "
			+ "à vous de les découvrir! " + SMIRKING_FACE);
		return aText.toString();
	}

	static String getZelloMessage() {
		StringBuilder aText = new StringBuilder();
		aText.append("*Setup Zello*\n\n");
		aText.append("1) Télécharger l'application ");
		aText.append("pour [Android](https://play.google.com/store/apps/details?id=com.loudtalks&hl=fr) ");
		aText.append("ou pour [iPhone](https://itunes.apple.com/us/app/zello-walkie-talkie/id508231856?mt=8)\n");
		aText.append("2) Créer un compte\n\n");
		aText.append("C'est tout! " + GRINNING_FACE_WITH_SMILING_EYES + "\n\n");
		aText.append("Les utilisateurs Android peuvent également télécharger [Zello Overlay]"
				+ "(https://play.google.com/store/apps/details?id=com.zachbarrett.zellooverlay&hl=fr) "
				+ "afin de pouvoir actionner Zello depuis n'importe quelle application!");
		return aText.toString();
	}
	
	static String getReswueMessage() {
		StringBuilder aText = new StringBuilder();
		aText.append("*Setup Reswue*\n");
		aText.append("Reswue est l'outil utilisé par la Résistance et seulement par la Résistance pour planifier "
				+ "et notifier les agents lors d'opérations. Ce tool est confidentiel, n'en parlez donc jamais "
				+ "aux joueurs verts!\n\n");
		aText.append("Il vous faut obtenir une autorisation pour utiliser Reswue. Commencez par vous connecter "
				+ "à [Reswue Europe](https://ops.irde.net/iitc/reswue/my.php) et connectez-vous grâce à votre "
				+ "compte Google+. Puis envoyez un message à [p0c07o](https://web.telegram.org/#/im?p=@p0c07o) "
				+ "afin qu'il vous valide!\n\n");
		aText.append("Il existe 3 moyens d'utiliser Reswue:\n");
		aText.append("1) Via l'[interface Web](https://ops.irde.net/iitc/reswue/my.php)\n");
		aText.append("2) Via le client mobile pour [Android]"
				+ "(https://play.google.com/store/apps/details?id=net.irde.ops.agentclient) "
				+ "ou pour [iPhone](https://itunes.apple.com/us/app/reswue-client/id971201245?l=de&ls=1&mt=8)\n");
		aText.append("3) Via le [plugin IITC](https://ops.irde.net/iitc/reswue.user.js)");
		return aText.toString();
	}

	static String getIrjuMessage() {
		StringBuilder aText = new StringBuilder();
		aText.append("*IRJU*\n\n");
		aText.append("Voici les informations et adresses importantes à connaître concernant notre team:\n\n");
		aText.append("1) Notre [communauté Google+](https://plus.google.com/communities/113582481918232084310)\n");
		aText.append("2) Notre [site web](http://www.irju.ch)\n");
		aText.append("3) Notre adresse email: info@irju.ch\n\n");
		return aText.toString();
	}

	static String getUrlMessage() {
		StringBuilder aText = new StringBuilder();
		aText.append("*Quelques adresses importantes*\n");
		aText.append("- [Ingress](https://www.ingress.com/)\n");
		aText.append("- [Ingress Events](https://www.ingress.com/events)\n");
		aText.append("- [Ingress Investigate](http://investigate.ingress.com/)\n");
		aText.append("- [Ingress Intel](https://www.ingress.com/intel)\n");
		aText.append("- [Histoire de la RES suisse](http://swiss-ingress.ch/)\n");
		aText.append("- [RES Suisse (IRS)](http://www.ingressistance.ch/fr/)\n");
		aText.append("- [RES Suisse Romande (IRSR)](http://www.ingressistance.ch/fr/)\n");
		aText.append("- [RES Jura (IRJU)](http://www.irju.ch/)");
		return aText.toString();
	}

	static String getBurgerMessage() {
		return "Burger? Quelqu'un a dit burger? " 
			+ BURGER + BURGER + BURGER 
			+ " " + SMILING_FACE_WITH_HEART_SHAPED_EYES;
	}
	
	static String getWhoCaresMessages() {
		return "On s'en bat les steaks! " +
				FACE_WITH_TEARS_OF_JOY + 
				FACE_WITH_TEARS_OF_JOY +
				FACE_WITH_TEARS_OF_JOY;
	}
	
	static String getNoShitMessage() {
		return
			RAISED_HAND + " " + 
			RAISED_HAND + " " + 
			RAISED_HAND + " " + 
			RAISED_HAND;
	}
	
	static String getHelloMessage(String theUsername) {
		return "Bonjour *" + theUsername + "*!";
	}

	static String getGoodByeMessage(String theUsername) {
		return "Au revoir *" + theUsername + "*!";
	}

	static String getWhoGotASmallDickMessage() {
		return "Un p'tit zizi? Ah, on parle de Raph apparemment! " + FACE_WITH_TEARS_OF_JOY;
	}

	static String getDictatorMessage() {
		return "Le seul, le vrai, l'unique dictateur, c'est Poco, notre Maître à tous! Ooooommmmm " + RELIEVED_FACE;
	}

	static String getDredreMessage() {
		return "Dredre? Qu'a-t'il encore fait celui-là?";
	}

	static String getHeadquartersMessage() {
		return "Bienvenue chez Marc-le-jeune, QG officiel de la IRJU!";
	}

	static String getBouletMessage() {
		return "Qui est un boulet? Raph!!! " + FACE_WITH_TEARS_OF_JOY;
	}

	static String getIrjuBotMessage() {
		return "Tu m'as appelé, chéri(e)? " + FACE_THROWING_A_KISS;
	}

	static String getRoploploMessage() {
		return "Roploploooooooo! " + GRINNING_FACE_WITH_SMILING_EYES;
	}

//	static String getCorrectedMessage(String theMessage, String theUsername) {
//		for (String aToken : Correcteur.getTokens()) {
//			if (theMessage.contains(aToken)) {
//				return theUsername + ", essaie plut�t avec *" + Correcteur.getCorrection(aToken) + "*!";
//			}
//		}
//
//		return null;
//	}
}
