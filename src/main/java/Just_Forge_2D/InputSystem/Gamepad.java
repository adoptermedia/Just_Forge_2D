package Just_Forge_2D.InputSystem;

import org.lwjgl.glfw.GLFWGamepadState;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Basic gamepad input helper supporting a single controller.
 */
public class Gamepad {
    private static Gamepad instance;
    private final GLFWGamepadState state = GLFWGamepadState.create();

    private Gamepad() {
    }

    private static Gamepad get() {
        if (instance == null) {
            instance = new Gamepad();
        }
        return instance;
    }

    private static boolean poll() {
        if (!glfwJoystickPresent(GLFW_JOYSTICK_1)) return false;
        if (!glfwJoystickIsGamepad(GLFW_JOYSTICK_1)) return false;
        return glfwGetGamepadState(GLFW_JOYSTICK_1, get().state);
    }

    public static boolean isButtonPressed(int button) {
        if (!poll()) return false;
        return get().state.buttons(button) == 1;
    }

    public static float getAxis(int axis) {
        if (!poll()) return 0.0f;
        return get().state.axes(axis);
    }

    public static boolean isStartPressed() {
        return isButtonPressed(GLFW_GAMEPAD_BUTTON_START);
    }

    public static boolean isAPressed() {
        return isButtonPressed(GLFW_GAMEPAD_BUTTON_A);
    }

    public static boolean isBPressed() {
        return isButtonPressed(GLFW_GAMEPAD_BUTTON_B);
    }
}
