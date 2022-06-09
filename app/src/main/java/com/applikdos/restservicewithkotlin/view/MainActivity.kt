package com.applikdos.restservicewithkotlin.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applikdos.restservicewithkotlin.databinding.ActivityMainBinding
import com.applikdos.restservicewithkotlin.entities.UserDataCollectionItem
import com.applikdos.restservicewithkotlin.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRest.setOnClickListener { callServiceGetUsers() }

    }

    private fun callServiceGetUsers() {
        presenter.listUsers()
    }

    override fun showResult(result: List<UserDataCollectionItem>) {
        Log.d("Success Response", result.toString())
        Toast.makeText(this, "Success Response", Toast.LENGTH_LONG).show()
    }

    override fun errorResult(t: String) {
        Toast.makeText(this, "Error Reponse", Toast.LENGTH_LONG).show()
    }


}