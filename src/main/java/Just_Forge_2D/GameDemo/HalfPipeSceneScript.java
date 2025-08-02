package Just_Forge_2D.GameDemo;

import Just_Forge_2D.SceneSystem.Scene;
import Just_Forge_2D.SceneSystem.SceneScript;
import Just_Forge_2D.InputSystem.Keyboard;
import Just_Forge_2D.InputSystem.Keys;
import Just_Forge_2D.InputSystem.Gamepad;
import Just_Forge_2D.RenderingSystem.DebugPencil;
import org.joml.Vector2f;
import org.joml.Vector3f;
import imgui.ImGui;
import imgui.flag.ImGuiWindowFlags;

import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Simple half pipe skating demo.
 */
public class HalfPipeSceneScript extends SceneScript {
    private Vector2f skaterPos = new Vector2f(300, 150);
    private String trickMessage = "";
    private float trickTimer = 0f;

    @Override
    public void init(Scene scene) {
    }

    @Override
    public void loadResources(Scene scene) {
    }

    @Override
    public void update(float dt) {
        float move = 200 * dt;
        boolean left = Keyboard.isKeyPressed(Keys.ARROW_LEFT) || Gamepad.getAxis(GLFW_GAMEPAD_AXIS_LEFT_X) < -0.5f;
        boolean right = Keyboard.isKeyPressed(Keys.ARROW_RIGHT) || Gamepad.getAxis(GLFW_GAMEPAD_AXIS_LEFT_X) > 0.5f;
        boolean up = Keyboard.isKeyPressed(Keys.ARROW_UP) || Gamepad.getAxis(GLFW_GAMEPAD_AXIS_LEFT_Y) < -0.5f;
        boolean down = Keyboard.isKeyPressed(Keys.ARROW_DOWN) || Gamepad.getAxis(GLFW_GAMEPAD_AXIS_LEFT_Y) > 0.5f;
        if (left) skaterPos.x -= move;
        if (right) skaterPos.x += move;
        if (up) skaterPos.y += move;
        if (down) skaterPos.y -= move;

        boolean a = Keyboard.isKeyPressed(Keys.A) || Gamepad.isAPressed();
        boolean s = Keyboard.isKeyPressed(Keys.S) || Gamepad.isBPressed();

        checkTricks(a, s, up, down, left, right);

        if (trickTimer > 0) {
            trickTimer -= dt;
        }
    }

    private void checkTricks(boolean a, boolean s, boolean up, boolean down, boolean left, boolean right) {
        if (a && up && left) setTrick("720 Spin");
        else if (a && up && right) setTrick("McTwist");
        else if (a && up) setTrick("Kickflip");
        else if (a && down) setTrick("Heelflip");
        else if (a && left) setTrick("Caballerial");
        else if (a && right) setTrick("Ollie");
        else if (s && up && right) setTrick("FS Air");
        else if (s && up) setTrick("Nose Grab");
        else if (s && down) setTrick("Tail Grab");
        else if (s && left) setTrick("Indy");
        else if (s && right) setTrick("Mute");
    }

    private void setTrick(String name) {
        trickMessage = name;
        trickTimer = 2f;
    }

    @Override
    public void render(float dt) {
        Vector2f[] pipe = new Vector2f[] {
                new Vector2f(100, 100),
                new Vector2f(500, 100),
                new Vector2f(550, 250),
                new Vector2f(50, 250)
        };
        DebugPencil.addPolygonFromVertices(Arrays.asList(pipe), new Vector3f(0.8f, 0.8f, 0.8f), 1);
        DebugPencil.addCircle(skaterPos, 10f, new Vector3f(1f, 0f, 0f), 1);

        if (trickTimer > 0) {
            ImGui.begin("Trick", ImGuiWindowFlags.NoDecoration | ImGuiWindowFlags.AlwaysAutoResize | ImGuiWindowFlags.NoBackground);
            ImGui.text(trickMessage);
            ImGui.end();
        }

        ImGui.begin("Controls", ImGuiWindowFlags.AlwaysAutoResize);
        ImGui.text("A + Up : Kickflip");
        ImGui.text("A + Down : Heelflip");
        ImGui.text("A + Left : Caballerial");
        ImGui.text("A + Right : Ollie");
        ImGui.text("A + Up + Left : 720 Spin");
        ImGui.text("A + Up + Right : McTwist");
        ImGui.text("S + Up : Nose Grab");
        ImGui.text("S + Down : Tail Grab");
        ImGui.text("S + Left : Indy");
        ImGui.text("S + Right : Mute");
        ImGui.text("S + Up + Right : FS Air");
        ImGui.end();
    }
}
