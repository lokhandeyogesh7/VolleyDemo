package com.example.volleydemo.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.volleydemo.data.Model
import com.example.volleydemo.global.MyApplication
import com.example.volleydemo.R
import com.example.volleydemo.adapter.RecyclerAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //onclick listener for run button
        btnRun.setOnClickListener {
            //make json request
            callWebApi()
        }

    }

    private fun callWebApi() {

        val tag = "json_request"
        val url = "https://www.pixabay.com/api/?key=7029198-8bf9aba37d11fdec205b7403c&q=yellow&image_type=photo"

        progressBar.visibility = View.VISIBLE

        val jsonObjReq = JsonObjectRequest(Request.Method.GET,
                url, null,
                Response.Listener<JSONObject> { response ->
                    setUpAdapter(response)
                    progressBar.visibility = View.GONE
                },
                Response.ErrorListener {
                    progressBar.visibility = View.GONE
                })

        MyApplication.instance?.addToRequestQueue(jsonObjReq, tag)
    }

    private fun setUpAdapter(response: JSONObject) {
        //initialize gson object
        val gson = Gson()

        //get data from gson and assign to object
        val model = gson.fromJson<Model>(response.toString(), Model::class.java)
        val hitList = model.hits

        //set layout manager for recycler view
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        //set adapter for recycler view
        recyclerView.adapter = RecyclerAdapter(hitList!!)
    }
}
