package me.srgantmoomoo.bedroom.saveload;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.Setting;
import me.srgantmoomoo.bedroom.module.setting.settings.*;
import net.minecraft.client.MinecraftClient;

import java.io.*;
import java.util.Iterator;

public class Load {
    public File MainDirectory;

    public Load() {
        MainDirectory = new File(MinecraftClient.getInstance().runDirectory, "beach house");
        if (!MainDirectory.exists()) {
            MainDirectory.mkdir();
        }

        load();
    }

    public void load() {
        loadModules();
        loadSettings();
        loadPrefix();
    }

    public void loadModules() {
        try {
            File file = new File(MainDirectory, "modules.txt");
            FileInputStream fstream = new FileInputStream(file.getAbsolutePath());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                Iterator var6 = Bedroom.INSTANCE.moduleManager.getModules().iterator();

                while (var6.hasNext()) {
                    Module m = (Module) var6.next();
                    if (m.getName().equals(line)) {
                        m.toggle();
                        System.out.println(m.getName() + "penises");
                    }
                }
            }

            br.close();
        } catch (Exception e) {
        }
    }

    public void loadSettings() {
        try {
            File file = new File(MainDirectory, "settings.txt");
            FileInputStream fstream = new FileInputStream(file.getAbsolutePath());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;

            while ((line = br.readLine()) != null) {
                String curLine = line.trim();
                String modname = curLine.split(":")[0];
                String settingname = curLine.split(":")[1];
                String value = curLine.split(":")[2];

                Module module = Bedroom.INSTANCE.moduleManager.getModule(modname);
                if(module != null) {
                    if (!settingname.equals("KeyBind")) {
                        Setting setting = Bedroom.INSTANCE.settingManager.getSettingByName(module, settingname);
                        if (setting instanceof BooleanSetting) {
                            ((BooleanSetting) setting).setEnabled(Boolean.parseBoolean(value));
                        }

                        if (setting instanceof NumberSetting) {
                            ((NumberSetting) setting).setValue(Double.parseDouble(value));
                        }

                        if (setting instanceof ModeSetting && ((ModeSetting) setting).modes.toString().contains(value)) { // u have to make sure the mode getting loaded actually still exists or else u will have angry mob of ppl telling u ur config is fucking garbage... but actually yes ur config is fucking garbage because u wrote it when u were fucking monke and didn't know wtf u were doing, like seriously come on now, who the fuck writes a config in a normal fucking txt file, r u fucking stupid??????? like just do it in fucking json u fucking dumb cunt. goated redpilled postman comment.
                            ((ModeSetting) setting).setMode(value);
                        }

                        if(setting instanceof ColorSetting) {
                            ((ColorSetting) setting).setRainbow(Boolean.parseBoolean(curLine.split(":")[3]));
                            ((ColorSetting) setting).fromInteger(Integer.parseInt(value));
                        }

                        if (setting instanceof KeybindSetting) {
                            ((KeybindSetting) setting).setKeyCode(Integer.parseInt(value));
                        }
                    }else
                        module.setKey(Integer.parseInt(value));
                }
            }

            br.close();
        } catch (Exception e) {
        }
    }

    public void loadPrefix() {
        try {
            File file = new File(MainDirectory, "prefix.txt");
            FileInputStream fstream = new FileInputStream(file.getAbsolutePath());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                Bedroom.INSTANCE.commandManager.setCommandPrefix(line);
            }

            br.close();
        } catch (Exception e) {
        }
    }

}
