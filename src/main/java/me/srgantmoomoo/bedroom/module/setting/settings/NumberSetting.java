package me.srgantmoomoo.bedroom.module.setting.settings;

import me.srgantmoomoo.bedroom.Bedroom;
import me.srgantmoomoo.bedroom.module.Module;
import me.srgantmoomoo.bedroom.module.setting.Setting;

/** the first value is the defualt value, the second and third are the minimum and maximum, the last determines by how much the value increments when changed via ui.
 * @author SrgantMooMoo
 * @since 05/16/2021
 */

public class NumberSetting extends Setting {
	public double value;
	public double minimum;
	public double maximum;
	public double increment;
	  
	public NumberSetting(String name, Module parent, double value, double minimum, double maximum, double increment) {
		this.name = name;
	    this.parent = parent;
	    this.value = value;
	    this.minimum = minimum;
	    this.maximum = maximum;
	    this.increment = increment;
	  }
	  
	public double getValue() {
	    return this.value;
	}
	  
	public void setValue(double value) {
	    double precision = 1.0D / this.increment;
	    //this.value = value;
	    this.value = Math.round(Math.max(this.minimum, Math.min(this.maximum, value)) * precision) / precision;
	    
	    if(Bedroom.classes.saveLoad != null) {
			Bedroom.classes.saveLoad.save();
	    }
	}
	 
	public void increment(boolean positive) {
	    setValue(getValue() + (positive ? 1 : -1) * increment);
	}
	  
	public double getMinimum() {
	    return this.minimum;
	}

	public void setMinimum(double minimum) {
	    this.minimum = minimum;
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