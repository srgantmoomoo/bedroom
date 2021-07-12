package me.srgantmoomoo.bedroom.command.commands;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.api.util.TextFormatting;
import me.srgantmoomoo.bedroom.command.Command;
import me.srgantmoomoo.bedroom.command.CommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

@SuppressWarnings("resource")
public class Help extends Command {
	
	public Help() {
		super("help", "helps u penis.", "help", "h");
	}

	TextFormatting LIGHT_PURPLE = TextFormatting.LIGHT_PURPLE;
	TextFormatting GRAY = TextFormatting.GRAY;
	TextFormatting AQUA = TextFormatting.AQUA;
	TextFormatting BOLD = TextFormatting.BOLD;
	TextFormatting ITALIC = TextFormatting.ITALIC;

	public static Prefix prefix;
	public static Toggle toggle;
	public static Setting setting;
	public static ModuleList moduleList;

	@Override
	public void onCommand(String[] args, String command) {
		if(args.length != 0) {
			CommandManager.correctUsageMsg(name, syntax);
			return;
		}

		prefix = new Prefix();
		toggle = new Toggle();
		setting = new Setting();
		moduleList = new ModuleList();

		welcomeMessage();
		helpMessage(prefix.getName(), prefix.getDescription(), prefix.getSyntax());
		helpMessage(toggle.getName(), toggle.getDescription(), toggle.getSyntax());
		helpMessage(moduleList.getName(), moduleList.getDescription(), moduleList.getSyntax());
		helpMessage(setting.getName(), setting.getDescription(), setting.getSyntax());
		goodbyeMessage();
	}

	private void helpMessage(String commandName, String commandDesc, String commandSyntax) {
		String starter = LIGHT_PURPLE + commandName + GRAY + " - " + commandDesc;
		String syntaxMessage = " [" + CommandManager.prefix + commandSyntax + "]";

		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(starter));
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(syntaxMessage));
	}

	private void welcomeMessage() {
		String welcomeString = GRAY + "" + BOLD + Bedroom.variables.modname + " " + Bedroom.variables.modversion + "!";
		String nothing = " ";
		String atClientName = AQUA + "@" + ITALIC + Bedroom.variables.modname;

		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(welcomeString));
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(nothing));
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(atClientName));

	}

	private void goodbyeMessage() {
		String uwu = GRAY + "" + BOLD + "uwu" + AQUA + " ~";
		String nothing = " ";

		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(nothing));
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(uwu));
	}

}