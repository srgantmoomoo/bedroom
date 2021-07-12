![dddddd](https://user-images.githubusercontent.com/69589624/109410126-1623c480-7966-11eb-9bd4-56984a88a6aa.PNG)
                                                                 
bedroom is a latest version fabric client api for minecraft. this was made to serve as the base for beach house, i'm just making it public so others can use it and learn from it.<br>
<br>
bedroom is intended for use as a latest version fabric base for minecraft anarchy clients, it can serve as a good starting tool for anyone to make the client they want.
<br>
<br> this is not a cheat. it's intent is for minecraft anarchy clients, and it's use for otherwise is redundant. either way bedroom itself is not a cheat, nor are it's intended targets. also, due to previous events, i would like to remind u that fabric is "free to use for everyone. No exceptions." thank you :)
<br>
# bedroom's road map
**plans for bedroom 5**
- no static

**plans for bedroom 4** <br>
✔ make it a useable api via gradle
- JSON config
- font renderer

**bedroom 3** <br>
✔ command javadoc <br>
✔ main class tweaked a bit <br>
✔ fix module class... automatic event subscribing and event subscribing on launch fix <br>
✔ command sysetm overhaul <br>
✔ onUpdate method added <br>
✔ refactorization <br>

**bedroom 2** <br>
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
**this readme section is dedicated to use of the bedroom 4 api, if you are using bedroom 3, it's quite a bit different :P, sorry but stuff will be a little messy here until i get bedroom 4 fully working.**

***for eclipse*** <br>
- drag .zip release to a new folder
- open folder in cmd
- type gradlew eclipse
- type gradlew genSources
- boom... use

***gradle*** <br>
add bedrom under your dependencies in your gradle file using `implementation "com.github.beach-house-development:bedroom:4-pre1"`.

***main class*** <br>
you have to create your own main class, within it make sure to implement `ModInitializer` from fabric. <br>

*you can use linkkkk as an example for a main class.*

```Java
@Override
public void onInitialize() {
    // you first have to declare your mod variables, make sure these are the same as the ones used in your "fabric.mod.json" file.
    Bedroom.variables.modid = "exampleModId";
    Bedroom.variables.modname = "exampleModName";
    Bedroom.variables.modversion = "0.0.1";

    // declare two boolean values, these will decide if you want to include certain things from bedroom into your own client.
    Bedroom.includes.includeDefaultCommands = true;
    Bedroom.includes.includeUI = true;

    // finally, initialize bedroom...
    Bedroom.init();
}
```

***command system*** <br>
you can use the current commands as examples. <br>
- the prefix to start out is , (comma).<br>
- to add a command, you have to use the `onCommand(String[] args, String command) {` method, also make sure to use the `@Override` annotation with this.
- you can use the `args` to figure out if what is typed is what you want typed, for example, you can check if the args length is correct with `if(args.length > 0) {` (or whatever length you want). or you can check if the args is equal to a word that you want typed, like `if(moduleIn.equalsIgnoreCase(args[0])) {` (this is in the toggle command), this checks if what is typed in the first argument is equal to a module name.
- the CommandManager includes two methods to help send messages to the chat that include `addChatMessage(String message) {`, you can use this to send any message you would like, you can also use TextFormatting to change color mid text. and `correctUsageMsg(String name, String syntax) {` simply sends a message that shows the usage of a command, u can use this if the args is less the or equal to 0

***module system w/ settings*** <br>
to create a module class, just extend the class from Module.

theres a few methods you need here, `onEnable()` will perform your code when the module is enabled, and `onDisable()` will perform your code when the module is disabled. <br>
`onUpdate()` will preform your code every tick, for example, if you set sprinting true in `onUpdate`, sprinting will costantly be true. make sure to use `@Override` above these methods. <br>

***events and mixins*** <br>
most events and mixins tie into eachother here, so one good example you can use is the EventDrawOverlay events, which is posted in the MixinInGameHud mixin and used in the UI class, this is pretty much the simplest one i use. <br>
bedroom uses [Alpine 1.9](https://github.com/ZeroMemes/Alpine) for it's event system, you can use their own repo for further help on this, they explain it pretty well.

# thanks v much <3
please respect the license in this repo!! and thank you to anyone who uses this :) <br>
also please check the projects that make this possible... <br>
[Fabric](https://github.com/FabricMC) <br>
[Alpine 1.9](https://github.com/ZeroMemes/Alpine) <br>
