package com.wkq.snaphelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.*
import com.wkq.snaphelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    val path = "https://img2.baidu.com/it/u=686238839,986827545&fm=253&fmt=auto&app=138&f=JPEG"
    var stringList= arrayListOf<String>(path,path,path,path,path,path,path,path,path,path,path,path,path,path,path,path,path)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        //设置布局选择
        binding!!.rvContent.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //默认网格布局
        var mAdapter = SnapAdapter(this)
        binding!!.rvContent.adapter = mAdapter
        mAdapter.addItems(stringList)

        var pageHelp=LinearSnapHelper()

        pageHelp.attachToRecyclerView( binding!!.rvContent)
    }
}