package com.example.flatload

//import kotlinx.android.synthetic.main.activity_input_way.textviewJSONText

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.gms.maps.model.LatLng
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.kakao.sdk.newtoneapi.*
import com.naver.maps.geometry.Tm128
import kotlinx.android.synthetic.main.fragment_input_way.*
import okhttp3.OkHttpClient
import org.json.JSONObject
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputWayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputWayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val sharedViewModel:SharedViewModel by activityViewModels()
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(15, TimeUnit.MINUTES)
        .build();
    val BASE_URL_FLAT_API ="http://13.125.252.44:8080/" //"http://15.164.166.74:8080"(민영) //"http://10.0.2.2:3000"(에뮬레이터-로컬서버 통신)
    val gson = GsonBuilder().setLenient().create()

    lateinit var origin: LatLng
    lateinit var destination: LatLng
    lateinit var routeOption: String

    var itemList = mutableListOf<ItemList>()
    //음성 인식 전역 변수
    var routeSelected = false
    var answerYesNo = false
    //var YES_NO = false
    var ttsClient : TextToSpeechClient? = null

    var builder = SpeechRecognizerClient.Builder()
        .setServiceType(SpeechRecognizerClient.SERVICE_TYPE_LOCAL)
    var sttclient = builder.build()
    val handler = Handler(Looper.getMainLooper())
    lateinit var mgeocorder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_input_way, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //처음에 gps 허용
        //내위치 누르면 현재 위치로 설정
        //확인 버튼 누르면 출발지, 도착지 -> 위도 경도로 변경
        mgeocorder = Geocoder(requireContext(), Locale.getDefault())
        val items = resources.getStringArray(R.array.route_type)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)
        val inputMethodManager = getContext()?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        //initLocation()
        //내 위치 버튼
        button_inputway_now.setOnClickListener { view ->
            //loc.latitude,loc.longitude <- 현재 위치 위도 경도
            //위도 경도-> 텍스트 변경해서 출발지 edittext에 표시
            val txtLoc = mgeocorder.getFromLocation((activity as MainActivity).loc.latitude,(activity as MainActivity).loc.longitude,1)
                ?.get(0)
            origin = LatLng((activity as MainActivity).loc.latitude,(activity as MainActivity).loc.longitude)
            if(txtLoc.getAddressLine(0)!=null){
                editText_inputway_start.setText(txtLoc.getAddressLine(0))
            }
            //Log.i("my location", txtLoc.toString())
        }
        //확인 버튼
        button_inputway_yes.setOnSingleClickListener { view ->
            if(TextUtils.isEmpty(editText_inputway_start.text.toString()) || TextUtils.isEmpty(editText_inputway_end.text.toString()))
            {
                if(TextUtils.isEmpty(editText_inputway_start.text.toString()) && TextUtils.isEmpty(editText_inputway_end.text.toString())){
                    Toast.makeText(requireContext(),"출발지와 도착지를 입력해주세요", Toast.LENGTH_LONG).show()
                }else{
                    if(TextUtils.isEmpty(editText_inputway_start.text.toString()))
                        Toast.makeText(requireContext(),"출발지를 입력해주세요", Toast.LENGTH_LONG).show()
                    else if(TextUtils.isEmpty(editText_inputway_end.text.toString()))
                        Toast.makeText(requireContext(),"도착지를 입력해주세요", Toast.LENGTH_LONG).show()
                }
            }else{
                Log.d("출발지 확인",editText_inputway_start.text.toString())
                Log.d("도착지 확인",editText_inputway_end.text.toString())
                if (::origin.isInitialized && ::destination.isInitialized) {
                    //listView.clearChoices()
                    listView.setVisibility(View.INVISIBLE)
                    sendToServerLatLng(origin, destination, routeOption)
                }else{
                    Toast.makeText(requireContext(),"보행로 길찾기를 위한 좌표 정보가 부족합니다 돋보기 버튼을 클릭해 장소를 검색해주세요", Toast.LENGTH_LONG).show()
                }
            }
        }
        // 취소 버튼
        button_inputway_no.setOnClickListener { view ->
            editText_inputway_start.text.clear()
            editText_inputway_end.text.clear()
            textView_inputway_speech.setText("")
            listView.setVisibility(View.INVISIBLE)
            spinner.setSelection(0)
        }
        //출발지 장소검색 버튼
        imageButton1.setOnClickListener{view ->
            textView_inputway_speech.setVisibility(View.INVISIBLE)
            if (TextUtils.isEmpty(editText_inputway_start.getText().toString())) { ///////////////////
                Toast.makeText(requireContext(),"출발지가 비어 있습니다",Toast.LENGTH_SHORT).show()
            } else{
                getRocal(editText_inputway_start.getText().toString())
            }
            inputMethodManager.hideSoftInputFromWindow(imageButton1.windowToken, 0)
        }
        //도착지 장소검색 버튼
        imageButton2.setOnClickListener{view->
            if (TextUtils.isEmpty(editText_inputway_end.getText().toString())) {
                Toast.makeText(requireContext(),"도착지가 비어 있습니다.",Toast.LENGTH_SHORT).show()
            }else{
                getRocal(editText_inputway_end.getText().toString())
            }
            inputMethodManager.hideSoftInputFromWindow(imageButton2.windowToken, 0)
        }
        //장소 검색 리스트뷰
        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            var tm128 : Tm128
            val item = parent.getItemAtPosition(position) as ItemList
            if (editText_inputway_start.isFocused == true){
                editText_inputway_start.setText(if (item.roadAddress.length == 0) item.address else item.roadAddress)
                tm128 = Tm128(item.mapx.toDouble(),item.mapy.toDouble())
                origin = LatLng(tm128.toLatLng().latitude,tm128.toLatLng().longitude)
            }else if (editText_inputway_end.isFocused == true){
                editText_inputway_end.setText(if (item.roadAddress.length == 0) item.address else item.roadAddress)
                tm128 = Tm128(item.mapx.toDouble(),item.mapy.toDouble())
                destination = LatLng(tm128.toLatLng().latitude,tm128.toLatLng().longitude)
            }
            //listView.setVisibility(View.INVISIBLE)
        }
        //var permission_network = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_NETWORK_STATE)
        //var permission_internet = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.INTERNET)

        button_inputway_voice.setOnClickListener { view->
            var permission_audio = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.RECORD_AUDIO)
            var permission_storage = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)

            if (permission_audio != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.RECORD_AUDIO), 0)
            }
            if (permission_storage != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
            }
                //음성인식과 음성합성 SDK 초기화
                SpeechRecognizerManager.getInstance().initializeLibrary(requireContext())
                TextToSpeechManager.getInstance().initializeLibrary(requireContext())

                editText_inputway_start.text.clear()
                editText_inputway_end.text.clear()
                //클라이언트 생성
                builder = SpeechRecognizerClient.Builder()
                    .setServiceType(SpeechRecognizerClient.SERVICE_TYPE_LOCAL)
                sttclient = builder.build()

                textToSpeechClient()
                textToSpeech()

        }
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        routeOption = "0"   //기본(선택안함)
                        routeSelected = false;
                    }
                    1 -> {
                        routeOption = "4"   //대로우선
                        routeSelected = true;

                    }
                    2 -> {
                        routeOption = "10"   //최단거리
                        routeSelected = true;
;
                    }
                    3 -> {
                        routeOption = "30"   //계단제외
                        routeSelected = true;

                    }
                    else -> {
                        routeOption = "0"
                        routeSelected = true;

                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputWayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        SpeechRecognizerManager.getInstance().finalizeLibrary()
    }

    private fun textToSpeechClient(){
        ttsClient = TextToSpeechClient.Builder()
            .setSpeechMode(TextToSpeechClient.NEWTONE_TALK_1)     //음성합성방식
            .setSpeechSpeed(0.9)                                  //발음속도
            .setSpeechVoice(TextToSpeechClient.VOICE_MAN_READ_CALM)//TTS 음색모드 설정(여성 차분한 낭독체)
            .setListener(object : TextToSpeechListener {
                //음성합성이 종료될 때 호출
                override fun onFinished() {
                    val intSentSize = ttsClient?.getSentDataSize()     //세션 중에 전송한 데이터 사이즈
                    val intRecvSize = ttsClient?.getReceivedDataSize() //세션 중에 전송받은 데이터 사이즈
                    val strInacctiveText = "handleFinished() SentSize : $intSentSize  RecvSize : $intRecvSize"
                    ttsClient?.stop()
                    speechToText()
                    Log.d("kakao",strInacctiveText)
                }
                override fun onError(code: Int, message: String?) {
                    Log.d("kakao", code.toString())
                }
            })
            .build()
    }
    private fun textToSpeech(){
        //출발지&도착지&경로옵션
        if (TextUtils.isEmpty(editText_inputway_start.getText().toString())) {
            Log.d("출력","출발지")
            ttsClient?.setSpeechText("출발지를 말해주세요 현재 위치로 설정하고 싶으면 현재 위치라고 말해주세요")
            ttsClient?.play()
        } else if(TextUtils.isEmpty(editText_inputway_end.getText().toString())){
            ttsClient?.setSpeechText("도착지를 말해주세요")
            ttsClient?.play()
        } else {
            if (!routeSelected) {
                ttsClient?.setSpeechText("경로옵션을 기본, 대로우선, 최단거리, 계단제외 중에서 하나 선택해주세요")
                ttsClient?.play()
            } else {
                ttsClient?.setSpeechText("길찾기 시작을 원하면 '확인', 원하지 않으면 '취소'라고 말해주세요")
                ttsClient?.play()
            }
        }
    }
    private fun speechToText(){
        if (!TextUtils.isEmpty(editText_inputway_start.getText().toString())
            &&!TextUtils.isEmpty(editText_inputway_end.getText().toString())){
            if(!routeSelected) {
                builder = SpeechRecognizerClient.Builder()
                    .setServiceType(SpeechRecognizerClient.SERVICE_TYPE_WORD)
                    .setUserDictionary("기본\n대로우선\n최단거리\n계단제외")
            }else if(!answerYesNo){
                builder = SpeechRecognizerClient.Builder()
                    .setServiceType(SpeechRecognizerClient.SERVICE_TYPE_WORD)
                    .setUserDictionary("네\n예\n아니오\n아니요")
            }
        }
        sttclient = builder.build()

        val handler = Handler(Looper.getMainLooper())
        sttclient.setSpeechRecognizeListener(object : SpeechRecognizeListener {
            override fun onReady() {
                handler.postDelayed(Runnable {
                    val toast = Toast.makeText(requireContext(), "지금부터 말을 해주세요", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL) //토스트메시지 위치
                    val group = toast.view as ViewGroup
                    val msgTextView = group.getChildAt(0) as TextView
                    msgTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f) //글자 크기
                    toast.show()
                }, 0)
            }
            override fun onBeginningOfSpeech() {
                //Log.d("kakao", "말하기 시작")
            }
            override fun onEndOfSpeech() {
                handler.postDelayed(Runnable {
                    val toast = Toast.makeText(requireContext(), "종료되었습니다", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL) //토스트메시지 위치
                    val group = toast.view as ViewGroup
                    val msgTextView = group.getChildAt(0) as TextView
                    msgTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f) //글자 크기
                    toast.show()
                }, 0)
                //Log.d("kakao", "말하기 종료. 데이터 전달")
            }
            override fun onPartialResult(partialResult: String?) {
                //Log.d("kakao", "인식된 문자열:" + partialResult)
                textView_inputway_speech.setText(partialResult)
            }
            override fun onResults(results: Bundle?) {
                val texts = results?.getStringArrayList(SpeechRecognizerClient.KEY_RECOGNITION_RESULTS)
                val confs = results?.getIntegerArrayList(SpeechRecognizerClient.KEY_CONFIDENCE_VALUES)
                //정확도가 높은 첫번째 결과값을 텍스트뷰에 출력
                activity?.runOnUiThread {
                    textView_inputway_speech.setText(texts?.get(0))
                        if (texts?.get(0) == "네" || texts?.get(0) == "예" || texts?.get(0) == "넥" ||
                            texts?.get(0) == "넵" || texts?.get(0) == "근데"){
                            sttclient.cancelRecording()
                            textToSpeech()
                            answerYesNo = true
                        }else if(texts?.get(0) =="아니오" || texts?.get(0) == "아니요") {
                            sttclient.cancelRecording()

                            if (!(TextUtils.isEmpty(editText_inputway_start.getText().toString())) &&
                                 TextUtils.isEmpty(editText_inputway_end.getText().toString())) { // 출발지 다시
                                editText_inputway_start.text.clear()
                            } else if (!(TextUtils.isEmpty(editText_inputway_start.getText().toString())) &&
                                !(TextUtils.isEmpty(editText_inputway_end.getText().toString()))) {
                                if (routeSelected){ //경로 옵션 다시
                                    spinner.setSelection(0)
                                }else{                   //도착지 다시
                                    editText_inputway_end.text.clear()
                                }
                            }
                            //출발지
                            ttsClient?.setSpeechText("다시 말해주세요")
                            ttsClient?.play()
                        } else if(texts?.get(0) =="확인"){
                        sttclient.cancelRecording()
                        sendToServerLatLng(origin, destination, routeOption)
                    }else if(texts?.get(0) =="취소") {
                        sttclient.cancelRecording()
                        editText_inputway_start.text.clear()
                        editText_inputway_end.text.clear()
                        spinner.setSelection(0)
                        textView_inputway_speech.setVisibility(View.INVISIBLE)
                    }else{
                        if (TextUtils.isEmpty(editText_inputway_start.getText().toString())|| TextUtils.isEmpty(editText_inputway_end.getText().toString())) {
                            if (texts?.get(0)=="현재 위치"){
                                val txtLoc = mgeocorder.getFromLocation((activity as MainActivity).loc.latitude,(activity as MainActivity).loc.longitude,1)[0]
                                origin = LatLng((activity as MainActivity).loc.latitude,(activity as MainActivity).loc.longitude)
                                if(txtLoc.getAddressLine(0)!=null){
                                    editText_inputway_start.setText(txtLoc.getAddressLine(0))
                                }
                                textToSpeech()
                            }else {
                                texts?.get(0)?.let { getRocal(it) }
                            }
                            sttclient.cancelRecording()
                        }else{
                            when(texts?.get(0)){
                                "기본" -> {
                                    spinner.setSelection(0)
                                    routeOption = "0"   //기본(선택안함)
                                    routeSelected = true
                                }
                                "대로우선" -> {
                                    spinner.setSelection(1)
                                    routeOption = "4"   //대로우선
                                    routeSelected = true
                                }
                                "최단거리" -> {
                                    spinner.setSelection(2)
                                    routeOption = "10"   //최단거리
                                    routeSelected = true
                                }
                                "계단제외" -> {
                                    spinner.setSelection(3)
                                    routeOption = "30"   //계단제외
                                    routeSelected = true
                                }
                                else -> {
                                    spinner.setSelection(0)
                                    routeOption = "0"
                                    routeSelected = true
                                }
                            }
                            answerYesNo = true
                            sttclient.cancelRecording()
                            ttsClient?.setSpeechText("경로 옵션은 "+texts?.get(0)+" 입니다. 맞으면 네 틀리면 아니오라고 말해주세요.")
                            ttsClient?.play()
                        }
                    }
                }
            }
            override fun onAudioLevel(audioLevel: Float) {
                //Log.d(TAG, "Audio Level(0~1): " + audioLevel.toString())
            }
            override fun onError(errorCode: Int, errorMsg: String?) {
                Log.d("kakao", "Error: " + errorMsg)
            }
            override fun onFinished() {
                //Log.d("kakao", "Finished")
            }
        })
        handler.postDelayed(Runnable {
            sttclient.startRecording(true)
        }, 0)
    }
    // 서버로 좌표 전송
    private fun sendToServerLatLng(startLatLng: LatLng, destLatLng: LatLng, routeOption:String){
        //val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),"'"+jsonStartDest.toString()+"'")
        // MediaType.parse("application/json; charset=utf-8");
        var startString = startLatLng.latitude.toString()+","+startLatLng.longitude.toString()
        var destString = destLatLng.latitude.toString()+","+destLatLng.longitude.toString()

        val api2 = Retrofit.Builder()
            .baseUrl(BASE_URL_FLAT_API).client(okHttpClient) //"http://192.168.219.107:8080/" http://10.0.2.2:8080 http://192.168.219.107:8080/
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val client = api2.create(FlatAPI::class.java)
        client.postPoint(startString,destString,routeOption).enqueue(object : Callback <Array<Array<JsonObject>>> {
        override fun onResponse(call: Call <Array<Array<JsonObject>>> , response: Response <Array<Array<JsonObject>>> ) {
            if (response?.isSuccessful){
                Toast.makeText(requireContext(), "좌표 전송 성공", Toast.LENGTH_SHORT).show()
                if ( response != null ){
                    var result = response.body()

                    var serverRouteInfo = result?.get(0)
                    Log.d("출력",serverRouteInfo.toString())
                    Log.d("출력", serverRouteInfo?.size.toString())

                    if (result != null){
                        //경로가 비어있는 경우
                        if (serverRouteInfo?.size != 0){ // && serverRouteInfo.isEmpty()) {
                            sharedViewModel.changeInfo(result)
                            //}
                        }else{
                            Toast.makeText(requireContext(),"해당 서비스는 3km 이내의 도보 길찾기 경로만 제공 합니다.", Toast.LENGTH_LONG).show()
                        }
                    }
                    //MapFragment로 이동
                    (activity as MainActivity?)?.setFragment(MapFragment(), "1")
                }
            }else{
                Log.d("실패 onResponse 안","")
                //Toast.makeText(requireContext(), "onResponse ", Toast.LENGTH_SHORT).show()
            }
        }
        override fun onFailure(call: Call<Array<Array<JsonObject>>>, t: Throwable) {
            Log.d("실패 onFailure 안", t.message)
            Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            //finish()
        }
    })
    }

    private fun getRocal(search:String){
        rocalSearchRetrofit(search)
    }
    //Naver rocal search
    private fun rocalSearchRetrofit(search:String){
        var map: HashMap<String, String> = HashMap<String, String>()
        map.put("query",search)
        map.put("display","5")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com/v1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        itemList.clear()
        val re = "<b>|</b>".toRegex()
        val client = retrofit.create(FlatAPI::class.java)
        client.getSearchRocal(getString(R.string.client_id_naver_rocal),
            getString(R.string.access_token_naver_rocal),
            map).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response?.isSuccessful){
                    val jsonObject = JSONObject(response.body()?.trimIndent())
                    val jsonArray = jsonObject.getJSONArray("items")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject2 = jsonArray.getJSONObject(i)
                        var x = jsonObject2.getString("category").split('>')
                        var y = if (x.size > 1) x.get(1) else x.get(0)
                        itemList.add(ItemList(jsonObject2.getString("title").replace(re,""), y,
                            jsonObject2.getString("address"),
                            jsonObject2.getString("roadAddress"),
                            jsonObject2.getString("mapx"),
                            jsonObject2.getString("mapy"))
                        )
                    }
                    if(itemList.size<1) {
                        Toast.makeText(requireContext(), "찾은 장소가 없습니다 다시 입력해주세요", Toast.LENGTH_SHORT).show()
                    }else{
                        //음성 textview가 비어있으면 장소 검색 결과가 보이게
                        if (TextUtils.isEmpty(textView_inputway_speech.getText().toString())) {
                            textView_inputway_speech.setVisibility(View.GONE)  //자리까지 안 보이게
                            //장소 검색 리스트뷰 보이게
                            listView.setVisibility(View.VISIBLE)
                            //리스트뷰 어뎁터 연결
                            listView.adapter = ListViewAdapter(itemList)
                        }else{
                            //음성 textview가 비어있지 않으면
                            var tm128 = Tm128(itemList[0].mapx.toDouble(),itemList[0].mapy.toDouble())
                            if (TextUtils.isEmpty(editText_inputway_start.getText().toString())) {
                                editText_inputway_start.setText(itemList[0].roadAddress)
                                textView_inputway_speech.setText(textView_inputway_speech.text.toString()+
                                        "\n출발지는 "+itemList[0].roadAddress+" 입니다.")
                                origin = LatLng(tm128.toLatLng().latitude,tm128.toLatLng().longitude)
                                ttsClient?.setSpeechText("출발지는 "+itemList[0].roadAddress+" 입니다. 맞으면 네 틀리면 아니오라고 말해주세요.")
                                ttsClient?.play()
                                //YES_NO = true
                                //textToSpeech()
                            }else{
                                Log.d("도착지","도착지는")
                                editText_inputway_end.setText(itemList[0].roadAddress)
                                textView_inputway_speech.setText(textView_inputway_speech.text.toString()+
                                        "\n도착지는 "+itemList[0].roadAddress+" 입니다.")
                                destination = LatLng(tm128.toLatLng().latitude,tm128.toLatLng().longitude)
                                ttsClient?.setSpeechText("도착지는 "+itemList[0].roadAddress+" 입니다. 맞으면 네 틀리면 아니오라고 말해주세요.")
                                ttsClient?.play()
                                //YES_NO = true
                            }
                        }
                    }
                }else{
                    Toast.makeText(requireContext(), "주소 검색에 실패했습니다", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("MYTEST", t.message)
                Toast.makeText(requireContext(), "주소 검색에 실패했습니다.", Toast.LENGTH_SHORT).show()
                //finish()
            }
        })
    }

    private fun checkDistance(distanceKm: Float):Int{
        if(distanceKm >= 3.00){
            Toast.makeText(requireContext(),"해당 서비스는 3km 이내의 도보 길찾기 경로만 제공 합니다.", Toast.LENGTH_LONG).show()
            editText_inputway_start.text.clear()
            editText_inputway_end.text.clear()
            return 0
        }
        return 1
    }

//    private fun startLocationUpdates() { //gps 관련
//        locationRequest = LocationRequest.create()?.apply {
//            interval= 10000
//            fastestInterval = 5000
//            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        }
//        locationCallback = object : LocationCallback(){
//            override fun onLocationResult(locationResult: LocationResult?) {
//                //성공적으로 위치정보 업데이트 되었으면? 그 위치 정보 가져옴
//                locationResult ?: return
//                for(location in locationResult.locations){
//                    loc= LatLng(location.latitude,location.longitude)
//                    Log.i("changeLocation",loc.toString())
//                }
//            }
//        }
//
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        fusedLocationClient?.requestLocationUpdates(
//            locationRequest,
//            locationCallback, //갱신되면 이함수 호출
//            Looper.getMainLooper()) //메인쓰레드가 가지고있는 루퍼 객체 사용하겠다*/
//    }
//
//    private fun initLocation() {
//        if(ActivityCompat.checkSelfPermission(requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(requireContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
//        )
//        {
//            getuserlocation() //현재위치 갱신
//            startLocationUpdates() //업데이트
//        }
//        else{
//            ActivityCompat.requestPermissions(requireActivity(),
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),100)
//            //처음엔 권한 요청함
//        }
//    }
//
//    private fun getuserlocation() {
//        fusedLocationClient= LocationServices.getFusedLocationProviderClient(requireActivity())
//        if (ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                requireContext(),
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        val temp = fusedLocationClient
//        if(temp != null){
//            temp.lastLocation
//                .addOnSuccessListener {//성공적으로 위치 가져왔으면?
//                    if (it == null) {
//                        Log.i("위치 가져오기 실패", "")    //현재 위치를 바로 가져올 수 없을 때 예외처리
//                    } else {
//                        loc = LatLng(it.latitude, it.longitude)  //현재위치로 위치정보를 바꾸겠다
//                        Log.i("currentLocation", loc.toString())
//                    }
//                }
//                .addOnFailureListener{
//                    Log.i("location error","")          //
//                }
//        }
////        fusedLocationClient?.lastLocation?.addOnSuccessListener {//성공적으로 위치 가져왔으면?
////            loc = LatLng(it.latitude,it.longitude) //현재위치로 위치정보를 바꾸겠다
////            Log.i("currentLocation",loc.toString())
////        }
//    }

//    override fun onRequestPermissionsResult( //권한요청하고 결과 여기로 옴
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if(requestCode==100){ //허용받았으면
//            if(grantResults[0]== PackageManager.PERMISSION_GRANTED &&
//                grantResults[1] == PackageManager.PERMISSION_GRANTED){ //둘다 허용되면
//                getuserlocation()
//                startLocationUpdates()
//            }
//            else{//허용안해줬으면 기본 맵으로
//                Toast.makeText(requireContext(),"위치정보 제공을 하셔야 합니다", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}