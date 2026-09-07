# Fix NullPointerException in MainActivity

The application crashes on startup because `findViewById(R.id.main)` is called before `setContentView(binding.getRoot())` in `MainActivity.java`. This results in a `null` view being passed to `ViewCompat.setOnApplyWindowInsetsListener`, which internally attempts to call `setTag` on that null object.

## Proposed Changes

### [MainActivity](file:///C:/Users/filipe.silva.PAXBR/AndroidStudioProjects/ContatosAndroid/app/src/main/java/com/example/contatosandroid/MainActivity.java)

#### [MODIFY] [MainActivity.java](file:///C:/Users/filipe.silva.PAXBR/AndroidStudioProjects/ContatosAndroid/app/src/main/java/com/example/contatosandroid/MainActivity.java)
- Reorder `onCreate` method to initialize View Binding and set the content view *before* setting the window insets listener.
- Use `binding.main` instead of `findViewById(R.id.main)` for consistency with the View Binding pattern.

## Verification Plan

### Manual Verification
- Deploy the app to a device/emulator and ensure it no longer crashes on startup.
- Verify that the "Cumprimentar" button functionality works as expected.
