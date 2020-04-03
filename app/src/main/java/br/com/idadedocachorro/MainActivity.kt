package br.com.idadedocachorro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

        fun calcular(view: View) {
        hideSoftKeyboard();
        val idade = idade.text.toString();
        val validaCampo = validaCampo(idade);
            if (validaCampo) {
                intent = Intent(this, SegundaActivity::class.java);
                intent.putExtra("idade", idade);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Por favor informe a idade !", Toast.LENGTH_SHORT).show();
            }
        }

    fun limpaCampos (view: View) {
        idade.setText("");
    }

    /**
     * Esconda o teclado
     */
    fun hideSoftKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0);
        }
    }

    fun validaCampo(idade: String): Boolean {
        var campoValidado: Boolean = true;
        if (idade == null || idade.equals("")) {
            campoValidado = false;
        }
        return campoValidado;
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}