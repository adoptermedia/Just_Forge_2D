package Just_Forge_2D.GameDemo;

import Just_Forge_2D.SceneSystem.Scene;
import Just_Forge_2D.SceneSystem.SceneScript;
import Just_Forge_2D.WindowSystem.GameWindow;
import Just_Forge_2D.InputSystem.Keyboard;
import Just_Forge_2D.InputSystem.Keys;
import Just_Forge_2D.InputSystem.Gamepad;
import imgui.ImGui;
import imgui.flag.ImGuiWindowFlags;

/**
 * Simple menu scene that starts the half pipe game.
 */
public class MenuSceneScript extends SceneScript {
    @Override
    public void init(Scene scene) {
    }

    @Override
    public void loadResources(Scene scene) {
    }

    @Override
    public void update(float dt) {
        if (Keyboard.isKeyBeginPress(Keys.ENTER) || Gamepad.isStartPressed()) {
            GameWindow.changeScene(new HalfPipeSceneScript());
        }
    }

    @Override
    public void render(float dt) {
        ImGui.begin("Half Pipe Menu", ImGuiWindowFlags.AlwaysAutoResize);
        ImGui.text("Half Pipe Skate Game");
        ImGui.text("Press Enter or Start to play");
        ImGui.end();
    }
}
