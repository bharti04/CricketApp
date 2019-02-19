package com.example.cricketapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.livematch_layout.*
import kotlinx.android.synthetic.main.livematch_layout.view.*
import java.text.DecimalFormat
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    internal var textView: TextView? = null
    var matchid: String=""

    var status :String?=null
    var twinteam :String=""
    var needruntowin:String=""
    var choosebattingTeam:String=""

    var pstrike :String=""
    var bstrike :String=""

    var batsman1:String=""
    var batsman2:String=""
    var bowler1:String=""
    var bowler2:String=""

    var t1over :String=""
    var t1name :String=""
    var t1rate1 :String=""
    var t1rate2 :String=""
    var t1run :String=""
    var t1viket:String=""
    var t1flag:String=""


    var t2over:String=""
    var t2name :String=""
    var t2rate1:String=""
    var t2rate2:String=""
    var t2run :String=""
    var t2viket:String=""
    var t2flag:String=""

    var b1name :String=""
    var b1run :String=""
    var b1ball :String=""
    var b14s :String=""
    var b16s :String=""
    var b1sr:String=""

    var b2name :String=""
    var b2run :String=""
    var b2ball:String=""
    var b24s :String=""
    var b26s :String=""
    var b2sr:String=""

    var bowler1name :String=""
    var bowler1o :String=""
    var bowler1m :String=""
    var bowler1r :String=""
    var bowler1w:String=""
    var bowler1er:String=""

    var bowler2name :String=""
    var bowler2o :String=""
    var bowler2m :String=""
    var bowler2r:String=""
    var bowler2w :String=""
    var bowler2er:String=""

    var matchType:String=""
    var inning:String=""
    var needrun:String=""
    var run:Int=0
    var r:Int=0
    var balls:Int=0

    var runt1value:Int=0
    var overt1value:Int=0
    var wickett1value:Int=0
    var runt2value:Int=0
    var overt2value:Int=0
    var wickett2value:Int=0

    var batsman1run:Float=0f
    var batsman2run:Float=0f
    var batsman1ball:Float=0f
    var batsman2ball:Float=0f

    var bowler1run:Float=0f
    var bowler2run:Float=0f
    var bowler1over:Float=0f
    var bowler2over:Float=0f

    var t1p1name:String=""
    var t1p1run:String=""
    var t1p1balls:String=""
    var t1p14s:String=""
    var t1p16s:String=""
    var t1b1run:String=""
    var t1b1over:String=""
    var t1b1M:String=""
    var t1b1W:String=""

    var t1p2name:String=""
    var t1p2run:String=""
    var t1p2balls:String=""
    var t1p24s:String=""
    var t1p26s:String=""
    var t1b2run:String=""
    var t1b2over:String=""
    var t1b2M:String=""
    var t1b2W:String=""

    var t1p3name:String=""
    var t1p3run:String=""
    var t1p3balls:String=""
    var t1p34s:String=""
    var t1p36s:String=""
    var t1b3run:String=""
    var t1b3over:String=""
    var t1b3M:String=""
    var t1b3W:String=""

    var t1p4name:String=""
    var t1p4run:String=""
    var t1p4balls:String=""
    var t1p44s:String=""
    var t1p46s:String=""
    var t1b4run:String=""
    var t1b4over:String=""
    var t1b4M:String=""
    var t1b4W:String=""

    var t1p5name:String=""
    var t1p5run:String=""
    var t1p5balls:String=""
    var t1p54s:String=""
    var t1p56s:String=""
    var t1b5run:String=""
    var t1b5over:String=""
    var t1b5M:String=""
    var t1b5W:String=""

    var t1p6name:String=""
    var t1p6run:String=""
    var t1p6balls:String=""
    var t1p64s:String=""
    var t1p66s:String=""
    var t1b6run:String=""
    var t1b6over:String=""
    var t1b6M:String=""
    var t1b6W:String=""

    var t1p7name:String=""
    var t1p7run:String=""
    var t1p7balls:String=""
    var t1p74s:String=""
    var t1p76s:String=""
    var t1b7run:String=""
    var t1b7over:String=""
    var t1b7M:String=""
    var t1b7W:String=""

    var t1p8name:String=""
    var t1p8run:String=""
    var t1p8balls:String=""
    var t1p84s:String=""
    var t1p86s:String=""
    var t1b8run:String=""
    var t1b8over:String=""
    var t1b8M:String=""
    var t1b8W:String=""

    var t1p9name:String=""
    var t1p9run:String=""
    var t1p9balls:String=""
    var t1p94s:String=""
    var t1p96s:String=""
    var t1b9run:String=""
    var t1b9over:String=""
    var t1b9M:String=""
    var t1b9W:String=""

    var t1p10name:String=""
    var t1p10run:String=""
    var t1p10balls:String=""
    var t1p104s:String=""
    var t1p106s:String=""
    var t1b10run:String=""
    var t1b10over:String=""
    var t1b10M:String=""
    var t1b10W:String=""

    var t1p11name:String=""
    var t1p11run:String=""
    var t1p11balls:String=""
    var t1p114s:String=""
    var t1p116s:String=""
    var t1b11run:String=""
    var t1b11over:String=""
    var t1b11M:String=""
    var t1b11W:String=""

    var t1p12name:String=""
    var t1p12run:String=""
    var t1p12balls:String=""
    var t1p124s:String=""
    var t1p126s:String=""
    var t1b12run:String=""
    var t1b12over:String=""
    var t1b12M:String=""
    var t1b12W:String=""



    var t2p1name:String=""
    var t2p1run:String=""
    var t2p1balls:String=""
    var t2p14s:String=""
    var t2p16s:String=""
    var t2b1run:String=""
    var t2b1over:String=""
    var t2b1M:String=""
    var t2b1W:String=""

    var t2p2name:String=""
    var t2p2run:String=""
    var t2p2balls:String=""
    var t2p24s:String=""
    var t2p26s:String=""
    var t2b2run:String=""
    var t2b2over:String=""
    var t2b2M:String=""
    var t2b2W:String=""

    var t2p3name:String=""
    var t2p3run:String=""
    var t2p3balls:String=""
    var t2p34s:String=""
    var t2p36s:String=""
    var t2b3run:String=""
    var t2b3over:String=""
    var t2b3M:String=""
    var t2b3W:String=""

    var t2p4name:String=""
    var t2p4run:String=""
    var t2p4balls:String=""
    var t2p44s:String=""
    var t2p46s:String=""
    var t2b4run:String=""
    var t2b4over:String=""
    var t2b4M:String=""
    var t2b4W:String=""

    var t2p5name:String=""
    var t2p5run:String=""
    var t2p5balls:String=""
    var t2p54s:String=""
    var t2p56s:String=""
    var t2b5run:String=""
    var t2b5over:String=""
    var t2b5M:String=""
    var t2b5W:String=""

    var t2p6name:String=""
    var t2p6run:String=""
    var t2p6balls:String=""
    var t2p64s:String=""
    var t2p66s:String=""
    var t2b6run:String=""
    var t2b6over:String=""
    var t2b6M:String=""
    var t2b6W:String=""

    var t2p7name:String=""
    var t2p7run:String=""
    var t2p7balls:String=""
    var t2p74s:String=""
    var t2p76s:String=""
    var t2b7run:String=""
    var t2b7over:String=""
    var t2b7M:String=""
    var t2b7W:String=""

    var t2p8name:String=""
    var t2p8run:String=""
    var t2p8balls:String=""
    var t2p84s:String=""
    var t2p86s:String=""
    var t2b8run:String=""
    var t2b8over:String=""
    var t2b8M:String=""
    var t2b8W:String=""

    var t2p9name:String=""
    var t2p9run:String=""
    var t2p9balls:String=""
    var t2p94s:String=""
    var t2p96s:String=""
    var t2b9run:String=""
    var t2b9over:String=""
    var t2b9M:String=""
    var t2b9W:String=""

    var t2p10name:String=""
    var t2p10run:String=""
    var t2p10balls:String=""
    var t2p104s:String=""
    var t2p106s:String=""
    var t2b10run:String=""
    var t2b10over:String=""
    var t2b10M:String=""
    var t2b10W:String=""

    var t2p11name:String=""
    var t2p11run:String=""
    var t2p11balls:String=""
    var t2p114s:String=""
    var t2p116s:String=""
    var t2b11run:String=""
    var t2b11over:String=""
    var t2b11M:String=""
    var t2b11W:String=""

    var t2p12name:String=""
    var t2p12run:String=""
    var t2p12balls:String=""
    var t2p124s:String=""
    var t2p126s:String=""
    var t2b12run:String=""
    var t2b12over:String=""
    var t2b12M:String=""
    var t2b12W:String=""







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.livematch_layout)
        val intent = intent
        matchid = intent.getStringExtra("KEY")


        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")


        //for add child object
        /*  DatabaseReference path= database.getReference("matches").child("match4");
        path.child("Batsman").setValue("123");*/

        //Log.d("bharti","key"+key);

        // myRef.setValue("Hello, World!");
        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    val key = taskNo.key
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                 // if(!taskNo.children.equals(null))
                    if (key == matchid) {
                        taskNo.child("status").value?.let {
                            status = taskNo.child("status").value.toString()

                        }
                        taskNo.child("bowlerStrike").value?.let {
                            bstrike = taskNo.child("bowlerStrike").value.toString()

                        }
                        taskNo.child("batsmanStrike").value?.let {
                            pstrike = taskNo.child("batsmanStrike").value.toString() }

                        taskNo.child("tossWiningTeam").value?.let {
                            twinteam = taskNo.child("tossWiningTeam").value.toString()
                        }
                        taskNo.child("remainingBalls").value?.let {
                            needruntowin = taskNo.child("remainingBalls").value.toString()
                        }
                        taskNo.child("chooseBattingTeam").value?.let {
                            choosebattingTeam = taskNo.child("chooseBattingTeam").value!!.toString()
                        }
                        taskNo.child("batsman1").value?.let {
                            batsman1= taskNo.child("batsman1").value.toString()
                        }
                        taskNo.child("batsman2").value?.let {
                            batsman2 = taskNo.child("batsman2").value.toString()
                        }
                        taskNo.child("bowler1").value?.let {
                            bowler1 = taskNo.child("bowler1").value!!.toString()
                        }
                        taskNo.child("bowler2").value?.let {
                            bowler2 = taskNo.child("bowler2").value!!.toString()
                        }
                        taskNo.child("matchType").value?.let {
                            matchType = taskNo.child("matchType").value!!.toString()
                        }
                        taskNo.child("inning").value?.let {
                            inning = taskNo.child("inning").value!!.toString()
                        }


                       /* twinteam = taskNo.child("tossWiningTeam").value!!.toString()
                        needruntowin = taskNo.child("remainingBalls").value!!.toString()
                        choosebattingTeam = taskNo.child("chooseBattingTeam").value!!.toString()
                        batsman1= taskNo.child("batsman1").value!!.toString()
                        batsman2 = taskNo.child("batsman2").value!!.toString()
                        bowler1 = taskNo.child("bowler1").value!!.toString()
                        bowler2 = taskNo.child("bowler2").value!!.toString()

                        matchType = taskNo.child("matchType").value!!.toString()
                        inning = taskNo.child("inning").value!!.toString()
*/
                            Log.d("bharti", "Value is: $key $twinteam $status $needruntowin")
                    // ALTERNATIVE

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

                                    t1p1name = child.child("players").child("0").child("name").value!!.toString()
                                    t1p1run = child.child("players").child("0").child("batting").child("R").value!!.toString()
                                    t1p1balls = child.child("players").child("0").child("batting").child("B").value!!.toString()
                                    t1p14s = child.child("players").child("0").child("batting").child("4s").value!!.toString()
                                    t1p16s = child.child("players").child("0").child("batting").child("6s").value!!.toString()
                                    t1b1M = child.child("players").child("0").child("bowling").child("M").value!!.toString()
                                    t1b1over = child.child("players").child("0").child("bowling").child("O").value!!.toString()
                                    t1b1run = child.child("players").child("0").child("bowling").child("R").value!!.toString()
                                    t1b1W = child.child("players").child("0").child("bowling").child("W").value!!.toString()

                                    t1p2name = child.child("players").child("1").child("name").value!!.toString()
                                    t1p2run = child.child("players").child("1").child("batting").child("R").value!!.toString()
                                    t1p2balls = child.child("players").child("1").child("batting").child("B").value!!.toString()
                                    t1p24s = child.child("players").child("1").child("batting").child("4s").value!!.toString()
                                    t1p26s = child.child("players").child("1").child("batting").child("6s").value!!.toString()
                                    t1b2M = child.child("players").child("1").child("bowling").child("M").value!!.toString()
                                    t1b2over = child.child("players").child("1").child("bowling").child("O").value!!.toString()
                                    t1b2run = child.child("players").child("1").child("bowling").child("R").value!!.toString()
                                    t1b2W = child.child("players").child("1").child("bowling").child("W").value!!.toString()

                                    t1p3name = child.child("players").child("2").child("name").value!!.toString()
                                    t1p3run = child.child("players").child("2").child("batting").child("R").value!!.toString()
                                    t1p3balls = child.child("players").child("2").child("batting").child("B").value!!.toString()
                                    t1p34s = child.child("players").child("2").child("batting").child("4s").value!!.toString()
                                    t1p36s = child.child("players").child("2").child("batting").child("6s").value!!.toString()
                                    t1b3M = child.child("players").child("2").child("bowling").child("M").value!!.toString()
                                    t1b3over = child.child("players").child("2").child("bowling").child("O").value!!.toString()
                                    t1b3run = child.child("players").child("2").child("bowling").child("R").value!!.toString()
                                    t1b3W = child.child("players").child("2").child("bowling").child("W").value!!.toString()

                                    t1p4name = child.child("players").child("3").child("name").value!!.toString()
                                    t1p4run = child.child("players").child("3").child("batting").child("R").value!!.toString()
                                    t1p4balls = child.child("players").child("3").child("batting").child("B").value!!.toString()
                                    t1p44s = child.child("players").child("3").child("batting").child("4s").value!!.toString()
                                    t1p46s = child.child("players").child("3").child("batting").child("6s").value!!.toString()
                                    t1b4M = child.child("players").child("3").child("bowling").child("M").value!!.toString()
                                    t1b4over = child.child("players").child("3").child("bowling").child("O").value!!.toString()
                                    t1b4run = child.child("players").child("3").child("bowling").child("R").value!!.toString()
                                    t1b4W = child.child("players").child("3").child("bowling").child("W").value!!.toString()

                                    t1p5name = child.child("players").child("4").child("name").value!!.toString()
                                    t1p5run = child.child("players").child("4").child("batting").child("R").value!!.toString()
                                    t1p5balls = child.child("players").child("4").child("batting").child("B").value!!.toString()
                                    t1p54s = child.child("players").child("4").child("batting").child("4s").value!!.toString()
                                    t1p56s = child.child("players").child("4").child("batting").child("6s").value!!.toString()
                                    t1b5M = child.child("players").child("4").child("bowling").child("M").value!!.toString()
                                    t1b5over = child.child("players").child("4").child("bowling").child("O").value!!.toString()
                                    t1b5run = child.child("players").child("4").child("bowling").child("R").value!!.toString()
                                    t1b5W = child.child("players").child("4").child("bowling").child("W").value!!.toString()

                                    t1p6name = child.child("players").child("5").child("name").value!!.toString()
                                    t1p6run = child.child("players").child("5").child("batting").child("R").value!!.toString()
                                    t1p6balls = child.child("players").child("5").child("batting").child("B").value!!.toString()
                                    t1p64s = child.child("players").child("5").child("batting").child("4s").value!!.toString()
                                    t1p66s = child.child("players").child("5").child("batting").child("6s").value!!.toString()
                                    t1b6M = child.child("players").child("5").child("bowling").child("M").value!!.toString()
                                    t1b6over = child.child("players").child("5").child("bowling").child("O").value!!.toString()
                                    t1b6run = child.child("players").child("5").child("bowling").child("R").value!!.toString()
                                    t1b6W = child.child("players").child("5").child("bowling").child("W").value!!.toString()

                                    t1p7name = child.child("players").child("6").child("name").value!!.toString()
                                    t1p7run = child.child("players").child("6").child("batting").child("R").value!!.toString()
                                    t1p7balls = child.child("players").child("6").child("batting").child("B").value!!.toString()
                                    t1p74s = child.child("players").child("6").child("batting").child("4s").value!!.toString()
                                    t1p76s = child.child("players").child("6").child("batting").child("6s").value!!.toString()
                                    t1b7M = child.child("players").child("6").child("bowling").child("M").value!!.toString()
                                    t1b7over = child.child("players").child("6").child("bowling").child("O").value!!.toString()
                                    t1b7run = child.child("players").child("6").child("bowling").child("R").value!!.toString()
                                    t1b7W = child.child("players").child("6").child("bowling").child("W").value!!.toString()

                                    t1p8name = child.child("players").child("7").child("name").value!!.toString()
                                    t1p8run = child.child("players").child("7").child("batting").child("R").value!!.toString()
                                    t1p8balls = child.child("players").child("7").child("batting").child("B").value!!.toString()
                                    t1p84s = child.child("players").child("7").child("batting").child("4s").value!!.toString()
                                    t1p86s = child.child("players").child("7").child("batting").child("6s").value!!.toString()
                                    t1b8M = child.child("players").child("7").child("bowling").child("M").value!!.toString()
                                    t1b8over = child.child("players").child("7").child("bowling").child("O").value!!.toString()
                                    t1b8run = child.child("players").child("7").child("bowling").child("R").value!!.toString()
                                    t1b8W = child.child("players").child("7").child("bowling").child("W").value!!.toString()

                                    t1p9name = child.child("players").child("8").child("name").value!!.toString()
                                    t1p9run = child.child("players").child("8").child("batting").child("R").value!!.toString()
                                    t1p9balls = child.child("players").child("8").child("batting").child("B").value!!.toString()
                                    t1p94s = child.child("players").child("8").child("batting").child("4s").value!!.toString()
                                    t1p96s = child.child("players").child("8").child("batting").child("6s").value!!.toString()
                                    t1b9M = child.child("players").child("8").child("bowling").child("M").value!!.toString()
                                    t1b9over = child.child("players").child("8").child("bowling").child("O").value!!.toString()
                                    t1b9run = child.child("players").child("8").child("bowling").child("R").value!!.toString()
                                    t1b9W = child.child("players").child("8").child("bowling").child("W").value!!.toString()

                                    t1p10name = child.child("players").child("9").child("name").value!!.toString()
                                    t1p10run = child.child("players").child("9").child("batting").child("R").value!!.toString()
                                    t1p10balls = child.child("players").child("9").child("batting").child("B").value!!.toString()
                                    t1p104s = child.child("players").child("9").child("batting").child("4s").value!!.toString()
                                    t1p106s = child.child("players").child("9").child("batting").child("6s").value!!.toString()
                                    t1b10M = child.child("players").child("9").child("bowling").child("M").value!!.toString()
                                    t1b10over = child.child("players").child("9").child("bowling").child("O").value!!.toString()
                                    t1b10run = child.child("players").child("9").child("bowling").child("R").value!!.toString()
                                    t1b10W = child.child("players").child("9").child("bowling").child("W").value!!.toString()

                                    t1p11name = child.child("players").child("10").child("name").value!!.toString()
                                    t1p11run = child.child("players").child("10").child("batting").child("R").value!!.toString()
                                    t1p11balls = child.child("players").child("10").child("batting").child("B").value!!.toString()
                                    t1p114s = child.child("players").child("10").child("batting").child("4s").value!!.toString()
                                    t1p116s = child.child("players").child("10").child("batting").child("6s").value!!.toString()
                                    t1b11M = child.child("players").child("10").child("bowling").child("M").value!!.toString()
                                    t1b11over = child.child("players").child("10").child("bowling").child("O").value!!.toString()
                                    t1b11run = child.child("players").child("10").child("bowling").child("R").value!!.toString()
                                    t1b11W = child.child("players").child("10").child("bowling").child("W").value!!.toString()

                                    t1p12name = child.child("players").child("11").child("name").value!!.toString()
                                    t1p12run = child.child("players").child("11").child("batting").child("R").value!!.toString()
                                    t1p12balls = child.child("players").child("11").child("batting").child("B").value!!.toString()
                                    t1p124s = child.child("players").child("11").child("batting").child("4s").value!!.toString()
                                    t1p126s = child.child("players").child("11").child("batting").child("6s").value!!.toString()
                                    t1b12M = child.child("players").child("11").child("bowling").child("M").value!!.toString()
                                    t1b12over = child.child("players").child("11").child("bowling").child("O").value!!.toString()
                                    t1b12run = child.child("players").child("11").child("bowling").child("R").value!!.toString()
                                    t1b12W = child.child("players").child("11").child("bowling").child("W").value!!.toString()








                                Log.d("bharti", "Child t1 Value is: $t1over $t1name $t1rate1 $t1rate2 $t1run $t1viket")
                                tosswinteam.text=twinteam




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



                                    t2p1name = child.child("players").child("0").child("name").value!!.toString()
                                    t2p1run = child.child("players").child("0").child("batting").child("R").value!!.toString()
                                    t2p1balls = child.child("players").child("0").child("batting").child("B").value!!.toString()
                                    t2p14s = child.child("players").child("0").child("batting").child("4s").value!!.toString()
                                    t2p16s = child.child("players").child("0").child("batting").child("6s").value!!.toString()
                                    t2b1M = child.child("players").child("0").child("bowling").child("M").value!!.toString()
                                    t2b1over = child.child("players").child("0").child("bowling").child("O").value!!.toString()
                                    t2b1run = child.child("players").child("0").child("bowling").child("R").value!!.toString()
                                    t2b1W = child.child("players").child("0").child("bowling").child("W").value!!.toString()

                                    t2p2name = child.child("players").child("1").child("name").value!!.toString()
                                    t2p2run = child.child("players").child("1").child("batting").child("R").value!!.toString()
                                    t2p2balls = child.child("players").child("1").child("batting").child("B").value!!.toString()
                                    t2p24s = child.child("players").child("1").child("batting").child("4s").value!!.toString()
                                    t2p26s = child.child("players").child("1").child("batting").child("6s").value!!.toString()
                                    t2b2M = child.child("players").child("1").child("bowling").child("M").value!!.toString()
                                    t2b2over = child.child("players").child("1").child("bowling").child("O").value!!.toString()
                                    t2b2run = child.child("players").child("1").child("bowling").child("R").value!!.toString()
                                    t2b2W = child.child("players").child("1").child("bowling").child("W").value!!.toString()

                                    t2p3name = child.child("players").child("2").child("name").value!!.toString()
                                    t2p3run = child.child("players").child("2").child("batting").child("R").value!!.toString()
                                    t2p3balls = child.child("players").child("2").child("batting").child("B").value!!.toString()
                                    t2p34s = child.child("players").child("2").child("batting").child("4s").value!!.toString()
                                    t2p36s = child.child("players").child("2").child("batting").child("6s").value!!.toString()
                                    t2b3M = child.child("players").child("2").child("bowling").child("M").value!!.toString()
                                    t2b3over = child.child("players").child("2").child("bowling").child("O").value!!.toString()
                                    t2b3run = child.child("players").child("2").child("bowling").child("R").value!!.toString()
                                    t2b3W = child.child("players").child("2").child("bowling").child("W").value!!.toString()

                                    t2p4name = child.child("players").child("3").child("name").value!!.toString()
                                    t2p4run = child.child("players").child("3").child("batting").child("R").value!!.toString()
                                    t2p4balls = child.child("players").child("3").child("batting").child("B").value!!.toString()
                                    t2p44s = child.child("players").child("3").child("batting").child("4s").value!!.toString()
                                    t2p46s = child.child("players").child("3").child("batting").child("6s").value!!.toString()
                                    t2b4M = child.child("players").child("3").child("bowling").child("M").value!!.toString()
                                    t2b4over = child.child("players").child("3").child("bowling").child("O").value!!.toString()
                                    t2b4run = child.child("players").child("3").child("bowling").child("R").value!!.toString()
                                    t2b4W = child.child("players").child("3").child("bowling").child("W").value!!.toString()

                                    t2p5name = child.child("players").child("4").child("name").value!!.toString()
                                    t2p5run = child.child("players").child("4").child("batting").child("R").value!!.toString()
                                    t2p5balls = child.child("players").child("4").child("batting").child("B").value!!.toString()
                                    t2p54s = child.child("players").child("4").child("batting").child("4s").value!!.toString()
                                    t2p56s = child.child("players").child("4").child("batting").child("6s").value!!.toString()
                                    t2b5M = child.child("players").child("4").child("bowling").child("M").value!!.toString()
                                    t2b5over = child.child("players").child("4").child("bowling").child("O").value!!.toString()
                                    t2b5run = child.child("players").child("4").child("bowling").child("R").value!!.toString()
                                    t2b5W = child.child("players").child("4").child("bowling").child("W").value!!.toString()

                                    t2p6name = child.child("players").child("5").child("name").value!!.toString()
                                    t2p6run = child.child("players").child("5").child("batting").child("R").value!!.toString()
                                    t2p6balls = child.child("players").child("5").child("batting").child("B").value!!.toString()
                                    t2p64s = child.child("players").child("5").child("batting").child("4s").value!!.toString()
                                    t2p66s = child.child("players").child("5").child("batting").child("6s").value!!.toString()
                                    t2b6M = child.child("players").child("5").child("bowling").child("M").value!!.toString()
                                    t2b6over = child.child("players").child("5").child("bowling").child("O").value!!.toString()
                                    t2b6run = child.child("players").child("5").child("bowling").child("R").value!!.toString()
                                    t2b6W = child.child("players").child("5").child("bowling").child("W").value!!.toString()

                                    t2p7name = child.child("players").child("6").child("name").value!!.toString()
                                    t2p7run = child.child("players").child("6").child("batting").child("R").value!!.toString()
                                    t2p7balls = child.child("players").child("6").child("batting").child("B").value!!.toString()
                                    t2p74s = child.child("players").child("6").child("batting").child("4s").value!!.toString()
                                    t2p76s = child.child("players").child("6").child("batting").child("6s").value!!.toString()
                                    t2b7M = child.child("players").child("6").child("bowling").child("M").value!!.toString()
                                    t2b7over = child.child("players").child("6").child("bowling").child("O").value!!.toString()
                                    t2b7run = child.child("players").child("6").child("bowling").child("R").value!!.toString()
                                    t2b7W = child.child("players").child("6").child("bowling").child("W").value!!.toString()

                                    t2p8name = child.child("players").child("7").child("name").value!!.toString()
                                    t2p8run = child.child("players").child("7").child("batting").child("R").value!!.toString()
                                    t2p8balls = child.child("players").child("7").child("batting").child("B").value!!.toString()
                                    t2p84s = child.child("players").child("7").child("batting").child("4s").value!!.toString()
                                    t2p86s = child.child("players").child("7").child("batting").child("6s").value!!.toString()
                                    t2b8M = child.child("players").child("7").child("bowling").child("M").value!!.toString()
                                    t2b8over = child.child("players").child("7").child("bowling").child("O").value!!.toString()
                                    t2b8run = child.child("players").child("7").child("bowling").child("R").value!!.toString()
                                    t2b8W = child.child("players").child("7").child("bowling").child("W").value!!.toString()

                                    t2p9name = child.child("players").child("8").child("name").value!!.toString()
                                    t2p9run = child.child("players").child("8").child("batting").child("R").value!!.toString()
                                    t2p9balls = child.child("players").child("8").child("batting").child("B").value!!.toString()
                                    t2p94s = child.child("players").child("8").child("batting").child("4s").value!!.toString()
                                    t2p96s = child.child("players").child("8").child("batting").child("6s").value!!.toString()
                                    t2b9M = child.child("players").child("8").child("bowling").child("M").value!!.toString()
                                    t2b9over = child.child("players").child("8").child("bowling").child("O").value!!.toString()
                                    t2b9run = child.child("players").child("8").child("bowling").child("R").value!!.toString()
                                    t2b9W = child.child("players").child("8").child("bowling").child("W").value!!.toString()

                                    t2p10name = child.child("players").child("9").child("name").value!!.toString()
                                    t2p10run = child.child("players").child("9").child("batting").child("R").value!!.toString()
                                    t2p10balls = child.child("players").child("9").child("batting").child("B").value!!.toString()
                                    t2p104s = child.child("players").child("9").child("batting").child("4s").value!!.toString()
                                    t2p106s = child.child("players").child("9").child("batting").child("6s").value!!.toString()
                                    t2b10M = child.child("players").child("9").child("bowling").child("M").value!!.toString()
                                    t2b10over = child.child("players").child("9").child("bowling").child("O").value!!.toString()
                                    t2b10run = child.child("players").child("9").child("bowling").child("R").value!!.toString()
                                    t2b10W = child.child("players").child("9").child("bowling").child("W").value!!.toString()

                                    t2p11name = child.child("players").child("10").child("name").value!!.toString()
                                    t2p11run = child.child("players").child("10").child("batting").child("R").value!!.toString()
                                    t2p11balls = child.child("players").child("10").child("batting").child("B").value!!.toString()
                                    t2p114s = child.child("players").child("10").child("batting").child("4s").value!!.toString()
                                    t2p116s = child.child("players").child("10").child("batting").child("6s").value!!.toString()
                                    t2b11M = child.child("players").child("10").child("bowling").child("M").value!!.toString()
                                    t2b11over = child.child("players").child("10").child("bowling").child("O").value!!.toString()
                                    t2b11run = child.child("players").child("10").child("bowling").child("R").value!!.toString()
                                    t2b11W = child.child("players").child("10").child("bowling").child("W").value!!.toString()

                                    t2p12name = child.child("players").child("11").child("name").value!!.toString()
                                    t2p12run = child.child("players").child("11").child("batting").child("R").value!!.toString()
                                    t2p12balls = child.child("players").child("11").child("batting").child("B").value!!.toString()
                                    t2p124s = child.child("players").child("11").child("batting").child("4s").value!!.toString()
                                    t2p126s = child.child("players").child("11").child("batting").child("6s").value!!.toString()
                                    t2b12M = child.child("players").child("11").child("bowling").child("M").value!!.toString()
                                    t2b12over = child.child("players").child("11").child("bowling").child("O").value!!.toString()
                                    t2b12run = child.child("players").child("11").child("bowling").child("R").value!!.toString()
                                    t2b12W = child.child("players").child("11").child("bowling").child("W").value!!.toString()









                              //  balls = balls(overt2value)
                                   //Log.d("bharti", "Child t2 Value is: $t2over $t2name $t2rate1 $t2rate2 $t2run $t2viket")

                            } /*else if (child.key == "Batsman") {
                                 b1name = child.child("b1").child("name").value!!.toString()
                                 b1run = child.child("b1").child("R").value!!.toString()
                                 b1ball = child.child("b1").child("B").value!!.toString()
                                 b14s = child.child("b1").child("4s").value!!.toString()
                                 b16s = child.child("b1").child("6s").value!!.toString()
                                 b1sr = child.child("b1").child("SR").value!!.toString()


                                Log.d("bharti", "subChild b1 Value is: $b1name $b1run $b1ball $b14s $b16s $b1sr")

                                 b2name = child.child("b2").child("name").value!!.toString()
                                 b2run = child.child("b2").child("R").value!!.toString()
                                 b2ball = child.child("b2").child("B").value!!.toString()
                                 b24s = child.child("b2").child("4s").value!!.toString()
                                 b26s = child.child("b2").child("6s").value!!.toString()
                                 b2sr = child.child("b2").child("SR").value!!.toString()

                                Log.d("bharti", "subChild b2 Value is: $b2name $b2run $b2ball $b24s $b26s $b2sr")

                            } else if (child.key == "Bowling") {
                                 bowler1name = child.child("bowler1").child("name").value!!.toString()
                                 bowler1o = child.child("bowler1").child("O").value!!.toString()
                                 bowler1m = child.child("bowler1").child("M").value!!.toString()
                                 bowler1r = child.child("bowler1").child("R").value!!.toString()
                                 bowler1w = child.child("bowler1").child("W").value!!.toString()
                                 bowler1er = child.child("bowler1").child("ER").value!!.toString()

                                Log.d("bharti", "subChild bowler1 Value is: $bowler1name $bowler1o $bowler1m $bowler1r $bowler1w $bowler1er")

                                 bowler2name = child.child("bowler2").child("name").value!!.toString()
                                 bowler2o = child.child("bowler2").child("O").value!!.toString()
                                 bowler2m = child.child("bowler2").child("M").value!!.toString()
                                 bowler2r = child.child("bowler2").child("R").value!!.toString()
                                 bowler2w = child.child("bowler2").child("W").value!!.toString()
                                 bowler2er = child.child("bowler2").child("ER").value!!.toString()

                                Log.d("bharti", "subChild bowler2 Value is: $bowler2name $bowler2o $bowler2m $bowler2r $bowler2w $bowler2er")

                            }*/


                        }

                    }

                }
              /*  if(t1run.toIntOrNull()!=null &&t1over.toIntOrNull()!=null&&
                        t1viket.toIntOrNull()!=null&&t2run.toIntOrNull()!=null &&
                        t2over.toIntOrNull()!=null&&t2viket.toIntOrNull()!=null) {
                    runt1value = t1run.toIntOrNull()!!
                    overt1value = t1over.toIntOrNull()!!
                    wickett1value = t1viket.toIntOrNull()!!
                    runt2value = t2run.toIntOrNull()!!
                    overt2value = t2over.toIntOrNull()!!
                    wickett2value = t2viket.toIntOrNull()!!
                    Log.d("bharti","values"+runt1value+runt2value+wickett1value+wickett2value+overt1value+overt2value)


                }*/
                if(inning.equals("2")) {
                    if (choosebattingTeam.equals(t2name)) {
                        run = t1run.toInt() - t2run.toInt()

                        Log.d("bharti","value t1Run"+run)
                    } else if(choosebattingTeam.equals(t1name)){
                        run = t2run.toInt()-t1run.toInt()
                        Log.d("bharti","value t2Run"+run)
                    }
                }

                if(pstrike.equals("Player1")){
                    batsman1strike_tv.setVisibility(View.VISIBLE)
                    batsman2strike_tv.setVisibility(View.INVISIBLE)

                }else if(pstrike.equals("Player2")){
                    batsman1strike_tv.setVisibility(View.INVISIBLE)
                    batsman2strike_tv.setVisibility(View.VISIBLE)

                }
                else if(pstrike.equals("")){
                    batsman1strike_tv.setVisibility(View.INVISIBLE)
                    batsman2strike_tv.setVisibility(View.INVISIBLE)

                }
                if(bstrike.equals("Bowler1")){
                    bowler1strike_tv.setVisibility(View.VISIBLE)
                    bowler2strike_tv.setVisibility(View.INVISIBLE)

                }else if(bstrike.equals("Bowler2")){
                    bowler2strike_tv.setVisibility(View.VISIBLE)
                    bowler1strike_tv.setVisibility(View.INVISIBLE)

                }else if(bstrike.equals("")){
                    bowler2strike_tv.setVisibility(View.INVISIBLE)
                    bowler1strike_tv.setVisibility(View.INVISIBLE)

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
                                }*/
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


               /* if (wickett1value.equals(10) && matchType.equals("Test") && inning.equals("1") || overt1value.equals(90) && matchType.equals("Test") && inning.equals("1")) {
                    needrun = "Need" + " " + needRun(runt1value).toString() + " " + "runs on 540 balls."
                }
*/
                if(inning.equals("2")){
                    if(choosebattingTeam.equals(t1name)){
                        if (t1viket.toInt().equals(10) && matchType.equals("T20") && status.equals("Finished") || t1over.toFloat().equals(20) && matchType.equals("T20") && status.equals("Finished")) {
                            if (t1run.toInt() > t2run.toInt()) {

                                needrun = t1name + " " + "won by" + " " + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            } else {
                                needrun = t2name + " " + "won by" + " " + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            }
                        }
                     else if (t1viket.toInt().equals(10) && matchType.equals("ODI") && status.equals("Finished") || t1over.toFloat().equals(50) && matchType.equals("ODI") && status.equals("Finished")) {
                            if (t1run.toInt() > t2run.toInt()) {

                                needrun = t1name + " " + "won by" + " " + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            } else {
                                needrun = t2name + " " + "won by" +  " " +wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            }
                        }
                    }else{
                        if (t2viket.toInt().equals(10) && matchType.equals("T20") && status.equals("Finished") || t2over.toFloat().equals(20) && matchType.equals("T20") && status.equals("Finished")) {
                            if (t1run.toInt() > t2run.toInt()) {

                                needrun = t1name + " " + "won by" +  " " +wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            } else {
                                needrun = t2name + " " + "won by" + " " + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            }
                        }
                       else if (t2viket.toInt().equals(10) && matchType.equals("ODI") && status.equals("Finished") || t2over.toFloat().equals(50) && matchType.equals("ODI") && status.equals("Finished")) {
                            if (t1run.toInt() > t2run.toInt()) {

                                needrun = t1name + " " + "won by" + " " + wont1Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            } else {
                                needrun = t2name + " " + "won by" + " " + wont2Run(t1run.toInt(), t2run.toInt()).toString() + " " + "runs"
                                Log.d("bharti","value t1name if"+needrun)

                            }
                        }
                    }

                }






               /* if (wickett2value.equals(10) && matchType.equals("Test") && status.equals("Finished") || overt2value.equals(90) && matchType.equals("Test") && status.equals("Finished")) {
                    if (runt1value > runt2value) {
                        needrun = t1name + " " + "won by" + wont1Run(runt1value, runt2value).toString() + " " + "runs"
                    } else {
                        needrun = t2name + " " + "won by" + wont2Run(runt1value, runt2value).toString() + " " + "runs"

                    }
                }*/

                /*if(t2viket.toInt().equals(10)||t2over.toInt().equals(20)){
                    needrun="Need"+" "+needRun(t2run).toString()+" "+"runs on 120 balls."
                }*/

                /*if(b1run.toFloatOrNull()!=null &&b2run.toFloatOrNull()!=null&&
                        b1ball.toFloatOrNull()!=null&&b2ball.toFloatOrNull()!=null &&
                        bowler1r.toFloatOrNull()!=null&&bowler2r.toFloatOrNull()!=null
                && bowler1o.toFloatOrNull()!=null&&bowler2o.toFloatOrNull()!=null) {
                    batsman1run = b1run.toFloatOrNull()!!
                    batsman2run = b2run.toFloatOrNull()!!
                    batsman1ball = b1ball.toFloatOrNull()!!
                    batsman2ball = b2ball.toFloatOrNull()!!
                    bowler1run = bowler1r.toFloatOrNull()!!
                    bowler2run = bowler2r.toFloatOrNull()!!
                    bowler1over = bowler1o.toFloatOrNull()!!
                    bowler2over = bowler2o.toFloatOrNull()!!
                }*/

                if(choosebattingTeam.equals(t1name)){
                    when {
                        batsman1.equals(t1p1name) -> getBatsmanFirst(t1p1name,t1p1run,t1p1balls,t1p14s,t1p16s)
                        batsman1.equals(t1p2name) -> getBatsmanFirst(t1p2name,t1p2run,t1p2balls,t1p24s,t1p26s)
                        batsman1.equals(t1p3name) -> getBatsmanFirst(t1p3name,t1p3run,t1p3balls,t1p34s,t1p36s)
                        batsman1.equals(t1p4name) -> getBatsmanFirst(t1p4name,t1p4run,t1p4balls,t1p44s,t1p46s)
                        batsman1.equals(t1p5name) -> getBatsmanFirst(t1p5name,t1p5run,t1p5balls,t1p54s,t1p56s)
                        batsman1.equals(t1p6name) -> getBatsmanFirst(t1p6name,t1p6run,t1p6balls,t1p64s,t1p66s)
                        batsman1.equals(t1p7name) -> getBatsmanFirst(t1p7name,t1p7run,t1p7balls,t1p74s,t1p76s)
                        batsman1.equals(t1p8name) -> getBatsmanFirst(t1p8name,t1p8run,t1p8balls,t1p84s,t1p86s)
                        batsman1.equals(t1p9name) -> getBatsmanFirst(t1p9name,t1p9run,t1p9balls,t1p94s,t1p96s)
                        batsman1.equals(t1p10name) -> getBatsmanFirst(t1p10name,t1p10run,t1p10balls,t1p104s,t1p106s)
                        batsman1.equals(t1p11name) -> getBatsmanFirst(t1p11name,t1p11run,t1p11balls,t1p114s,t1p116s)
                        batsman1.equals(t1p12name) -> getBatsmanFirst(t1p12name,t1p12run,t1p12balls,t1p124s,t1p126s)
                    }

                    when {
                        batsman2.equals(t1p1name) -> getBatsmanSecond(t1p1name,t1p1run,t1p1balls,t1p14s,t1p16s)
                        batsman2.equals(t1p2name) -> getBatsmanSecond(t1p2name,t1p2run,t1p2balls,t1p24s,t1p26s)
                        batsman2.equals(t1p3name) -> getBatsmanSecond(t1p3name,t1p3run,t1p3balls,t1p34s,t1p36s)
                        batsman2.equals(t1p4name) -> getBatsmanSecond(t1p4name,t1p4run,t1p4balls,t1p44s,t1p46s)
                        batsman2.equals(t1p5name) -> getBatsmanSecond(t1p5name,t1p5run,t1p5balls,t1p54s,t1p56s)
                        batsman2.equals(t1p6name) -> getBatsmanSecond(t1p6name,t1p6run,t1p6balls,t1p64s,t1p66s)
                        batsman2.equals(t1p7name) -> getBatsmanSecond(t1p7name,t1p7run,t1p7balls,t1p74s,t1p76s)
                        batsman2.equals(t1p8name) -> getBatsmanSecond(t1p8name,t1p8run,t1p8balls,t1p84s,t1p86s)
                        batsman2.equals(t1p9name) -> getBatsmanSecond(t1p9name,t1p9run,t1p9balls,t1p94s,t1p96s)
                        batsman2.equals(t1p10name) -> getBatsmanSecond(t1p10name,t1p10run,t1p10balls,t1p104s,t1p106s)
                        batsman2.equals(t1p11name) -> getBatsmanSecond(t1p11name,t1p11run,t1p11balls,t1p114s,t1p116s)
                        batsman2.equals(t1p12name) -> getBatsmanSecond(t1p12name,t1p12run,t1p12balls,t1p124s,t1p126s)
                    }

                }else{
                    when {
                        bowler1.equals(t1p1name) -> getBowlerFirst(t1p1name,t1b1over,t1b1M,t1b1run,t1b1W)
                        bowler1.equals(t1p2name) -> getBowlerFirst(t1p2name,t1b2over,t1b2M,t1b2run,t1b2W)
                        bowler1.equals(t1p3name) -> getBowlerFirst(t1p3name,t1b3over,t1b3M,t1b3run,t1b3W)
                        bowler1.equals(t1p4name) -> getBowlerFirst(t1p4name,t1b4over,t1b4M,t1b4run,t1b4W)
                        bowler1.equals(t1p5name) -> getBowlerFirst(t1p5name,t1b5over,t1b5M,t1b5run,t1b5W)
                        bowler1.equals(t1p6name) -> getBowlerFirst(t1p6name,t1b6over,t1b6M,t1b6run,t1b6W)
                        bowler1.equals(t1p7name) -> getBowlerFirst(t1p7name,t1b7over,t1b7M,t1b7run,t1b7W)
                        bowler1.equals(t1p8name) -> getBowlerFirst(t1p8name,t1b8over,t1b8M,t1b8run,t1b8W)
                        bowler1.equals(t1p9name) -> getBowlerFirst(t1p9name,t1b9over,t1b9M,t1b9run,t1b9W)
                        bowler1.equals(t1p10name) -> getBowlerFirst(t1p10name,t1b10over,t1b10M,t1b10run,t1b10W)
                        bowler1.equals(t1p11name) ->getBowlerFirst(t1p11name,t1b11over,t1b11M,t1b11run,t1b11W)
                        bowler1.equals(t1p12name) -> getBowlerFirst(t1p12name,t1b12over,t1b12M,t1b12run,t1b12W)
                    }

                    when {
                        bowler2.equals(t1p1name) -> getBowlerSecond(t1p1name,t1b1over,t1b1M,t1b1run,t1b1W)
                        bowler2.equals(t1p2name) -> getBowlerSecond(t1p2name,t1b2over,t1b2M,t1b2run,t1b2W)
                        bowler2.equals(t1p3name) -> getBowlerSecond(t1p3name,t1b3over,t1b3M,t1b3run,t1b3W)
                        bowler2.equals(t1p4name) -> getBowlerSecond(t1p4name,t1b4over,t1b4M,t1b4run,t1b4W)
                        bowler2.equals(t1p5name) -> getBowlerSecond(t1p5name,t1b5over,t1b5M,t1b5run,t1b5W)
                        bowler2.equals(t1p6name) -> getBowlerSecond(t1p6name,t1b6over,t1b6M,t1b6run,t1b6W)
                        bowler2.equals(t1p7name) -> getBowlerSecond(t1p7name,t1b7over,t1b7M,t1b7run,t1b7W)
                        bowler2.equals(t1p8name) ->getBowlerSecond(t1p8name,t1b8over,t1b8M,t1b8run,t1b8W)
                        bowler2.equals(t1p9name) -> getBowlerSecond(t1p9name,t1b9over,t1b9M,t1b9run,t1b9W)
                        bowler2.equals(t1p10name) -> getBowlerSecond(t1p10name,t1b10over,t1b10M,t1b10run,t1b10W)
                        bowler2.equals(t1p11name) -> getBowlerSecond(t1p11name,t1b11over,t1b11M,t1b11run,t1b11W)
                        bowler2.equals(t1p12name) -> getBowlerSecond(t1p12name,t1b12over,t1b12M,t1b12run,t1b12W)
                    }
                }

                if(choosebattingTeam.equals(t2name)){
                    when {
                        batsman1.equals(t2p1name) -> getBatsmanFirst(t2p1name,t2p1run,t2p1balls,t2p14s,t2p16s)
                        batsman1.equals(t2p2name) -> getBatsmanFirst(t2p2name,t2p2run,t2p2balls,t2p24s,t2p26s)
                        batsman1.equals(t2p3name) -> getBatsmanFirst(t2p3name,t2p3run,t2p3balls,t2p34s,t2p36s)
                        batsman1.equals(t2p4name) -> getBatsmanFirst(t2p4name,t2p4run,t2p4balls,t2p44s,t2p46s)
                        batsman1.equals(t2p5name) -> getBatsmanFirst(t2p5name,t2p5run,t2p5balls,t2p54s,t2p56s)
                        batsman1.equals(t2p6name) -> getBatsmanFirst(t2p6name,t2p6run,t2p6balls,t2p64s,t2p66s)
                        batsman1.equals(t2p7name) -> getBatsmanFirst(t2p7name,t2p7run,t2p7balls,t2p74s,t2p76s)
                        batsman1.equals(t2p8name) -> getBatsmanFirst(t2p8name,t2p8run,t2p8balls,t2p84s,t2p86s)
                        batsman1.equals(t2p9name) -> getBatsmanFirst(t2p9name,t2p9run,t2p9balls,t2p94s,t2p96s)
                        batsman1.equals(t2p10name) -> getBatsmanFirst(t2p10name,t2p10run,t2p10balls,t2p104s,t2p106s)
                        batsman1.equals(t2p11name) -> getBatsmanFirst(t2p11name,t2p11run,t2p11balls,t2p114s,t2p116s)
                        batsman1.equals(t2p12name) -> getBatsmanFirst(t2p12name,t2p12run,t2p12balls,t2p124s,t2p126s)
                    }

                    when {
                        batsman2.equals(t2p1name) -> getBatsmanSecond(t2p1name,t2p1run,t2p1balls,t2p14s,t2p16s)
                        batsman2.equals(t2p2name) -> getBatsmanSecond(t2p2name,t2p2run,t2p2balls,t2p24s,t2p26s)
                        batsman2.equals(t2p3name) -> getBatsmanSecond(t2p3name,t2p3run,t2p3balls,t2p34s,t2p36s)
                        batsman2.equals(t2p4name) -> getBatsmanSecond(t2p4name,t2p4run,t2p4balls,t2p44s,t2p46s)
                        batsman2.equals(t2p5name) -> getBatsmanSecond(t2p5name,t2p5run,t2p5balls,t2p54s,t2p56s)
                        batsman2.equals(t2p6name) -> getBatsmanSecond(t2p6name,t2p6run,t2p6balls,t2p64s,t2p66s)
                        batsman2.equals(t2p7name) -> getBatsmanSecond(t2p7name,t2p7run,t2p7balls,t2p74s,t2p76s)
                        batsman2.equals(t2p8name) -> getBatsmanSecond(t2p8name,t2p8run,t2p8balls,t2p84s,t2p86s)
                        batsman2.equals(t2p9name) -> getBatsmanSecond(t2p9name,t2p9run,t2p9balls,t2p94s,t2p96s)
                        batsman2.equals(t2p10name) -> getBatsmanSecond(t2p10name,t2p10run,t2p10balls,t2p104s,t2p106s)
                        batsman2.equals(t2p11name) -> getBatsmanSecond(t2p11name,t2p11run,t2p11balls,t2p114s,t2p116s)
                        batsman2.equals(t2p12name) -> getBatsmanSecond(t2p12name,t2p12run,t2p12balls,t2p124s,t2p126s)
                    }

                }else{
                    when {
                        bowler1.equals(t2p1name) -> getBowlerFirst(t2p1name,t2b1over,t2b1M,t2b1run,t2b1W)
                        bowler1.equals(t2p2name) -> getBowlerFirst(t2p2name,t2b2over,t2b2M,t2b2run,t2b2W)
                        bowler1.equals(t2p3name) -> getBowlerFirst(t2p3name,t2b3over,t2b3M,t2b3run,t2b3W)
                        bowler1.equals(t2p4name) -> getBowlerFirst(t2p4name,t2b4over,t2b4M,t2b4run,t2b4W)
                        bowler1.equals(t2p5name) -> getBowlerFirst(t2p5name,t2b5over,t2b5M,t2b5run,t2b5W)
                        bowler1.equals(t2p6name) -> getBowlerFirst(t2p6name,t2b6over,t2b6M,t2b6run,t2b6W)
                        bowler1.equals(t2p7name) -> getBowlerFirst(t2p7name,t2b7over,t2b7M,t2b7run,t2b7W)
                        bowler1.equals(t2p8name) -> getBowlerFirst(t2p8name,t2b8over,t2b8M,t2b8run,t2b8W)
                        bowler1.equals(t2p9name) -> getBowlerFirst(t2p9name,t2b9over,t2b9M,t2b9run,t2b9W)
                        bowler1.equals(t2p10name) -> getBowlerFirst(t2p10name,t2b10over,t2b10M,t2b10run,t2b10W)
                        bowler1.equals(t2p11name) ->getBowlerFirst(t2p11name,t2b11over,t2b11M,t2b11run,t2b11W)
                        bowler1.equals(t2p12name) -> getBowlerFirst(t2p12name,t2b12over,t2b12M,t2b12run,t2b12W)
                    }

                    when {
                        bowler2.equals(t2p1name) -> getBowlerSecond(t2p1name,t2b1over,t2b1M,t2b1run,t2b1W)
                        bowler2.equals(t2p2name) -> getBowlerSecond(t2p2name,t2b2over,t2b2M,t2b2run,t2b2W)
                        bowler2.equals(t2p3name) -> getBowlerSecond(t2p3name,t2b3over,t2b3M,t2b3run,t2b3W)
                        bowler2.equals(t2p4name) -> getBowlerSecond(t2p4name,t2b4over,t2b4M,t2b4run,t2b4W)
                        bowler2.equals(t2p5name) -> getBowlerSecond(t2p5name,t2b5over,t2b5M,t2b5run,t2b5W)
                        bowler2.equals(t2p6name) -> getBowlerSecond(t2p6name,t2b6over,t2b6M,t2b6run,t2b6W)
                        bowler2.equals(t2p7name) -> getBowlerSecond(t2p7name,t2b7over,t2b7M,t2b7run,t2b7W)
                        bowler2.equals(t2p8name) ->getBowlerSecond(t2p8name,t2b8over,t2b8M,t2b8run,t2b8W)
                        bowler2.equals(t2p9name) -> getBowlerSecond(t2p9name,t2b9over,t2b9M,t2b9run,t2b9W)
                        bowler2.equals(t2p10name) -> getBowlerSecond(t2p10name,t2b10over,t2b10M,t2b10run,t2b10W)
                        bowler2.equals(t2p11name) -> getBowlerSecond(t2p11name,t2b11over,t2b11M,t2b11run,t2b11W)
                        bowler2.equals(t2p12name) -> getBowlerSecond(t2p12name,t2b12over,t2b12M,t2b12run,t2b12W)
                    }
                }

              /*  var baller1strikerate=strikeRate(batsman1run,batsman1ball)
                var baller2strikerate=strikeRate(batsman2run,batsman2ball)
                var bowller1economicrate=economicRate(bowler1over,bowler1run)
                var bowller2economicrate=economicRate(bowler2over,bowler2run)
*/
                t1name_TV.text=t1name
                t1name_tv.text=t1name
                t1run_TV.text=t1run+"/"+t1viket+"("+t1over+")"
                t1run_tv.text=t1run+"/"+t1viket+"("+t1over+")"


                t2name_TV.text=t2name
                t2name_tv.text=t2name
                t2run_TV.text=t2run+"/"+t2viket+"("+t2over+")"
                t2run_tv.text=t2run+"/"+t2viket+"("+t2over+")"


                /*batsman1_tv.text=b1name
                b1run_tv.text=b1run
                b1ball_tv.text=b1ball
                b1four_tv.text=b14s
                b1six_tv.text=b16s
                b1sr_tv.text= DecimalFormat("##.##").format(baller1strikerate)

                batsman2_tv.text=b2name
                b2run_tv.text=b2run
                b2ball_tv.text=b2ball
                b2four_tv.text=b24s
                b2six_tv.text=b26s
                b2sr_tv.text=DecimalFormat("##.##").format(baller2strikerate)

                bowler1_tv.text=bowler1name
                bowler1o_tv.text=bowler1o
                bowler1m_tv.text=bowler1m
                bowler1r_tv.text=bowler1r
                bowler1w_tv.text=bowler1w
                bowler1er_tv.text=DecimalFormat("##.##").format(bowller1economicrate)

                bowler2_tv.text=bowler2name
                bowler2o_tv.text=bowler2o
                bowler2m_tv.text=bowler2m
                bowler2r_tv.text=bowler2r
                bowler2w_tv.text=bowler2w
                bowler2er_tv.text=DecimalFormat("##.##").format(bowller2economicrate)
               */
               /* if(inning.equals("2")) {
                    if (choosebattingTeam.equals(t2name)) {

                            run = t1run.toInt() - t2run.toInt()
                            r=run+1
                            needrun = "Need" + " " + r.toString() + " " + "runs on" + " " + needruntowin + " " + "balls."
                        if(r>t1run.toInt()) {
                            needrun = t2name + " " + "won by" + wont2Run(t1run.toInt(), r).toString() + " " + "runs"

                        }
                        Log.d("bharti","value t1Run"+run)
                    } else if(choosebattingTeam.equals(t1name)){
                        run = t2run.toInt()-t1run.toInt()
                        r=run+1
                        needrun = "Need" + " " + r.toString() + " " + "runs on" + " " + needruntowin + " " + "balls."
                        if(r>t2run.toInt()) {
                            needrun = t1name + " " + "won by" + wont2Run(t2run.toInt(), r).toString() + " " + "runs"

                        }
                        Log.d("bharti","value t2Run"+run)
                    }
                }*/



                if(inning.equals("2")&& status.equals("Live") ) {

                    needrun = "Need" + " " + (run+1).toString() + " " + "runs on" + " " + needruntowin + " " + "balls."
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
                runtowintv.text=needrun
                Log.d("bharti", "Value is: " + needrun);
                // textView.setText(""+dataSnapshot.child("match3").child("team2").child("name").getValue());
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("bharti", "Failed to read value.", error.toException())
            }
        })
    }

    fun getBatsmanFirst(b1name:String,b1Run:String,b1Balls:String,b1Four:String,b1Six:String){
        batsman1_tv.text=b1name
        b1run_tv.text=b1Run
        b1ball_tv.text=b1Balls
        b1four_tv.text=b1Four
        b1six_tv.text=b1Six
        var baller1strikerate=strikeRate(b1Run.toFloat(),b1Balls.toFloat())
        b1sr_tv.text= DecimalFormat("##.##").format(baller1strikerate)

    }
    fun getBatsmanSecond(b2name:String,b2Run:String,b2Balls:String,b2Four:String,b2Six:String){
        batsman2_tv.text=b2name
        b2run_tv.text=b2Run
        b2ball_tv.text=b2Balls
        b2four_tv.text=b2Four
        b2six_tv.text=b2Six
        var baller2strikerate=strikeRate(b2Run.toFloat(),b2Balls.toFloat())
        b2sr_tv.text= DecimalFormat("##.##").format(baller2strikerate)

    }
    fun getBowlerFirst(bowler1name:String,bowler1o:String,bowler1m:String,bowler1r:String,bowler1w:String){
        bowler1_tv.text=bowler1name
        bowler1o_tv.text=bowler1o
        bowler1m_tv.text=bowler1m
        bowler1r_tv.text=bowler1r
        bowler1w_tv.text=bowler1w
        var bowller1economicrate=economicRate(bowler1o.toFloat(),bowler1r.toFloat())
        bowler1er_tv.text=DecimalFormat("##.##").format(bowller1economicrate)


    }
    fun getBowlerSecond(bowler2name:String,bowler2o:String,bowler2m:String,bowler2r:String,bowler2w:String){
        bowler2_tv.text=bowler2name
        bowler2o_tv.text=bowler2o
        bowler2m_tv.text=bowler2m
        bowler2r_tv.text=bowler2r
        bowler2w_tv.text=bowler2w
        var bowller2economicrate=economicRate(bowler2o.toFloat(),bowler2r.toFloat())

        bowler2er_tv.text=DecimalFormat("##.##").format(bowller2economicrate)


    }
    fun strikeRate(run:Float,balls:Float):Float{
        var strikerate=(run*100)/balls
        Log.d("Strike", "strike rate Value is: ${strikerate}")
        return strikerate
    }
    fun economicRate(over:Float,run:Float):Float{
        var economicrate=(run/over)
        Log.d("Strike", "economic rate Value is: $economicrate")
        return economicrate
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
