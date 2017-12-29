package ch.irju.irjubot.irjubot;

public enum CommandType {
	HELP("/help"),
	TLDR("/tldr"),
	URL("/url"),
	IRJU("/irju"),
	ZELLO("/zello", "installe zello", "installer zello", "setup zello"),
	RESWUE("/reswue", "installe reswue", "installer reswue", "setup reswue"),
	HELLO("salut", "hello", "hallo", "bonjour", "guten tag", "grüezi mitenand", "hallo zusammen", "salut tlm", "salut tout le monde", "salut les gens"),
	GOODBYE("bye", "au revoir", "tsch�ss", "ciao", "bonne nuit"),
	WHOCARES("lawson"),
	BURGER("burger"),
	NOSHIT("qui s'en fout"),
	PROFILE("profile"),
	SMALLDICK("ptit zizi", "p'tit zizi"),
	DREDRE("dredre"),
	HQ("qg irju"),
	BOULET("boulet"),
	IRJUBOT("irjubot", "@irju"),
	ROPLOPLO("roploplo"),
	OTHER(),
	CP("/cp", "Septicycles");
	
	private final String[] tokens;
	
	private CommandType(String... theTokens) {
		tokens = theTokens;
	}
	
	public static CommandType getCommandType(String message) {
		for (CommandType commandType : CommandType.values()) {
			for (String aToken : commandType.tokens) {
				if (message.trim().startsWith("/") && message.toLowerCase().startsWith(aToken)) {
					return commandType;
				} else if (message.toLowerCase().indexOf(aToken) > -1) {
					return commandType;
				}
			}
		}
		
		return OTHER;
	}
}
