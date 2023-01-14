package com.example.vibecapandroid

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MypageSetupActivity : AppCompatActivity() {


    var setupList1 = arrayListOf<MypageSetupClass>(
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_edit,"닉네임 변경",R.drawable.ic_activity_mypage_profile_next),
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_alarm,"알림 설정",R.drawable.ic_activity_mypage_profile_next)
    )
    var setupList2 = arrayListOf<MypageSetupClass>(
        MypageSetupClass(R.drawable.ic_activity_mypage_profile_act,"구글 계정 연동하기",R.drawable.ic_activity_mypage_profile_next),
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_logout,"로그아웃",0),
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_logout,"회원 탈퇴",0)
    )
    var setupList3 = arrayListOf<MypageSetupClass>(
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_notion,"공지사항",R.drawable.ic_activity_mypage_profile_next),
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_inquiry,"문의하기/신고하기",R.drawable.ic_activity_mypage_profile_next),
        MypageSetupClass(R.drawable.ic_activity_mypage_setup_list,"오픈소스 라이센스",R.drawable.ic_activity_mypage_profile_next)
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_setuplist)

        val Adapter1 = MypageSetupadaptersClass(this, setupList1)
        val activity_mypage_setuplist1 = findViewById<ListView>(R.id.activity_mypage_setuplist1)
        activity_mypage_setuplist1.adapter = Adapter1

        activity_mypage_setuplist1.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                if(position==0){
                    val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                    val intent = Intent(this,MypageNicknameActivity::class.java)
                    intent.putExtra("스크랩 한 게시물",setupList1[position].profile_textview)
                    startActivity(intent)}
                if (position == 1) {
                    val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                    val intent = Intent(this, MypageAlarmsetupActivity::class.java)
                    intent.putExtra("알림 설정", setupList1[position].profile_textview)
                    startActivity(intent)
                }
            }

        val Adapter2 = MypageSetupadaptersClass(this, setupList2)
        val activity_mypage_setuplist2 = findViewById<ListView>(R.id.activity_mypage_setuplist2)
        activity_mypage_setuplist2.adapter = Adapter2

        activity_mypage_setuplist2.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                if (position == 1) {
                    val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("로그아웃 하시겠습니까?")
                        .setPositiveButton("로그아웃",
                            DialogInterface.OnClickListener { dialog, id ->
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                            })
                        .setNegativeButton("취소",
                            DialogInterface.OnClickListener { dialog, id ->
                            })
                    builder.show()
                }
                if (position==2){
                    val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("탈퇴하시겠습니까?")
                        .setPositiveButton("네",
                            DialogInterface.OnClickListener { dialog, id ->
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("정말 계정을 탈퇴하시겠습니까?")
                                    .setMessage("계정이 영구히 삭제됩니다")
                                    .setPositiveButton("계정 삭제",
                                        DialogInterface.OnClickListener { dialog, id ->
                                            val intent = Intent(this, LoginActivity::class.java)
                                            startActivity(intent)
                                        })
                                    .setNegativeButton("취소",
                                        DialogInterface.OnClickListener { dialog, id ->
                                        })
                                // 다이얼로그를 띄워주기
                                builder.show()
                            })
                        .setNegativeButton("취소",
                            DialogInterface.OnClickListener { dialog, id ->
                            })
                    // 다이얼로그를 띄워주기
                    builder.show()


                }


                }

                val Adapter3 = MypageSetupadaptersClass(this, setupList3)
                val activity_mypage_setuplist3 =
                    findViewById<ListView>(R.id.activity_mypage_setuplist3)
                activity_mypage_setuplist3.adapter = Adapter3

                activity_mypage_setuplist3.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id ->

                    //노션 하이퍼링크 이동 (작동안함)
                    if (position == 0) {
                        val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                        intent.setData(Uri.parse("https://www.notion.so/VibeCap-c03b628aad594738b150c71dcc44cc67"));
                        startActivity(intent);
                    }
                    if (position == 1) {
                        val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                        intent.setData(Uri.parse("https://www.notion.so/VibeCap-c03b628aad594738b150c71dcc44cc67"));
                        startActivity(intent);
                    }
                    if (position == 2) {
                        val selectItem = parent.getItemAtPosition(position) as MypageSetupClass
                        intent.setData(Uri.parse("https://www.notion.so/VibeCap-c03b628aad594738b150c71dcc44cc67"));
                        startActivity(intent);
                    }
                }

                val mypage_back = findViewById<ImageView>(R.id.activity_mypage_nickname_close)
                mypage_back.setOnClickListener(View.OnClickListener {
                    val intent = Intent(this, MypageProfileActivity::class.java)
                    startActivity(intent)
                })
            }
    }