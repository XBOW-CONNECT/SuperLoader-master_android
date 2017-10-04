# SuperLoader-master_android
It's a compact library which can provide us lot of features. and
We create this library for my working purpose.
Here, we used some pre generated libraries and modify it's working process.
## Developed
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27)  
# ★ Gradle Dependency
Add Gradle dependency in the build.gradle file of your application module (app in the most cases) :
First Tab:

```sh
allprojects{
    repositories{
        jcenter()
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

AND

```sh
dependencies {
    compile 'com.github.SandipLayek27:SuperLoader-master_android:1.9'
}
```

# ★ Features are
1. JSONObject request (Parameterized) with or without header passing.   [GET Method/POST Method]
2. JSONArray request (Parameterized) with or without header passing.    [GET Method/POST Method]
3. JSONString request (Parameterized) with or without header passing.   [GET Method/POST Method]
4. Checking Internet connection.
5. Validate Email address
6. Convert String request to Object request.
7. Convert String request to Array request.
8. Validate phone number.
9. Change any date format.
10. Show snack bar.
11. Show Snack bar with respective view.
12. Open keyboard.
13. Close keyboard.
14. Add Ripple Effect.
15. URLEncode formatter.
16. Null Checker.
17. Get fresh value.
18. View null value checker with respective view.
19. Date picker.
20. Time Picker.
21. Image Upload (Multipart Entity).
22. Image Fetch.
23. Font Style changer (Custom TextView and EditText).
24. Font-Aawesome support.
25. Save Image after capturing photo.
26. Single marshmallow permission checker.
27. SharedPreference.

# ★ Uses of above features
* 1. JSONObject request (Parameterized) with or without header passing.
```sh
❆ 1.1 JSONObject request without header token.   [POST Method]
Method Calling:-
 String url="http://...................";               //You can add here your webservice link
 HashMap<String,String>hashMap=new HashMap<>();         //Create a hashMap and put values which is required     
 hashMap.put("", phone);                                //Enter KEY and value
 check_login(hashMap,url)

Method Declaration:-                                    //Create a new method 
 public void check_login(HashMap<String,String>hashMap, String url){
        new PostDataParserObjectRequest(ActivityName.this, url, hashMap, true,PostDataParserObjectRequest.OnPostObjectResponseListner()         {
            @Override
            public void onPostObjectResponse(JSONObject response) {     
                try {
                    //testing case
                    succ = response.getString("responseCode");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
❆ 1.2 JSONObject request with header token.     [POST Method]
Method Calling:-
    String url="http://...................";                //You can add here your webservice link
    HashMap<String,String>hashMap=new HashMap<>();          //Create a hashMap and put values which is required     
    hashMap.put("", phone);                                 //Enter KEY and value
    String headerToken="";                                  //Collect header token
    check_headerToken(hashMap,url,headerToken);             //Calling a method with valid parameters

Method Declaration:-
public void check_headerToken(HashMap<String,String> hashMap,String url,String headerToken){
        new PostDataParserObjectRequest(MainActivity.this, url, headerToken, hashMap, true, new PostDataParserObjectRequest.OnPostObjectResponseListner() {
            @Override
            public void onPostObjectResponse(JSONObject response) {
                
            }
        });
    }
    
❆ 1.3 JSONObject request withOut header token.     [GET Method]
Method Calling:-
    String url="";
    check_getRequest(url);

Method Declaration:-
    public void check_getRequest(String url){
        new GetDataParserObjectRequest(MainActivity.this, url, true, new GetDataParserObjectRequest.OnGetObjectResponseListner() {
            @Override
            public void onGetObjectResponse(JSONObject response) {
                
            }
        });
    }
    
 ❆ 1.4 JSONObject request with header token.     [GET Method]
 Method Calling:-
    String url="";
    String headerToken="";
    check_getRequest(url,header);

Method Declaration:-
    public void check_getRequest(String url,String headerToken){
        new GetDataParserObjectRequest(MainActivity.this, url, headerToken, true, new GetDataParserObjectRequest.OnGetObjectResponseListner() {
            @Override
            public void onGetObjectResponse(JSONObject response) {
                
            }
        });
    }    
```
//2 & 3. Same case for JSONArray Request and JSONString Request. just change:-
```sh
For JSONArray Request POST Method:-
PostDataParserObjectRequest(...);  =>  PostDataParserArrayRequest();

For JSONArray Request GET Method:-
PostDataParserObjectRequest(...);  =>  GetDataParserArrayRequest();

For JSONString Request POST Method:-
PostDataParserObjectRequest(...);  =>   PostDataParserStringRequest();

For JSONString Request GET Method:-
PostDataParserObjectRequest(...);  =>   GetDataParserStringRequest();
```

* 4. Checking Internet connection.
```sh
if(Util.isConnected(MainActivity.this)){
            Toast.makeText(this, "Internet Connected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Internet Not Connected", Toast.LENGTH_SHORT).show();
        }
}
```
* 5. Checking for Validate email address
```sh
    String email="sandiplayek06@gmail.com";
    if(Util.isValidEmail(email)){
    Toast.makeText(this, "Email id is valid", Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this, "Email id is not valid", Toast.LENGTH_SHORT).show();
    }
``` 
* 6. Convert JSONString request to JSONObject request
```sh
    String stringRequest = null;    //here, we initialize stringRequest value is null but normal case we store here StringRequest value
    JSONObject jobj=Util.getjsonobject(stringRequest);
```
* 7. Convert JSONString request to JSONArray request
```sh
    String stringRequest = null;    //here, we initialize stringRequest value is null but normal case we store here StringRequest value
    JSONArray jrr=Util.getjsonarray(stringRequest);
```
* 8. Checking for valid phone number
```sh
String phNo="8927281743";
    if(Util.isValidPhoneNumber(phNo)){
    Toast.makeText(this, "Valid phone number", Toast.LENGTH_SHORT).show();
    }else{
        Toast.makeText(this, "Not valid phone number", Toast.LENGTH_SHORT).show();
    }
```
* 9. Change any Date format
```sh
    String myDate="29/07/13";
    String myCurrentFormat="dd/MM/yy";
    String reqFormat="dd MMM yyyy";
    Util.changeAnyDateFormat(myDate,myCurrentFormat,reqFormat);
```
* 10. Show SnackBar
```sh
Util.showSnakBar(MainActivity.this,"Hello");
```
* 11. Show SnackBar in respective view
```sh
    LinearLayout ll_main;
    ll_main=(LinearLayout)findViewById(R.id.ll_main);
    Util.showSnakBar(MainActivity.this,"Hi",ll_main);
```
* 12. Open Keyboard
```sh    
    Util.openKeyBoard(MainActivity.this);
```
* 13. Close Keyboard
```sh
   Util.closeKeyBoard(MainActivity.this);
```
* 14. Add ripple effect
```sh
        LinearLayout ll_main;
        ll_main=(LinearLayout)findViewById(R.id.ll_main);
        Util.addRippleEffect(ll_main);
```
* 15. URLEncode
```sh
        String url="http://....................";
        name=Util.encode(url);
```        
* 16. Check the string variable is null or not.
```sh
   String name="Sandip";
   if(Util.nullChecker(name)==true){
      Toast.makeText(this, "Not Null", Toast.LENGTH_SHORT).show();   
   }else{
      Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
   }
```
* 17. Get Refresh value.
```sh
    String fname="null"; //or fname=null or fname=""
    name=Util.getFreshValue(name);  //if upper any case then auto initialize "" othewise get original value.
    // It generally used after fetching data frm webservice
```
* 18. Get Fresh value from edit text.
```sh
    EditText et;
    et=(EditText)findViewById(R.id.et);
    if(Util.viewNullValueChecker(et)){
        Toast.makeText(this, "Please enter edit text field", Toast.LENGTH_SHORT).show();
        return;
    }
```
* 19. Date Picker
```sh
    new DatePicker(MainActivity.this, new DatePicker.OnDatePickerListner() {
        @Override
        public void onDateResponse(String selected_date) {
               
        }
    });
```    
* 20. Tiime Picker
```sh
    new TimePicker(MainActivity.this, new TimePicker.OnTimePickerListner() {
        @Override
        public void onTimeResponse(String selected_time) {

         }
    });
```
* 21. Upload file to server
```sh
    After capturing image we get a bitmap format and save this image file using saveImage(...) method calling which functionality is        declared below. and save this file path to "selectedFilePath" String type veriable.
    create url:-
    selectedFilePath => total path of the image
    "user_id" => key 
    iserId => value
    source => android
    String url="Image Upload URL"+"user_id="+userId+"&source="+"android";       //Upload image webservice
    new FileUpload(MainActivityTwo.this, selectedFilePath, url, "user_id", AppData.sUserId, new FileUpload.getResponse() {
        @Override
        public void onResponse(String response_text, HashMap<String, String> hashMap) {
        if(response_text.equals("OK")){
              //call another method which can view update image view using webservice
              getUserProfileDetails(hashMap);
        }else{
              Toast.makeText(MainActivityTwo.this, ""+response_text, Toast.LENGTH_SHORT).show();
        }
      }
    });
```
* 22. Image Fetch and set ImageView
```sh
    ImageView iv=(ImageView)findViewById(R.id.iv); 
    Util.setImage(MainActivity.this,iv,url);
```
* 23. Font Style Changer
```sh
Here, I ByDefault set some custom fonts. Ust use this :-
We normally write.
<EditText
    id
    text
    .
    .
    ./>
    
 Change :-
 <superloader.sandiplayek.com.quickloader.customtext.Custom_EditText   //or enter Custom Ctrl+space
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/et_ph"
    android:hint="Enter Phone Number"/>
```
* 24. FontAwesome Uses
```sh
<superloader.sandiplayek.com.quickloader.customtext.FontAwesome
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="&#xf156;"
    android:layout_marginRight="3dp"/>
```
* 25. After capturing save image to your storage.
```sh
Util.SaveIamge(Context context,Bitmap finalBitmap,String folder_name,String file_name);
```
* 26. Single permission granter
```sh
    new SinglePremissionGranter(MainActivity.this, 99, new SinglePremissionGranter.GetPermissionResult() {
        @Override
        public void getPermissionMessage(String permissionStatus) {
            if(permissionStatus.equals("OK")){
                   
             } 
          }
    });
```

* 27. Shared Preference
```sh
    SharedHelper.savePreference(ActivityName.this,"SHAREd PREFERENCE NAME","KEY",value);
    SharedHelper.fetchPreference(ActivityName.this,"SHAREd PREFERENCE NAME","KEY");
    SharedHelper.removePreference(ActivityName.this,"SHAREd PREFERENCE NAME","KEY");
```

