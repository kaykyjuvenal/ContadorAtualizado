package br.edu.ifsp.scl.ads.contador

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.contador.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {

    private var contador: Int  = 0
    private lateinit var amb: ActivityMainBinding;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)
        amb.cliqueBt.setOnClickListener{
            amb.contadorTv.setText((++contador).toString())
        }
        amb.inicialSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent:AdapterView<*>,
                view: View?,
                position: Int,
                id:Long
            ){
                contador = when(position){
                    0 -> 0
                    1 -> 5
                    2 -> 10
                    else -> 0// Esgotar as opções quando when é usado comom expression
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}