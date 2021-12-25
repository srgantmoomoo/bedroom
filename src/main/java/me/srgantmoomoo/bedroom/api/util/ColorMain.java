package me.srgantmoomoo.bedroom.api.util;

import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.settings.ModeSetting;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorMain extends Module {
    public static final Module ColorMain = null;
    public static ModeSetting colorModel = new ModeSetting("penisright?", ColorMain, "HSB", "RGB", "HSB");

    public ColorMain() {
        super("colorMain", "colorMain", "oof", 0, Category.BEACHHOUSE);
        this.addSettings(colorModel);
    }

    public void setup() {
        ArrayList<String> tab = new ArrayList<>(Arrays.asList("Black", "Dark Green", "Dark Red", "Gold", "Dark Gray", "Green", "Red", "Yellow", "Dark Blue", "Dark Aqua", "Dark Purple", "Gray", "Blue", "Aqua", "Light Purple", "White"));
        ArrayList<String> models = new ArrayList<>(Arrays.asList("RGB", "HSB"));
    }

    public void onEnable() {
        this.disable();
    }

    private static TextFormatting settingToFormatting () {
        return TextFormatting.AQUA;
    }

    public static TextFormatting getEnabledColor() { return settingToFormatting(); }

    public static TextFormatting getDisabledColor() { return settingToFormatting(); }

}
