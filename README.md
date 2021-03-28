# happy-places-app
Sample app that displays your favorite places.
# Requirements
Familiar with Android Studio and its features and components.
# Steps
**!Under _Gradle Scripts_ in build.gradle(Module:app) add the extra dependencies which are present in the file here! Otherwise, many of the third party integrations won't work.**

**Step 1:** Under _activities_ the MainActivity file is automatically created. Copy the code from _MainActivity.kt_ from here and paste it in your file.

**Step 2:** Under _activities_, create three more files namely, AddHappyPlaceActivity, AddHappyPlaceDetailActivity and MapActivity. Copy the codes from the files with the same name from here.

**Step 3:** Under _com.example.yourProjectName_ create four more folders, adapters, database, models and utils and one file namely, MapFragments. In the adapters folder create a HappyPlacesAdapter file, under database create DatabaseHandler file, under models create HappyPlaceModel file and under utils create GetAddressFromLatLng, SwipeTodeleteCallback and SwipeToEditCallback files.

**Step 4:** Copy the following codes from the files with name name from here and paste it in your files.

**These are the actual main codes for the app. You can stylisize your app according to your needs using the XML files. I hvae attached my own files also, to use them read along.**

Under _app_, in _res_ folder, in _drawable_ folder, add the followinf files:

1. Both the image files.
2. ic_action_add_24dp, ic_delete_sweep_24dp, ic_edit_icon_24dp, ic_launcher_background, ic_launcher_foreground, shape_button_rounded and shape_image_view_border.

Under _layout_ in the _res_ folder, add the following files: activity_add_happy_place, activity_happy_place_detail, activity_main, activity_map, fragment_maps and item_happy_place.

Under _values_ in the _res_ folder, add the following files: colors, dimens, strings, styles and ic_launcher_background. **In this same folder, you also need to add the "google_maps_api.xml" file, which will be provided by Google Maps API platform. Also in the strings file, you will need to add you API KEY which will be provided by Maps API again.**
