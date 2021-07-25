# Android-Basics - Semesterprojekt

### Konzept und Implementierung
Nachdem das Topic frei wählbar war (siehe Exercise Overview), war meine Idee eine ***Nature-Observer-App*** zu entwickeln, in welcher interessante Outdoor-Erlebnisse mit Titel, Datum, Ort und Anmerkungen gespeichert (SharedPreferences) werden können.
Alle bestehenden Einträge können in einer scrollbaren Liste eingesehen werden.
Text aus anderen Apps kann für einen neuen Eintrag an die App mittels Intent übergeben werden.
Ein neuer Eintrag kann mittels Share-Button mit anderen Apps geteilt werden.

##### Blocks implentiert:
- Base Block: Navigation über Intents
- Block 2: RecyclerView in "ShowAllObservationsAktivity"
- Block 4: Shared Preferences implentiert
- Block 6: Share-Intent und Send-Intent in "NewObservationActivity"

##### Anmerkungen:
- string-xml für Deutsch und Englisch
- colors angepasst
- theme ohne actionbar angelegt
- statusbar in allen Aktivities deaktiviert, siehe ersten Code-Abschnitt nach "onCreate"-Methode
- shape für RecyclerView in drawable
- "NewObservationActivity"-Layout ist scrollable wenn der "Notes"-Text zu lang wird
- toast in "NewObservationActivity" auf Speichern-Button


### Learning objectives

- Understand the Android operating system
- Internal and external storage, Permissions and processes
- Compile and install apps with Gradle
- Use Android Studio and the designers/editors
- Understand app contents like Services, Manifest and resources
- Design and create screens with Activities, Fragments and Views
- Display lists and navigate with the navigation component
- Persist data between app starts with Shared Preferences

### Exercise Overview
***Create an Android App. The topic of the app can be chosen by you.***<br/>
The exercise consists of blocks:
- You need to implement at least a base block
- Each additional block increases your grade

#### Base Block: Project Setup, Lifecycle and Resources
- Create an Android Studio project
- Target at least SDK version 21 (Android 5)
- Use Kotlin or Java as the programming language
- Use the „Empty Activity“ template and set the Activity as the launcher Activity
- Log a message whenever a screen gets visible
- Use resouces like strings, dimensions and colors where possible
- Add them to the res folders and use them in code or XML

#### Base Block: Layouts and Views
- Add a layout for each screen you are creating. A screen can be an Activity or Fragment
- Set the layout in onCreate (Activity) or onCreateView/in the constructor (Fragment)
- Use a ViewGroup like the ConstraintLayout as the root element
- Add views to the layout and interact with them in the source code
- Get the views in onCreate (Activity) or onViewCreated (Fragment)
- Add a view where the user can input text (TextInputEditText)
- Listen for text changes and process them (for example: log the word count)
- Add a Button or FAB and attach a click listener to it
- When a click happens, perform an action (like logging a message)

#### Base Block: Navigation
- Use Intents or the Navigation Component to navigate between screens
- Add at least one additional screen to the project
- If you want to use Fragments, add the NavHostFragment to the launcher activity
- Navigate to a screen when a trigger gets activated
- The trigger may be a button, a FAB or a specific text provided by the user
- Pass arguments with the Intent or the navigation action
- Use an extra or the navigation arguments
- Read the arguments in the destination from the intent or the NavArgs

#### Block 1: Permissions, Toasts and Snackbars
- Check for a dangerous permission in an Activity or a Fragment
- For example: READ_EXTERNAL_STORAGE or ACCESS_COARSE_LOCATION
- The trigger for the check may be a click on an ImageView
- If the permission got granted, perform an action
- The action may be to open the gallery to select a file or image or just logging something
- If the permission got denied, ask for it
- When the user accepts the permission, display a Toast and perform an action
- When the user denies the permission show a Snackbar with a message

#### Block 2: RecyclerView and Lists
- Add a RecyclerView to an Activity or Fragment
- Implement an Adapter to display items in the RecyclerView
- For example: Display contacts and their names in the list
- Create a list item layout to display the content of an item
- Use a ViewHolder to read the views from the list item layout
- Get the views with the findViewById() method
- Bind items to the ViewHolder in the Adapter
- Use a layout manager to tell the list how items should be displayed
- Perform any action when a list item got clicked
- For example: navigate to a detail screen or display a Toast

#### Block 3: Dialogs
- Display a dialog with the (Material)AlertDialog.Builder
- Call the create() and show() methods to actually display the dialog
- The trigger for showing the dialog can be a list item or button click
- Show some content in the body of the dialog
- For example: display a text or a selectable list
- Add at least one button to the dialog
- Perform an action when the button gets clicked
- For example: display a Toast or perform a navigation action
- You can use a DialogFragment to follow best practices (you don‘t have to)

#### Block 4: Shared Preferences
- Persist data beyond app exits and starts
- For example: save and read the time when the app got opened the last time
- Obtain a SharedPreferences object via the context
- Use requireContext() in Fragments or „this“ in Activities
- Edit the preferences and save them after the data got written
- Save some simple data with the put* methods
- Use a unique key for the data
- Read the data with the get* methods from the preferences
- Use the same unique key when the data was saved
- SharedPreference data may be empty when it gets read
- Provide a meaningful default value (like the current Date())

#### Block 5: Notifications
- Display a notification when a trigger gets activated
- For example: display a contacts name when a list item gets clicked
- Create a notification channel with a meaningful name
- Set the importance to IMPORTANCE_DEFAULT on creation
- Build the notification with the NotificationCompat.Builder
- Set the content title and text
- Add a small icon (like the launcher icon)
- Set the priority to any value
- Build the notification and display it with the NotificationManager
- Use any number as the notification id

#### Block 6: Sharing is Caring
- Send a simple text from and to the app
- Add a button (or any other trigger) to share text from the app
- Create an Intent with ACTION_SEND and set the EXTRA_TEXT extra
- Use the Intent chooser and pass the Intent to the startActivity() method
- Add an Activity to the project to receive texts from other apps
- Add the correct Intent Filter to the Activity in the AndroidManifest
- Use „text/plain“ as the data mimeType
- Use „android.intent.action.SEND“ as the action name
- Read the EXTRA_TEXT from the Intent in the onCreate() method
- Display the text in a TextView or any other view
 
