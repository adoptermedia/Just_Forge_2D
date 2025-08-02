package Just_Forge_2D;

import Just_Forge_2D.EditorSystem.Forge;
import Just_Forge_2D.WindowSystem.GameWindow;
import Just_Forge_2D.GameDemo.MenuSceneScript;

public class Main {
    public static void main(String[] args) {
        Forge.start();
        GameWindow.changeScene(new MenuSceneScript());
        GameWindow.get().run();
        Forge.end();
    }
}
