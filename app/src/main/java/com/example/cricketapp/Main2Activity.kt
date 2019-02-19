package com.example.cricketapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main2.*

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var arrayList:ArrayList<DataModal>
     var t1name:String=""
     var t1run:String=""
     var t1over:String=""
     var t1viket:String=""
     var t2name:String=""
     var t2run:String=""
     var t2over:String=""
     var t2viket:String=""
     var status:String=""
     var needruntowin:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("matches")
        arrayList = ArrayList<DataModal>()

//for add child object
        /*  DatabaseReference path= database.getReference("matches").child("match4");
        path.child("Batsman").setValue("123");*/

//Log.d("bharti","key"+key);

        // myRef.setValue("Hello, World!");
        myRef.addValueEventListener(object : ValueEventListener {
            @SuppressLint("SetTextI18n")
            override fun onDataChange(dataSnapshot: DataSnapshot) {

             /*   for (taskNo in dataSnapshot.children) {
                    // now you in (9223450)
                    val key = taskNo.key
                    val firebaseObj = taskNo.value //class with params set/get methods
                    //   Object replayObj = taskNo.getValue(); //class with params set/get methods
                     status = taskNo.child("matchtype").value!!.toString()
                    val tosswinteam = taskNo.child("tosswinningteam").value!!.toString()
                     needruntowin = taskNo.child("needruntowin").value!!.toString()

                    Log.d("bharti", "Value is: $key $tosswinteam $status $needruntowin")
                    // ALTERNATIVE
                    //if(key.equals("match1")) {
                    for (child in taskNo.children) {
                        if (child.key == "team1") {
                             t1over = child.child("over").value!!.toString()
                             t1name = child.child("name").value!!.toString()
                            val t1rate1 = child.child("rate1").value!!.toString()
                            val t1rate2 = child.child("rate2").value!!.toString()
                             t1run = child.child("run").value!!.toString()
                             t1viket = child.child("wicket").value!!.toString()
                            Log.d("bharti", "Child t1 Value is: $t1over $t1name $t1rate1 $t1rate2 $t1run $t1viket")

                        } else if (child.key == "team2") {
                             t2over = child.child("over").value!!.toString()
                             t2name = child.child("name").value!!.toString()
                            val t2rate1 = child.child("rate1").value!!.toString()
                            val t2rate2 = child.child("rate2").value!!.toString()
                             t2run = child.child("run").value!!.toString()
                             t2viket = child.child("wicket").value!!.toString()

                            Log.d("bharti", "Child t2 Value is: $t2over $t2name $t2rate1 $t2rate2 $t2run $t2viket")

                        } else if (child.key == "Batsman") {
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

                        }


                        // }
                    }

                    //arrayList.add(DataModal(status, needruntowin, t1name,t1run,t1over,t1viket,t2name,t2run,t2over,t2viket))

                    Log.d("bharti", "arraylistsize:${arrayList.size}")

                }
*/

                //Log.d("bharti", "Value is: " + value.tosswinteam);
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("bharti", "Failed to read value.", error.toException()!!)
            }
        })

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
*/
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
