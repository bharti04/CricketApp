package com.example.cricketapp

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.cricketapp.adapter.MatchAdapter
import com.example.cricketapp.util.RecyclerItemClickListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import android.support.v4.view.ViewPager
import android.view.View
import com.example.cricketapp.R.id.viewPager
import com.example.cricketapp.adapter.ShowDesignAdapter
import android.support.design.widget.TabLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.cricketapp.util.AppConstants
import kotlinx.android.synthetic.main.match_layout.*
import java.util.*


class MatchActivity:AppCompatActivity() {
    lateinit var arrayList:ArrayList<DataModal>
    var t1name:String=""
    var t1run:String=""
    var t1over:String=""
    var t1viket:String=""
    var t2name:String=""
    var t2run:String=""
    var t2over:String=""
    var t2viket:String=""
    var t1flag:String=""
    var t2flag:String=""
    var status:String=""
    var matchType:String=""
    var inning:String=""

    var keyid:String=""
    var choosebattingTeam:String=""

    var needruntowin:String=""
    var  tosswinteam:String=""
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: MatchAdapter
    lateinit var viewpageradpter: ShowDesignAdapter
    lateinit var tabLayout:TabLayout
    lateinit var viewPager: ViewPager
    var currentPage=0
    var needrun=""
    var run:Int=0
    var balls:Int=0

    var runt1value:Int=0
    var overt1value:Int=0
    var wickett1value:Int=0
    var runt2value:Int=0
    var overt2value:Int=0
    var wickett2value:Int=0
    lateinit var dialog: ProgressDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.match_layout)

        relative_layout.visibility=View.INVISIBLE
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")
        arrayList=ArrayList<DataModal>()
        recyclerView=findViewById(R.id.recycler_view)
        viewPager = findViewById(R.id.viewPager)
        dialog = ProgressDialog(this@MatchActivity)
        dialog.setMessage("Loading..")
        dialog.show()
        if(AppConstants.checkInternetConnection(this)){
        }else{
            dialog.dismiss()
            Toast.makeText(this@MatchActivity,"Please check your internet connection.",Toast.LENGTH_LONG).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        adapter = MatchAdapter(arrayList, this@MatchActivity)
        recyclerView.adapter=adapter


        
        viewpageradpter = ShowDesignAdapter(this@MatchActivity, arrayList)
        Log.d("Conditions", "adapter " + viewpageradpter.getCount())
        viewPager.setAdapter(viewpageradpter)
        var handler = Handler()
        var Update = Runnable {
            if (currentPage === arrayList.size ) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }
        val  timer = Timer() // This will create a new Thread
        timer.scheduleAtFixedRate(object : TimerTask() { // task to be scheduled

            override fun run() {
                handler.post(Update)
            }
        }, 0, 5000)
        //  adapter.notifyDataSetChanged();

        tabLayout = findViewById(R.id.tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager, true)

        recyclerView.addOnItemTouchListener(
                RecyclerItemClickListener(this, RecyclerItemClickListener.OnItemClickListener { view, position ->
                    var matchid=arrayList.get(position).key


                    val intent= Intent(this,MainActivity::class.java)
                    intent.putExtra("KEY",matchid)


                    startActivity(intent)
                }))

//for add child object
        /*  DatabaseReference path= database.getReference("matches").child("match4");
        path.child("Batsman").setValue("123");*/

//Log.d("bharti","key"+key);

        // myRef.setValue("Hello, World!");
        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dialog.dismiss()
                relative_layout.visibility=View.VISIBLE

                if (arrayList.size > 0) {
                    arrayList.clear()
                }
                for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    keyid = taskNo.key!!
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                    taskNo.child("status").value?.let {
                        status = taskNo.child("status").value.toString()

                    }

                    taskNo.child("tossWiningTeam").value?.let {
                        tosswinteam = taskNo.child("tossWiningTeam").value.toString()
                    }
                    taskNo.child("remainingBalls").value?.let {
                        needruntowin = taskNo.child("remainingBalls").value.toString()
                    }
                    taskNo.child("chooseBattingTeam").value?.let {
                        choosebattingTeam = taskNo.child("chooseBattingTeam").value!!.toString()
                    }

                    taskNo.child("matchType").value?.let {
                        matchType = taskNo.child("matchType").value!!.toString()
                    }
                    taskNo.child("inning").value?.let {
                        inning = taskNo.child("inning").value!!.toString()
                    }
                   /* status = taskNo.child("status").value!!.toString()
                    matchType = taskNo.child("matchType").value!!.toString()
                    val tosswinteam = taskNo.child("tossWiningTeam").value!!.toString()
                    needruntowin = taskNo.child("remainingBalls").value!!.toString()
                    inning = taskNo.child("inning").value!!.toString()
                    choosebattingTeam = taskNo.child("chooseBattingTeam").value!!.toString()
*/
                    Log.d("bharti11", "Value is: $keyid $tosswinteam $status $needruntowin ${taskNo.key}")
                    // ALTERNATIVE
                    //if(key.equals("match1")) {
                    for (child in taskNo.children) {
                        if (child.key == "team1") {
                            child.child("over").value?.let {
                                t1over = child.child("over").value!!.toString()
                            }
                            child.child("name").value?.let {
                                t1name = child.child("name").value!!.toString()
                            }
                            child.child("run").value?.let {

                                t1run = child.child("run").value!!.toString()
                            }
                            child.child("wicket").value?.let {

                                t1viket = child.child("wicket").value!!.toString()
                            }


                        } else if (child.key == "team2") {
                            child.child("over").value?.let {
                                t2over = child.child("over").value!!.toString()
                            }
                            child.child("name").value?.let {
                                t2name = child.child("name").value!!.toString()
                            }
                            child.child("run").value?.let {

                                t2run = child.child("run").value!!.toString()
                            }
                            child.child("wicket").value?.let {

                                t2viket = child.child("wicket").value!!.toString()
                            }
                          /* if(t1run.toIntOrNull()!=null &&t1over.toIntOrNull()!=null&&
                                   t1viket.toIntOrNull()!=null&&t2run.toIntOrNull()!=null &&
                                   t2over.toIntOrNull()!=null&&t2viket.toIntOrNull()!=null) {
                               runt1value = t1run.toIntOrNull()!!
                               overt1value = t1over.toIntOrNull()!!
                               wickett1value = t1viket.toIntOrNull()!!
                               runt2value = t2run.toIntOrNull()!!
                               overt2value = t2over.toIntOrNull()!!
                               wickett2value = t2viket.toIntOrNull()!!
                           }

                            if(inning.equals("2")) {
                                if (choosebattingTeam.equals(t2name)) {
                                    run = t1Run(runt1value, runt2value)
                                } else {
                                    run = t2Run(runt2value, runt1value)
                                }
                            }*/

                            //balls = balls(overt2value)

                               // Log.d("bharti", "Child t2 Value is: $t2over $t2name $t2rate1 $t2rate2 $t2run $t2viket")

                        } /*else if (child.key == "Batsman") {
                            val b1name = child.child("b1").child("name").value!!.toString()
                            val b1run = child.child("b1").child("R").value!!.toString()
                            val b1ball = child.child("b1").child("B").value!!.toString()
                            val b14s = child.child("b1").child("4s").value!!.toString()
                            val b16s = child.child("b1").child("6s").value!!.toString()
                            val b1sr = child.child("b1").child("SR").value!!.toString()

                            Log.d("bharti", "subChild b1 Value is: $b1name $b1run $b1ball $b14s $b16s $b1sr")

                            val b2name = child.child("b2").child("name").value!!.toString()
                            val b2run = child.child("b2").child("R").value!!.toString()
                            val b2ball = child.child("b2").child("B").value!!.toString()
                            val b24s = child.child("b2").child("4s").value!!.toString()
                            val b26s = child.child("b2").child("6s").value!!.toString()
                            val b2sr = child.child("b2").child("SR").value!!.toString()

                            Log.d("bharti", "subChild b2 Value is: $b2name $b2run $b2ball $b24s $b26s $b2sr")

                        } else if (child.key == "Bowling") {
                            val bowler1name = child.child("bowler1").child("name").value!!.toString()
                            val bowler1run = child.child("bowler1").child("O").value!!.toString()
                            val bowler1ball = child.child("bowler1").child("M").value!!.toString()
                            val bowler14s = child.child("bowler1").child("R").value!!.toString()
                            val bowler16s = child.child("bowler1").child("W").value!!.toString()
                            val bowler1sr = child.child("bowler1").child("ER").value!!.toString()

                            Log.d("bharti", "subChild bowler1 Value is: $bowler1name $bowler1run $bowler1ball $bowler14s $bowler16s $bowler1sr")

                            val bowler2name = child.child("bowler2").child("name").value!!.toString()
                            val bowler2run = child.child("bowler2").child("O").value!!.toString()
                            val bowler2ball = child.child("bowler2").child("M").value!!.toString()
                            val bowler24s = child.child("bowler2").child("R").value!!.toString()
                            val bowler26s = child.child("bowler2").child("W").value!!.toString()
                            val bowler2sr = child.child("bowler2").child("ER").value!!.toString()

                            Log.d("bharti", "subChild bowler2 Value is: $bowler2name $bowler2run $bowler2ball $bowler24s $bowler26s $bowler2sr")

                        }*/


                        // }
                    }
                    if(inning.equals("2")) {
                        if (choosebattingTeam.equals(t2name)) {

                            run =t1run.toInt()-t2run.toInt()
                            Log.d("bharti","value t1Run"+run)
                        } else if(choosebattingTeam.equals(t1name)){
                            run = t2run.toInt()-t1run.toInt()
                            Log.d("bharti","value t2Run"+run)
                        }
                    }

                    if(inning.equals("1")){
                        if(choosebattingTeam.equals(t1name)){
                            if (t1viket.toInt().equals(10) && matchType.equals("T20") && inning.equals("1") || t1over.toFloat().equals(20) && matchType.equals("T20") && inning.equals("1")) {
                                needrun = "Need" + " " + needRun(t1run.toInt()).toString() + " " + "runs on 120 balls."
                            }
                            else if (t1viket.toInt().equals(10) && matchType.equals("ODI") && inning.equals("1") || t1over.toFloat().equals(50) && matchType.equals("ODI") && inning.equals("1")) {
                                needrun = "Need" + " " + needRun(t1run.toInt()).toString() + " " + "runs on 300 balls."
                            }
                        }else{
                            if (t2viket.toInt().equals(10) && matchType.equals("T20") && inning.equals("1") || t2over.toFloat().equals(20) && matchType.equals("T20") && inning.equals("1")) {
                                needrun = "Need" + " " + needRun(t2run.toInt()).toString() + " " + "runs on 120 balls."
                            }
                            else if (t2viket.toInt().equals(10) && matchType.equals("ODI") && inning.equals("1") || t2over.toFloat().equals(50) && matchType.equals("ODI") && inning.equals("1")) {
                                needrun = "Need" + " " + needRun(t2run.toInt()).toString() + " " + "runs on 300 balls."
                            }
                        }

                    }

                    if(inning.equals("2")){
                        if(choosebattingTeam.equals(t1name)){
                            if (t1viket.toInt().equals(10) && matchType.equals("T20") && status.equals("Finished") || t1over.toFloat().equals(20) && matchType.equals("T20") && status.equals("Finished")) {
                                if (t1run.toInt() > t2run.toInt()) {

                                    needrun = t1name + " " + "won by" + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                } else {
                                    needrun = t2name + " " + "won by" + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                }
                            }
                            else if (t1viket.toInt().equals(10) && matchType.equals("ODI") && status.equals("Finished") || t1over.toFloat().equals(50) && matchType.equals("ODI") && status.equals("Finished")) {
                                if (t1run.toInt() > t2run.toInt()) {

                                    needrun = t1name + " " + "won by" + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                } else {
                                    needrun = t2name + " " + "won by" + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                }
                            }
                        }else{
                            if (t2viket.toInt().equals(10) && matchType.equals("T20") && status.equals("Finished") || t2over.toFloat().equals(20) && matchType.equals("T20") && status.equals("Finished")) {
                                if (t1run.toInt() > t2run.toInt()) {

                                    needrun = t1name + " " + "won by" + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                } else {
                                    needrun = t2name + " " + "won by" + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                }
                            }
                            else if (t2viket.toInt().equals(10) && matchType.equals("ODI") && status.equals("Finished") || t2over.toFloat().equals(50) && matchType.equals("ODI") && status.equals("Finished")) {
                                if (t1run.toInt() > t2run.toInt()) {

                                    needrun = t1name + " " + "won by" + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                } else {
                                    needrun = t2name + " " + "won by" + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                    Log.d("bharti","value t1name if"+needrun)

                                }
                            }
                        }

                    }
                       /* if (wickett1value.equals(10) && matchType.equals("Test") && inning.equals("1") || overt1value.equals(90) && matchType.equals("Test") && inning.equals("1")) {
                            needrun = "Need" + " " + needRun(runt1value).toString() + " " + "runs on 540 balls."
                        }*/





                        /*if (wickett2value.equals(10) && matchType.equals("Test") && status.equals("Finished") || overt2value.equals(90) && matchType.equals("Test") && status.equals("Finished")) {
                            if (runt1value > runt2value) {
                                needrun = t1name + " " + "won by" + wont1Run(runt1value, runt2value).toString() + " " + "runs"
                            } else {
                                needrun = t2name + " " + "won by" + wont2Run(runt1value, runt2value).toString() + " " + "runs"

                            }
                        }*/



                     /*if(t2viket.toInt().equals(10)||t2over.toInt().equals(20)){
                         needrun="Need"+" "+needRun(t2run).toString()+" "+"runs on 120 balls."
                     }*/
                    if(inning.equals("2")&& status.equals("Live") ) {
                        needrun = "Need" + " " + run.toString() + " " + "runs on" + " " + needruntowin + " " + "balls."
                    }
                    if(inning.equals("2")){
                        if(choosebattingTeam.equals(t1name)) {
                            if (t1run.toInt() > t2run.toInt()) {

                                needrun = t1name + " " + "won by" +  " " +wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti", "value t1name if" + needrun)

                            }
                        }
                        else if(choosebattingTeam.equals(t2name)) {
                            if (t2run.toInt() > t1run.toInt()) {

                                needrun = t2name + " " + "won by" + " " + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti", "value t1name if" + needrun)

                            }
                        }

                    }

                    Log.d("bharti1", "arraylistsize:$needrun")
                   // needruntowin=needrun
                    arrayList.add(DataModal(keyid,status, needrun, t1name,t1run,t1over,t1viket,t2name,t2run,t2over,t2viket,t1flag,t2flag,inning))

                    Log.d("bharti1", "arraylistsize:$needrun")
                    adapter.notifyDataSetChanged()
                    viewpageradpter.notifyDataSetChanged()
                    needrun=" "

                }



                //Log.d("bharti", "Value is: " + value.tosswinteam);
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                dialog.dismiss()
                Log.w("bharti", "Failed to read value.", error.toException())
                Toast.makeText(this@MatchActivity,"Failed to read value.", Toast.LENGTH_LONG).show()

            }
        })


    }
    fun needRun(run:Int):Int{
        var needrun1=run+1
        return needrun1
    }
    fun t1Run(t1run:Int,t2run:Int):Int{
        var needrun2=t1run-t2run
        return needrun2
    }
    fun t2Run(t2run:Int,t1run:Int):Int{
        var needrun2=t2run-t1run
        return needrun2
    }
    fun balls(t2over:Int):Int{
        var needrun3=t2over*6
        return needrun3
    }
    fun wont1Run(t1run:Int,t2run:Int):Int{
        var needrun2=t1run-t2run
        return needrun2
    }
    fun wont2Run(t1run:Int,t2run:Int):Int{
        var needrun2=t2run-t1run
        return needrun2
    }
}