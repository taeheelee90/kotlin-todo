package com.example.memo

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

@SuppressLint("StaticFieldLeak")
class MainActivity : AppCompatActivity() {

    lateinit var db : ToDoDatabase
    var toDoList : List <ToDoEntity> = listOf<ToDoEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get db instance
        db = ToDoDatabase.getInstance(this)!!

        // Set button event listener
        addBtn.setOnClickListener{
            val toDo = ToDoEntity (null, editText_toDo.toString())
            insertToDo(toDo)
        }

        // Recycler View

    }

    private fun insertToDo(toDo: ToDoEntity) {
        // Used AsyncTask for learning purpose. Can be upgraded with Coroutine later
        val insertTask = object : AsyncTask<Unit, Unit, Unit>(){

            override fun doInBackground(vararg params: Unit?){
                db.toDoDAO().insert(toDo)
            }
            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllToDos()
            }
        }
        insertTask.execute()
    }

    fun getAllToDos(){
        val getTask = object : AsyncTask<Unit, Unit, Unit>() {

            override fun doInBackground(vararg p0: Unit?) {
                toDoList = db.toDoDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecyclerView(toDoList)
            }
        }
        getTask.execute()
    }

    fun deleteToDO(){

    }

    fun setRecyclerView(toDoList: List<ToDoEntity>) {

    }

}