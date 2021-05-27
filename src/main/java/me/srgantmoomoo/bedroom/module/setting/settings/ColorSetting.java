package me.srgantmoomoo.bedroom.module.setting.settings;

import me.srgantmoomoo.bedroom.api.font.JColor;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.Setting;

public class ColorSetting extends Setting {

	private boolean rainbow;
	private JColor value;

	public ColorSetting (String name, Module parent, final JColor value) {
		this.name = name;
		this.parent = parent;
		this.value = value;
	}
	
	public JColor getValue() {
		if (rainbow) {
			return getRainbow(0, this.getColor().getAlpha());
		}
		return this.value;
	}

	public static JColor getRainbow(int incr, int alpha) {
		JColor color =  JColor.fromHSB(((System.currentTimeMillis() + incr * 200)%(360*20))/(360f * 20),0.5f,1f);
		return new JColor(color.getRed(), color.getBlue(), color.getGreen(), alpha);
	}


	public void setValue (boolean rainbow, final JColor value) {
		this.rainbow = rainbow;
		this.value = value;
	}

	public long toInteger() {
		return this.value.getRGB() & (0xFFFFFFFF);
	}

	public void fromInteger (long number) {
		this.value = new JColor(Math.toIntExact(number & 0xFFFFFFFF),true);
	}
	
	public JColor getColor() {
		return this.value;
	}
}