package com.example.mod;

import com.example.mod.module.ExampleModule;

import me.srgantmoomoo.bedroom.Bedroom;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	
	@Override
	public void onInitialize() {
		Bedroom.variables.modid = "bed";
		Bedroom.variables.modname = "bedroom";
		Bedroom.variables.modversion = "4";
		
		Bedroom.includes.includeDefaultCommands = true;
		Bedroom.includes.includeUI = true;
		Bedroom.init();
		
		modules();
	}
	
	public void modules() {
		Bedroom.addModule(new ExampleModule());
	}
}
