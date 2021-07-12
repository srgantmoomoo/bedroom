package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.settings.BooleanSetting;

public class Setting extends Command {

    public Setting() {
        super("setting", "allows you to change settings of modules.", "setting <module> <setting> <value>", "s");
    }

    TextFormatting GREEN = TextFormatting.GREEN;
    TextFormatting RED = TextFormatting.RED;
    TextFormatting GRAY = TextFormatting.GRAY;
    TextFormatting WHITE = TextFormatting.WHITE;

    @Override
    public void onCommand(String[] args, String command) {
        if(args.length != 3) {
            CommandManager.correctUsageMsg(name, syntax);
            return;
        }

        String moduleName = args[0];
        String settingName = args[1];
        String inputValue = args[2];
        Module module = Bedroom.classes.moduleManager.getModuleByID(moduleName);
        me.srgantmoomoo.bedroom.module.setting.Setting setting = Bedroom.classes.settingManager.getSettingByName(module, settingName);

        if(module == null) {
            CommandManager.addChatMessage("the module " + RED + moduleName + GRAY + " does not exist dumfuck.");
            return;
        }

        if(setting == null) {
            CommandManager.addChatMessage("the setting " + RED + settingName + GRAY + " does not exist for the module " + WHITE + moduleName + GRAY + ".");
            return;
        }

        if(setting instanceof BooleanSetting) {
            if(!inputValue.equalsIgnoreCase("true") && !inputValue.equalsIgnoreCase("false")) {
                CommandManager.addChatMessage("boolean value must be either " + GREEN + "true " + GRAY + "or " + RED + "false" + GRAY + ".");
                return;
            }

            ((BooleanSetting) setting).setEnabled(Boolean.parseBoolean(inputValue));
            CommandManager.addChatMessage("" + WHITE + setting.name + GRAY + " of " + WHITE + module.name + GRAY + " was set to " + (module.isEnabled() ? GREEN + inputValue : RED + inputValue + GRAY + "."));
        }
    }
}
