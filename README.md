# PrefereceFragment
## 首页Preference Screen
```
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <PreferenceCategory
        android:title="In-line preferences"
        android:key="In-line preferences key">
        <CheckBoxPreference
            android:key="CheckBoxPreference_key1"
            android:summary="This is a checkbos"
            android:title="CheckBox Preference"
            android:defaultValue="false" />
    </PreferenceCategory>

    <PreferenceCategory
        android:title="Dialog-based preferences"
        android:key="Dialog-based preferences key">
        <EditTextPreference
            android:key="EditTextPreference_key"
            android:summary="An example that uses an edit text dialog"
            android:title="EditText Preference"
            android:dialogTitle="Enter your favorite animal"/>
        <ListPreference
            android:key="ListPreference_key"
            android:summary="An example that uses a list dialog"
            android:title="List Preference"
            android:entries="@array/list_entries"
            android:entryValues="@array/list_entries_value"
            android:dialogTitle="Choose one" />
    </PreferenceCategory>

    <PreferenceCategory
        android:title="Launch preference"
        android:key="PreferenceCategory_key">
        <PreferenceScreen
            android:key="PreferenceScreen_key1"
            android:summary="Shows another screen of preferences"
            android:title="Screen preference">
            <intent
                android:targetClass="com.example.preferecefragment.Main2Activity"
                android:targetPackage="com.example.preferecefragment" />
        </PreferenceScreen>
        <PreferenceScreen
            android:key="PreferenceScreen_key2"
            android:summary="Launches an Activity fron an Intent"
            android:title="Intent preference">
            <intent
                android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com/" />
        </PreferenceScreen>
    </PreferenceCategory>

    <PreferenceCategory
        android:title="Preference attributes"
        android:key="PreferenceCategory_key">
        <CheckBoxPreference
            android:key="CheckBox_key2"
            android:summary="This is visually a parent"
            android:title="Parent checkboxs preference"
            android:defaultValue="false" />
        <CheckBoxPreference
            android:key="CheckBox_key3"
            android:summary="This is visually a child"
            android:title="Child chechbox preference"
            android:dependency="CheckBox_key2"
            android:defaultValue="false"/>
    </PreferenceCategory>
</PreferenceScreen>

public class MainActivity extends PreferenceActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preference_screen_main);
    }
}

```
![Image text](https://github.com/1158509577/PrefereceFragment/blob/master/main.png)

## List preference
~~~
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string-array name="list_entries">
        <item>Alpha Option 01</item>
        <item>Beta Option 02</item>
        <item>Charlie Option 03</item>
    </string-array>
    <string-array name="list_entries_value">
        <item>Alpha Option 01</item>
        <item>Beta Option 02</item>
        <item>Charlie Option 03</item>
    </string-array>
</resources>
~~~
![image text](https://github.com/1158509577/PrefereceFragment/blob/master/list.png)

## edit preference
~~~
 <PreferenceCategory
        android:title="Dialog-based preferences"
        android:key="Dialog-based preferences key">
        <EditTextPreference
            android:key="EditTextPreference_key"
            android:summary="An example that uses an edit text dialog"
            android:title="EditText Preference"
            android:dialogTitle="Enter your favorite animal"/>
        <ListPreference
            android:key="ListPreference_key"
            android:summary="An example that uses a list dialog"
            android:title="List Preference"
            android:entries="@array/list_entries"
            android:entryValues="@array/list_entries_value"
            android:dialogTitle="Choose one" />
    </PreferenceCategory>
~~~
![image text](https://github.com/1158509577/PrefereceFragment/blob/master/edit.png)

## screen 跳转
~~~
        <PreferenceScreen
            android:key="PreferenceScreen_key1"
            android:summary="Shows another screen of preferences"
            android:title="Screen preference">
            <intent
                android:targetClass="com.example.preferecefragment.Main2Activity"
                android:targetPackage="com.example.preferecefragment" />
        </PreferenceScreen>
        
 public class Main2Activity extends PreferenceActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment2())
                .commit();
    }
}

public class SettingsFragment2 extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.screenpreference);
    }
}

<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <CheckBoxPreference
        android:key="CheckBox_key4"
        android:defaultValue="false"
        android:summary="Preference that is on the nect screen but same hierarchy"
        android:title="Toggle preference"/>
</PreferenceScreen>
        
~~~
![image text](https://github.com/1158509577/PrefereceFragment/blob/master/intentscreen.png)

## 网页跳转
~~~
        <PreferenceScreen
            android:key="PreferenceScreen_key2"
            android:summary="Launches an Activity fron an Intent"
            android:title="Intent preference">
            <intent
                android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com/" />
        </PreferenceScreen>
~~~
![image text](https://github.com/1158509577/PrefereceFragment/blob/master/webscreen.png)

## checkbox依赖
~~~
    <PreferenceCategory
        android:title="Preference attributes"
        android:key="PreferenceCategory_key">
        <CheckBoxPreference
            android:key="CheckBox_key2"
            android:summary="This is visually a parent"
            android:title="Parent checkboxs preference"
            android:defaultValue="false" />
        <CheckBoxPreference
            android:key="CheckBox_key3"
            android:summary="This is visually a child"
            android:title="Child chechbox preference"
            android:dependency="CheckBox_key2"
            android:defaultValue="false"/>
    </PreferenceCategory>
~~~
![image text](https://github.com/1158509577/PrefereceFragment/blob/master/depency.png)
