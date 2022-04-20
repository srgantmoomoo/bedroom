package me.srgantmoomoo.bedroom.saveload;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.Setting;
import me.srgantmoomoo.bedroom.module.setting.settings.*;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save {
    public File MainDirectory;

    public Save() {
        MainDirectory = new File(MinecraftClient.getInstance().runDirectory, Bedroom.modname);
        if(!MainDirectory.exists()) {
            MainDirectory.mkdir();
        }
    }

    public void save() {
        saveModules();
        saveSettings();
        savePrefix();
    }

    private void writeFile(ArrayList<String> toSave, File file) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for(String string : toSave) {
                printWriter.println(string);
            }
            printWriter.close();
        } catch (FileNotFoundException ignored) {
        }
    }

    public void saveModules() {
        try {
            File file = new File(MainDirectory, "modules.txt");
            ArrayList<String> toSave = new ArrayList<>();

            for(Module module : Bedroom.INSTANCE.moduleManager.getModules()) {
                if (module.isEnabled() && !module.getID().equals("clickgui") && !module.getID().equals("hudeditor") && !module.getID().equals("commandline") && !module.getID().equals("options")) {
                    toSave.add(module.getName());
                }
            }

            writeFile(toSave, file);
        } catch (Exception ignored) {
        }
    }

    public void saveSettings() {
        try {
            File file = new File(MainDirectory, "settings.txt");
            ArrayList<String> toSave = new ArrayList<>();

            for(Module mod : Bedroom.INSTANCE.moduleManager.modules) {
                for(Setting setting : mod.settings) {

                    if(setting instanceof BooleanSetting bool) {
                        toSave.add(mod.getName() + ":" + setting.name + ":" + bool.isEnabled());
                    }

                    if(setting instanceof NumberSetting number) {
                        toSave.add(mod.getName() + ":" + setting.name + ":" + number.getValue());
                    }

                    if(setting instanceof ModeSetting mode) {
                        toSave.add(mod.getName() + ":" + setting.name + ":" + mode.getMode());
                    }

                    if(setting instanceof ColorSetting color) {
                        toSave.add(setting.parent.getName() + ":" + setting.name + ":" + color.toInteger() + ":" + color.getRainbow());
                    }

                    if(setting instanceof KeybindSetting keybind) {
                        toSave.add(mod.getName() + ":" + setting.name + ":" + mod.getKey());
                    }
                }
            }

            writeFile(toSave, file);
        } catch (Exception ignored) {
        }
    }

    public void savePrefix() {
        try {
            File file = new File(MainDirectory, "prefix.txt");
            ArrayList<String> toSave = new ArrayList<>();

            toSave.add(Bedroom.INSTANCE.commandManager.prefix);

            writeFile(toSave, file);
        } catch (Exception ignored) {
        }
    }

}
