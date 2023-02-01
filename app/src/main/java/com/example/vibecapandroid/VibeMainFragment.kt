package com.example.vibecapandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.vibecapandroid.R.id.imageView_weekly_item1
import com.example.vibecapandroid.coms.*
import com.example.vibecapandroid.databinding.FragmentVibeMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class VibeMainFragment : Fragment() {
    private lateinit var viewBinding: FragmentVibeMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        viewBinding = FragmentVibeMainBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_vibe_main, container, false)
        val tag1  = viewBinding.tvTag1
        val tag2  = viewBinding.tvTag2
        val tag3  = viewBinding.tvTag3
        val tag4  = viewBinding.tvTag4
        val tag5  = viewBinding.tvTag5
        val tag6  = viewBinding.tvTag6
        val tag7  = viewBinding.tvTag7
        val tag8  = viewBinding.tvTag8
        val addView = viewBinding.btnAddview

        //  post 테스트 용************
        val testPost :ImageView = view.findViewById(R.id.imageButton_1)
        testPost.setOnClickListener{
            val intent = Intent(context, VibePostActivity::class.java)
            startActivity(intent)
        }
        //**********

        val search = viewBinding.imageButtonSearch
        search.setOnClickListener {
            val intent = Intent(context, VibeSearchActivity::class.java)
            startActivity(intent)
        }

        val addpost = viewBinding.btnAddpost
        addpost.setOnClickListener {
            val intent = Intent(context, HistoryPostActivity::class.java)
            startActivity(intent)
        }

        val mypage_alarm2 = viewBinding.imageButtonAlarm
        mypage_alarm2.setOnClickListener {
            val intent = Intent(context, MypageAlarmActivity::class.java)
            startActivity(intent)
        }

        val mypage_profile2  = viewBinding.imageButtonProfile
        mypage_profile2.setOnClickListener {
            val intent = Intent(context, MypageProfileActivity::class.java)
            startActivity(intent)
        }

        val addview = viewBinding.btnAddview
        addview.setOnClickListener{
            val intent = Intent(context, VibeDetailActivity::class.java)
            startActivity(intent)
        }
        defaultTag()
        tag1.setOnClickListener {
            tag1.setTextColor(Color.BLACK)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#신나는 더보기"
            //api
            callTagAPI("신나는")
        }

        tag2.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.BLACK)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#포근한 더보기"
            //api
            callTagAPI("포근한")
        }

        tag3.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.BLACK)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#선선한 더보기"
            //api
            callTagAPI("선선한")
        }

        tag4.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.BLACK)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#낭만적인 더보기"
            //api
            callTagAPI("낭만적인")
        }

        tag5.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.BLACK)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#잔잔한 더보기"
            //api
            callTagAPI("잔잔한")
        }

        tag6.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.BLACK)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#우울한 더보기"
            //api
            callTagAPI("우울한")
        }

        tag7.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.BLACK)
            tag8.setTextColor(Color.GRAY)

            addView.text = "#공허한 더보기"
            //api
            callTagAPI("공허한")
        }

        tag8.setOnClickListener {
            tag1.setTextColor(Color.GRAY)
            tag2.setTextColor(Color.GRAY)
            tag3.setTextColor(Color.GRAY)
            tag4.setTextColor(Color.GRAY)
            tag5.setTextColor(Color.GRAY)
            tag6.setTextColor(Color.GRAY)
            tag7.setTextColor(Color.GRAY)
            tag8.setTextColor(Color.BLACK)

            addView.text = "#심심한 더보기"
            //api
            callTagAPI("심심한")
        }

        requestWeeklyAPI()

        // 뷰페이저 적용
        viewBinding.ViewPagerBanner.adapter = ViewPagerAdapter(getWeeklyList()) // 어댑터 생성
        viewBinding.ViewPagerBanner.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
        val wormDotsIndicator = viewBinding.dotsIndicator
        val viewPager = viewBinding.ViewPagerBanner
        val adapter = ViewPagerAdapter(getWeeklyList())
        viewPager.adapter = adapter
        wormDotsIndicator.attachTo(viewPager)

        return viewBinding.root
    }

    private fun defaultTag() {
        val tag1  = viewBinding.tvTag1
        val tag2  = viewBinding.tvTag2
        val tag3  = viewBinding.tvTag3
        val tag4  = viewBinding.tvTag4
        val tag5  = viewBinding.tvTag5
        val tag6  = viewBinding.tvTag6
        val tag7  = viewBinding.tvTag7
        val tag8  = viewBinding.tvTag8
        val addView = viewBinding.btnAddview

        tag1.setTextColor(Color.BLACK)
        tag2.setTextColor(Color.GRAY)
        tag3.setTextColor(Color.GRAY)
        tag4.setTextColor(Color.GRAY)
        tag5.setTextColor(Color.GRAY)
        tag6.setTextColor(Color.GRAY)
        tag7.setTextColor(Color.GRAY)
        tag8.setTextColor(Color.GRAY)

        addView.text = "#신나는 더보기"
        //api
        callTagAPI("신나는")
    }

    private fun getWeeklyList():  ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.ic_activity_vibe_main_weekly, R.drawable.ic_activity_vibe_main_weekly, R.drawable.ic_activity_vibe_main_weekly)
    }

    // api
    object TagRetrofitObject {
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://ec2-175-41-230-93.ap-northeast-1.compute.amazonaws.com:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getApiService(): VibePostTagInterface {
            return getRetrofit().create(VibePostTagInterface::class.java)
        }
    }
    object WeeklyRetrofitObject {
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://ec2-175-41-230-93.ap-northeast-1.compute.amazonaws.com:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getApiService(): VibePostWeeklyInterface {
            return getRetrofit().create(VibePostWeeklyInterface::class.java)
        }
    }

    // WeeklyAPI
    private fun requestWeeklyAPI(){
        WeeklyRetrofitObject.getApiService().postWeeklyCheck().enqueue(object :
            Callback<PostWeeklyResponse> {
            // api 호출 성공시
            override fun onResponse(call: Call<PostWeeklyResponse>, response: Response<PostWeeklyResponse>) {
                if(response.isSuccessful){
                    val responseData = response.body()

                    if(responseData != null){
                        Log.d(
                            "WeeklyResult",
                            "WeeklyResult\n"+
                                    "isSuccess:${responseData?.is_success}\n " +
                                    "Code: ${responseData?.code} \n" +
                                    "Message:${responseData?.message} \n" +
                                    "result:${responseData.result[1].tag_name}\n"
                        )
                        if(responseData.is_success){
                            when(response.body()?.code){
                                1000 -> {
                                    // 데이터 저장하기
                                    weeklySaveData(0,responseData)
                                    weeklySaveData(1,responseData)
                                    weeklySaveData(2,responseData)
                                }
                            }
                        }else{
                            if (responseData.code == 3011){
                                //Toast.makeText(this@VibeMainFragment,"해당 태그를 가진 게시물이 없습니다.", Toast.LENGTH_SHORT).show()

                            }
                        }
                    }
                }

            }

            // api 호출 실패시
            override fun onFailure(call: Call<PostWeeklyResponse>, t: Throwable) {
                Log.e("retrofit onFailure", "${t.message.toString()}")
            }
        })
    }

    // 태그별 API
    private fun callTagAPI(tagName:String) {
        TagRetrofitObject.getApiService().postAllCheck(tagName).enqueue(object :
            Callback<PostTagResponse> {
            // api 호출 성공시
            override fun onResponse(call: Call<PostTagResponse>, response: Response<PostTagResponse>) {
                if (response.isSuccessful){
                    val responseData = response.body()
                    if (responseData != null){
                        Log.d(
                            "TagResult",
                            "TagResult\n"+
                                    "isSuccess:${responseData?.is_success}\n " +
                                    "Code: ${responseData?.code} \n" +
                                    "Message:${responseData?.message} \n"
                        )
                        if(responseData.is_success){
                            when(response.body()?.code){
                                1000 -> {
                                    // 데이터 저장하기
                                    viewBinding.tagAlert.visibility = View.GONE
                                    viewBinding.tableLayoutMain.visibility = View.VISIBLE
                                    TagsaveData(tagName, responseData)
                                }
                                3011 -> {
                                    viewBinding.tagAlert.visibility = View.VISIBLE
                                    viewBinding.tableLayoutMain.visibility = View.GONE
                                }
                            }
                        }else{
                            if(responseData.code == 3011){
                                // xml에 tvView 추가해서 문구 띄우기
                                Log.d("TagResult", "해당 태그를 가진 게시물이 없습니다.\n")
                                viewBinding.tagAlert.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            }

            // api 호출 실패시
            override fun onFailure(call: Call<PostTagResponse>, t: Throwable) {
                Log.e("retrofit onFailure2", "${t.message.toString()}")
            }
        })
    }

    // 태그별 저장
    private fun TagsaveData(tagName: String, responseData: PostTagResponse) {

        if(tagName.isNullOrEmpty()){
            // textView 추가하기
            Log.d("tagEmpty","태그 이름 없음")
        }else{
            val defaultImage = R.drawable.image_ic_activity_history_album_list1

            // 1번째 post
            val post_id_1 = responseData.result.content[0].post_id
            val member_id_1 = responseData.result.content[0].member_id
            val vibe_id_1 = responseData.result.content[0].vibe_id
            val vibe_image_1 = responseData.result.content[0].vibe_image

            val imageView_1 = requireView().findViewById<ImageView>(R.id.imageButton_1)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_1) // 불러올 이미지 url
                .fitCenter()
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_1) // 이미지를 넣을 뷰

            // 2번째 post
            val post_id_2 = responseData.result.content[1].post_id
            val member_id_2 = responseData.result.content[1].member_id
            val vibe_id_2 = responseData.result.content[1].vibe_id
            val vibe_image_2 = responseData.result.content[1].vibe_image

            val imageView_2 = requireView().findViewById<ImageView>(R.id.imageButton_2)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_2) // 불러올 이미지 url
                .fitCenter()
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_2) // 이미지를 넣을 뷰

            // 3번째 post
            val post_id_3 = responseData.result.content[2].post_id
            val member_id_3 = responseData.result.content[2].member_id
            val vibe_id_3 = responseData.result.content[2].vibe_id
            val vibe_image_3 = responseData.result.content[2].vibe_image

            val imageView_3 = requireView().findViewById<ImageView>(R.id.imageButton_3)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_3) // 불러올 이미지 url
                .override(800,200)
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_3) // 이미지를 넣을 뷰

            // 4번째 post
            val post_id_4 = responseData.result.content[3].post_id
            val member_id_4 = responseData.result.content[3].member_id
            val vibe_id_4 = responseData.result.content[3].vibe_id
            val vibe_image_4 = responseData.result.content[3].vibe_image

            val imageView_4 = requireView().findViewById<ImageView>(R.id.imageButton_4)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_4) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_4) // 이미지를 넣을 뷰

            // 5번째 post
            val post_id_5 = responseData.result.content[4].post_id
            val member_id_5 = responseData.result.content[4].member_id
            val vibe_id_5 = responseData.result.content[4].vibe_id
            val vibe_image_5 = responseData.result.content[4].vibe_image

            val imageView_5 = requireView().findViewById<ImageView>(R.id.imageButton_5)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_5) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_5) // 이미지를 넣을 뷰

            // 6번째 post
            val post_id_6 = responseData.result.content[5].post_id
            val member_id_6 = responseData.result.content[5].member_id
            val vibe_id_6 = responseData.result.content[5].vibe_id
            val vibe_image_6 = responseData.result.content[5].vibe_image

            val imageView_6 = requireView().findViewById<ImageView>(R.id.imageButton_6)
            Glide.with(this@VibeMainFragment)
                .load(vibe_image_6) // 불러올 이미지 url
                .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(imageView_6) // 이미지를 넣을 뷰
        }


    }

    // Weekly 저장
    private fun weeklySaveData(id: Int, responseData: PostWeeklyResponse){

        val post_id = responseData.result[id].post_id
        val tag_name = responseData.result[id].tag_name
        val vibe_image = responseData.result[id].vibe_image

        // post id 설정
        viewBinding.ViewPagerBanner

        // tag name 설정
        if (tag_name.isNullOrEmpty()) {
            requireView().findViewById<TextView>(R.id.weeklyTagLinear).visibility = View.GONE
        } else {
            // tag name 을 공백으로 구분
            val tagList = tag_name.split(buildString {
                append("\\s")
            }.toRegex()).toTypedArray()
            // tag name 앞에 # 붙여주기
            for (i in tagList.indices) {
                tagList[i] = "#" + tagList[i]
            }
            // tag name 최대 3개
            when (tagList.size) {
                1 -> {
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.text = tagList[1]
                    requireView().findViewById<TextView>(R.id.weekly_tag_second_tv).visibility = View.GONE
                    requireView().findViewById<TextView>(R.id.weekly_tag_third_tv).visibility = View.GONE

                }
                2 -> {
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.text = tagList[0]
                    requireView().findViewById<TextView>(R.id.weekly_tag_second_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_second_tv)!!.text = tagList[1]
                    requireView().findViewById<TextView>(R.id.weekly_tag_third_tv).visibility = View.GONE
                }
                3 -> {
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_first_tv)!!.text = tagList[0]
                    requireView().findViewById<TextView>(R.id.weekly_tag_second_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_second_tv)!!.text = tagList[1]
                    requireView().findViewById<TextView>(R.id.weekly_tag_third_tv)!!.visibility = View.VISIBLE
                    requireView().findViewById<TextView>(R.id.weekly_tag_third_tv)!!.text = tagList[2]
                }
            }

            // 이미지 설정
            when (id){
                0 -> {
                    val imageView = requireView().findViewById<ImageView>(imageView_weekly_item1)
                    val defaultImage = R.drawable.ic_activity_vibe_main_banner
                    val url = vibe_image
                    //val url = "https://firebasestorage.googleapis.com/v0/b/vibecap-ee692.appspot.com/o/b9bf7d74-88f3-4b06-952b-dc9c59f8090ajpg?alt=media"
                    Glide.with(this@VibeMainFragment)
                        .load(url) // 불러올 이미지 url
                        .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                        .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                        .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                        .into(imageView) // 이미지를 넣을 뷰
                }
                1 -> {
                    val imageView = requireView().findViewById<ImageView>(imageView_weekly_item1)
                    val defaultImage = R.drawable.ic_activity_vibe_main_banner
                    val url = vibe_image
                    //val url = "https://firebasestorage.googleapis.com/v0/b/vibecap-ee692.appspot.com/o/b9bf7d74-88f3-4b06-952b-dc9c59f8090ajpg?alt=media"
                    Glide.with(this@VibeMainFragment)
                        .load(url) // 불러올 이미지 url
                        .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                        .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                        .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                        .into(imageView) // 이미지를 넣을 뷰
                }
                2 -> {
                    val imageView = requireView().findViewById<ImageView>(imageView_weekly_item1)
                    val defaultImage = R.drawable.ic_activity_vibe_main_banner
                    val url = vibe_image
                    //val url = "https://firebasestorage.googleapis.com/v0/b/vibecap-ee692.appspot.com/o/b9bf7d74-88f3-4b06-952b-dc9c59f8090ajpg?alt=media"
                    Glide.with(this@VibeMainFragment)
                        .load(url) // 불러올 이미지 url
                        .placeholder(defaultImage) // 이미지 로딩 시작하기 전 표시할 이미지
                        .error(defaultImage) // 로딩 에러 발생 시 표시할 이미지
                        .fallback(defaultImage) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                        .into(imageView) // 이미지를 넣을 뷰
                }
            }



        }

    }
}
