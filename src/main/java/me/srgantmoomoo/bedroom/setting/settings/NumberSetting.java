package me.srgantmoomoo.bedroom.setting.settings;

import me.srgantmoomoo.bedroom.Main;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.setting.Setting;

public class NumberSetting extends Setting {
	public double value;
	public double minimun;
	public double maximum;
	public double increment;
	  
	public NumberSetting(String name, Module parent, double value, double minimun, double maximum, double increment) {
		this.name = name;
	    this.parent = parent;
	    this.value = value;
	    this.minimun = minimun;
	    this.maximum = maximum;
	    this.increment = increment;
	  }
	  
	public double getValue() {
	    return this.value;
	}
	  
	public void setValue(double value) {
	    double precision = 1.0D / this.increment;
	    //this.value = value;
	    this.value = Math.round(Math.max(this.minimun, Math.min(this.maximum, value)) * precision) / precision;
	    
	    if(Main.saveLoad != null) {
			Main.saveLoad.save();
	    }
	}
	 
	public void increment(boolean positive) {
	    setValue(getValue() + (positive ? 1 : -1) * increment);
	}
	  
	public double getMinimun() {
	    return this.minimun;
	}

	public void setMinimun(double minimun) {
	    this.minimun = minimun;
	}
	  
	public double getMaximum() {
	    return this.maximum;
	}
	
	public void setMaximum(double maximum) {
	    this.maximum = maximum;
	}
	  
	public double getIncrement() {
	    return this.increment;
	}
	  
	public void setIncrement(double increment) {
	    this.increment = increment;
	}
}