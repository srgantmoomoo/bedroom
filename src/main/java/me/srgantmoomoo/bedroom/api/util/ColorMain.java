package me.srgantmoomoo.bedroom.api.util;

import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.settings.ModeSetting;

import java.util.ArrayList;

public class ColorMain extends Module {
    public static final Module ColorMain = null;
    public static ModeSetting colorModel = new ModeSetting("penisright?", ColorMain, "HSB", "RGB", "HSB");

    public ColorMain() {
        super("colorMain", "colorMain", "oof", 0, Category.BEACHHOUSE);
        this.addSettings(colorModel);
    }

    public void setup() {
        ArrayList<String> tab = new ArrayList<>();
        tab.add("Black");
        tab.add("Dark Green");
        tab.add("Dark Red");
        tab.add("Gold");
        tab.add("Dark Gray");
        tab.add("Green");
        tab.add("Red");
        tab.add("Yellow");
        tab.add("Dark Blue");
        tab.add("Dark Aqua");
        tab.add("Dark Purple");
        tab.add("Gray");
        tab.add("Blue");
        tab.add("Aqua");
        tab.add("Light Purple");
        tab.add("White");
        ArrayList<String> models=new ArrayList<>();
        models.add("RGB");
        models.add("HSB");
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
