//package com.example.myapp_test6
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.view.MenuItem
//import android.view.View
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.myapp_test6.databinding.ActivityMainBinding
//import com.example.myapp_test_7_8_9_10_11_12.ch11_Test.viewpageandrecyclerview.adapter.RecyclerViewTest
//import com.example.myapp_test_7_8_9_10_11_12.ch11_Test.viewpageandrecyclerview.adapter.ViewPageAdapterTest
//import com.google.android.material.tabs.TabLayoutMediator
//
//class MainActivity : AppCompatActivity() {
//    lateinit var imgCheck:String
//    lateinit var TAG:String
//
//    lateinit var toggle : ActionBarDrawerToggle
//    // 뷰 바인딩 설정 순서1,
//    lateinit var binding: ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        imgCheck = "Y"
//        TAG = "MainActivity"
//
//        super.onCreate(savedInstanceState)
//
//        // 뷰 바인딩 설정 순서2,
//        // binding 인스턴스에, 모든 뷰를 담았다.
//        binding = ActivityMainBinding.inflate(layoutInflater)
//
//        // 뷰 바인딩 설정 순서3,
//        setContentView(binding.root)
////        setContentView(R.layout.activity_main)
//
//        //기본 뷰 선택 방법1
//        // findViewById 를 이용해서, 로그인 버튼 클릭시, 해당 화면으로 이동하기.
//        val loginBtn: Button = findViewById(R.id.loginBtn)
//
//        // 뷰 바인딩 선택 방법2
//
//        // 회원 가입 폼으로 이동 하는 화면.
//       // val joinBtn: Button = findViewById(R.id.joinBtn)
//        binding.joinBtn.setOnClickListener {
//        // intent는 시스템에 메세지를 전달하는 용도로 사용도 하지만,
//        // 일단, 액티비티 간 화면 이동으로 잠시 사용하기.
//            val intent = Intent(this@MainActivity, JoinActivity::class.java)
//            // 이 함수 이용해서, 2번째 화면으로 이동하는함.
//            startActivity(intent)
//        }
//
//
//        // 버튼으로 , 뷰 show/hide 해보기.
//        val testBtn : Button = findViewById(R.id.testBtn)
//        testBtn.setOnClickListener {
//            Log.d(TAG,"버튼을 클릭시 확인.")
//            if(imgCheck.equals("Y")) {
//                val imgView: ImageView = findViewById(R.id.imageView)
//                imgView.visibility = View.VISIBLE
//                imgCheck = "N"
//            } else {
//                val imgView: ImageView = findViewById(R.id.imageView)
//                imgView.visibility = View.INVISIBLE
//                imgCheck = "Y"
//            }
//        }
//
//        // 클릭시 이벤트 리스너 이용해서, 해당 화면으로 이동.
//        loginBtn.setOnClickListener {
//            val intent = Intent(this@MainActivity, LoginFormActivity::class.java)
//            startActivity(intent)
//        }
//        //탭 뷰와 뷰페이져2 연동 .
//        val tabLayout = binding.Test2tabs
//        // 뷰페이져2 뷰 부분 선택
//        val viewPager = binding.viewPager1
//
//        // 뷰페이져2를 연동시 사용할 프래그먼트 어댑터 필요함.
//        // 기존꺼 재사용. ViewPageAdapterTest
//        // 어댑터 : 뷰에 필요한 데이터를 바인딩 (연결 시켜주기)
//        // 어댑터의 더미 데이터 : 프래그먼트가 들어오고 있음. 각각의 프래그먼트가 , 마치 리스트의 요소로 , 인덱스=포지션
//        viewPager.adapter = ViewPageAdapterTest(this)
//
//        // 뷰페이져2, 탭 레이아웃 연결 시켜주는 기능.
//        TabLayoutMediator(tabLayout, viewPager) {
//                tab, position -> tab.text = "Tab${position+1}"
//        }.attach()
//
//
//        binding.mainDrawerView.setNavigationItemSelectedListener {
//                it ->
//            if (it.title == "로그인") {
//                Toast.makeText(this@MainActivity,"로그인 화면 이동", Toast.LENGTH_SHORT).show()
//            }
//            else if (it.title == "로그아웃") {
//                Toast.makeText(this@MainActivity,"로그아웃 화면 이동", Toast.LENGTH_SHORT).show()
//            }
//            else if (it.title == "메인") {
//                Toast.makeText(this@MainActivity,"메인가기 화면 이동", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }
//
//        setSupportActionBar(binding.toolbar)
//
//        // 드로워 화면에 액션 버튼 클릭시 -> 드로워 화면에 나오게.
//        toggle = ActionBarDrawerToggle(this@MainActivity,
//            binding.drawer, R.string.open, R.string.close)
//        // 화면에 붙이는 작업, 적용하기.
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        // 버튼 클릭시, 동기화, 드러워 화면을 열어주는 기능.
//        toggle.syncState()
//
//        //4) floating action button
//        // 이벤트 추가하기.
//        binding.floatingActionButton.setOnClickListener {
//            when(binding.floatingActionButton.isExtended) {
//                true -> binding.floatingActionButton.shrink()
//                false -> binding.floatingActionButton.extend()
//            }
//            Toast.makeText(this@MainActivity,"floatingActionButton 클릭됨", Toast.LENGTH_SHORT).show()
//        }
//
//
//        // 뷰페이저2 프래그먼트 어댑터 이용해서 출력 해보기.
//        // 현재 액티비티 도화지 , 캔버스 , 기본 화면.
//        // 여기에 뷰페이저와, 리사이클러뷰 2개를 붙이 예정.
//
//        //뷰페이저2 준비물 1)프래그먼트 어댑터 2) 목록요소 , 프래그먼트 3개 필요. 3) 더미 데이터(=자기자신)
//        binding.viewPager1.adapter = ViewPageAdapterTest(this)
//        binding.viewPager2.adapter = ViewPageAdapterTest(this)
//        binding.viewPager3.adapter = ViewPageAdapterTest(this)
//
//        // 리사이클러뷰 붙이기
//        // 준비물) 1) 리사이클러뷰 어댑터 2)목록요소의 아이템 뷰 3) 더미 데이터
//        val datas = mutableListOf<String>()
//        for (i in 1..10){
//            datas.add("더미 데이터 추가 번호 $i")
//        }
//        // 출력 방향, 리니어 나란히 수직으로
//        val layoutManager = LinearLayoutManager(this)
////        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//
////        val layoutManager = GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false)
//
//
//        // 리사이클러뷰 속성 옵션에 출력 옵션 붙이기.
//        binding.recyclerViewTest.layoutManager = layoutManager
//        // 리사이클러뷰 속성 옵션에 데이터를 붙이기 , 어댑터 를 연결한다.
//        val customAdapter = RecyclerViewTest(datas)
//        binding.recyclerViewTest.adapter = customAdapter
//
//        //리사이클러 뷰2 에 추가 붙이기 작업.
////        binding.recyclerViewTest2.layoutManager = layoutManager
////        binding.recyclerViewTest2.adapter = customAdapter
//
//
//
////        binding.addBtn.setOnClickListener {
////            datas.add("NEW DATA " + newDataNumber++)
////            customAdapter.notifyItemInserted(datas.size)
////        }
////
////        binding.delBtn.setOnClickListener {
////            datas.removeAt(datas.size - 1)
////            customAdapter.notifyDataSetChanged() // 만능, 되도록 사용x
////        }
//
//
//// OnCreate 끝나는 부분.
//    }
//    // 토클 버튼 이벤트 추가.
////  override fun onOptionsItemSelected(item: MenuItem): Boolean { 추가됨.
//
//
//    // 오버플로우 메뉴 이벤트 핸들러 추가하기.
//    // 만약, 메뉴 교체 하면, 해당 아이디 다시 재정의하기.
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        //이벤트가 toggle 버튼에서 제공된거라면..
//        // 버튼을 열때 이용되는 이벤트 핸들러 부분.
//        if(toggle.onOptionsItemSelected(item)){
//            return true
//            // 오버 플로우 메뉴의 클릭시 이벤트를 ,
//        } else if ( R.id.menu_toolbar1 == item.itemId) {
//            Toast.makeText(this@MainActivity,"툴바메뉴1 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        else if ( R.id.menu_toolbar2 == item.itemId) {
//            Toast.makeText(this@MainActivity,"툴바메뉴2 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//        else if ( R.id.menu_toolbar3 == item.itemId) {
//            Toast.makeText(this@MainActivity,"툴바메뉴3 클릭됨", Toast.LENGTH_SHORT).show()
//            true
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
//
//        // viewBinding 기술을 이용해서, 좀더 쉽게 뷰를 선택하는 방법 이용해서, 해당 화면으로 이동하기.
//    }