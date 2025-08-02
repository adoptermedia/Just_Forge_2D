# Half Pipe Skate Game Scope

This document outlines the scope, deployment and testing steps for the sample half pipe game built on the Just Forge 2D framework.

## Scope
- One isometric half pipe background.
- Single skater represented by a simple circle.
- Keyboard and gamepad input support.
- Menu scene with start prompt.
- In-game control overlay with at least ten trick combinations using `Ctrl` or `Alt` plus directional input.

## Deployment
1. Build the project:
   ```bash
   ./gradlew build
   ```
2. Run the game locally:
   ```bash
   java -jar build/libs/Just_Forge_2D.jar
   ```
3. For web hosting (e.g. Vercel), ensure `vercel.json` points to `index.html` and deploy the static files.

## Testing
- Verify the project compiles with `./gradlew build`.
- Launch the game and confirm:
  - Menu scene appears and `Enter` or gamepad `Start` loads the game.
  - Skater moves with arrow keys or left stick.
  - Performing the listed key combinations displays the corresponding trick names.
