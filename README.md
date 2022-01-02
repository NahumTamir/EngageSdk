# EngageSdk
Enable game publishers to focus on content creation by supply the infrastructure. 
Getting Started with the engage Android SDK
Before You Start
We support Android API level 26 to 31.

Step 1. Add the engage SDK to Your Project

Add the following to the dependencies section:
TBD: publish Engage SDK to artifactory as an artifact aar
dependencies {
  TBD 
}

<uses-permission android:name="android.permission.INTERNET" />

Manifest Engage credentials (Provided by the admin Engage system)

<application>
        <meta-data
            android:name="engage_sdk"
            android:value="developer_id" />
<application/>
            

Step 2.          
Google Play Services
Download the android-support-v4. Add the jar to your project under App/Libs.
Google Play Services in Your Android Manifest
Add the following  inside the <application> tag in your AndroidManifest:
<meta-data android:name="com.google.android.gms.version"
android:value="@integer/google_play_services_version" />
Google Advertising ID

Step 3. Init the SDK 
Engage.initSdk(this)
        when (val initSdkResult = Engage.initSdk(this)){
            is InitResult.InitFailure -> {return}// report error to server
            is InitResult.InitSuccess -> gamePlayApi = initSdkResult.gamePlayAPI // The gameplay API holds all you need for interacting with Engage system
        }
        
Step 4.
For calculating time played add these methods in the game activity
   override fun onResume() {
        super.onResume()
        gamePlayApi.startGameTimeCount()
    }

    override fun onStop() {
        super.onStop()
        gamePlayApi.stopGameTimeCount()
    }
    
Step 5.
Use gamePlayApi to add any event in your game
For example: 
 // Developer should use the gamePlayApi to interact with the Engage system
        gamePlayApi.addPoints(13)
        gamePlayApi.addAchievements(arrayListOf("Beginners Luck"))
        gamePlayApi.getLeaderBoard()
        
Step 6. Use the Admin system to decide how to handle game events
