package ch.irju.irjubot.irjubot;

import java.nio.charset.Charset;

/**
 * Emojis.
 * <p>
 * @see http://apps.timwhitlock.info/emoji/tables/unicode#block-6a-additional-emoticons
 */
public enum Emoji {
	FACE_SCREAMING_IN_FEAR((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB1),
	SMIRKING_FACE((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8F),
	BURGER((byte)0xF0, (byte)0x9F, (byte)0x8D, (byte)0x94),
	SMILING_FACE_WITH_HEART_SHAPED_EYES((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8D),
	FACE_WITH_TEARS_OF_JOY((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x82),
	GRINNING_FACE_WITH_SMILING_EYES((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x81),
	HEAVY_MINUS_SIGN((byte)0xE2, (byte)0x9E, (byte)0x96),
	WAVING_HAND_SIGN((byte)0xF0, (byte)0x9F, (byte)0x91, (byte)0x8B),
	RAISED_HAND((byte)0xE2, (byte)0x9C, (byte)0x8B),
	RELIEVED_FACE((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8C),
	FACE_THROWING_A_KISS((byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x98);
	
	private final byte[] bytes;
	
	private Emoji(byte... theBytes) {
		bytes = theBytes;
	}
	
	@Override
	public String toString() {
		return new String(bytes, Charset.forName("UTF-8"));
	}
}
