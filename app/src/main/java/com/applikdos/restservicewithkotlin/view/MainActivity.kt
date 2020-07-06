package com.applikdos.restservicewithkotlin.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applikdos.restservicewithkotlin.R
import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(),MainView  {

    var presenter: MainPresenterImpl = MainPresenterImpl(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.btnRest)
        boton.setOnClickListener{v -> callServiceGetUsers()  }

    }

    private fun callServiceGetUsers() {
        presenter.listUsers()
    }

    override fun showResult(result: List<UserDataCollectionItem>) {
        Toast.makeText(this,"Success Response",Toast.LENGTH_LONG).show()
    }

    override fun errorResult(t: String) {
        Toast.makeText(this,"Error Reponse",Toast.LENGTH_LONG).show()
    }


}