![dddddd](https://user-images.githubusercontent.com/69589624/109410126-1623c480-7966-11eb-9bd4-56984a88a6aa.PNG)
                                                                 
bedroom is a latest version fabric base for minecraft clients. this was made to serve as the base for beach house, i'm just making it public so others can use it and learn from it.<br>
<br>
bedroom is intended for use as a latest version fabric base for minecraft anarchy clients, it can serve as a good starting tool and can have different aspects of it changed or added onto, like adding a more in depth command system, or adding some sort of your own ui elements, and of course you own modules.
<br>
<br> this is not a cheat. it's intent is for minecraft anarchy clients, and it's use for otherwise is redundant. either way bedroom itself is not a cheat, nor are it's intended targets. also, due to previous events, i would like to remind u that fabric is "free to use for everyone. No exceptions." thank you :)
<br>
# bedroom's road map
**plans for bedroom 3**
- font renderer <br>
- notification system <br>
- switch config to JSON <br>
- ui stuff, clickgui maybe if i want to lol <br>
- command javadoc <br>
- support for baritone integration <br>

**plans for bedroom 2** <br>
✔ improved command system <br>
✔ color system <br>
✔ improved main class <br>
✔ improved code <br>
✔ example settings <br>
✔ documentation <br>

**bedroom 1** <br>
✔ events <br>
✔ configs <br>
✔ module system <br>
✔ setting system <br>
✔ command system <br>
✔ ui stuff <br>
<br>
# use of bedroom
***for eclipse*** <br>
- drag .zip release to a new folder
- open folder in cmd
- type gradlew eclipse
- type gradlew genSources
- boom... use

***main class*** <br>
all you have to do in your main class is change the top few lines...
```
public static final String modid = "bed";
public static final String name = "bedroom";
public static final String nameCondensed = "bedroom";
public static final String version = "1";
  ```
you can change the modid, name, nameCondensed, and version variables to fit your own clients, but you have to make sure to update your `fabric.mod.json file` to fit these variables, and update the `bed.mixins.json` if you want to redo the entire structure of the client.<br>
you may also add different inits to the client under `// (your clients name)'s inits... if u need any.` <br>

***command system*** <br>
as for all of the systems here, you can use the current commands as examples. <br>
- the prefix to start out is , (comma), u can simply type this in for help with all the commands while in game. <br>
- to add a command, you have to use the `public void onCommand(String[] args, String command) {` method, also make sure to use the `@Override` annotation with this.
- you can use the `args` to figure out if what is typed is what you want typed, for example, you can check if the args length is correct with `if(args.length > 0) {` (or whatever length you want). or you can check if the args is equal to a word that you want typed, like `if(moduleIn.equalsIgnoreCase(args[0])) {` (this is in the toggle command), this checks if what is typed in the first argument is equal to a module name.
- the CommandManager includes two methods to help send messages to the chat that include `public static void addChatMessage(String message) {`, you can use this to send any message you would like, you can also use TextFormatting to change color mid text. and `public static void correctUsageMsg(String name, String syntax) {` simply sends a message that shows the usage of a command, u can use this if the args is less the or equal to 0, to show a player correct usage.

***module system w/ settings*** <br>
you can use the current modules as examples. <br>
the ExampleRenderModule includes examples for the settings too. <br>

***events and mixins*** <br>
most events and mixins tie into eachother here, so one good example you can use is the EventDrawOverlay events, which is posted in the MixinInGameHud mixin and used in the UI class, this is pretty much the simplest one i use. <br>
bedroom uses [Alpine 1.9](https://github.com/ZeroMemes/Alpine) for it's event system, you can use their own repo for further help on this, they explain it pretty well.

# thanks v much <3
please respect the license in this repo. this is a template repo making it easier to simply use the underlying template to edit however you like, or you can clone the repo and create your own repo, as long as this base is properly credited. 
