package br.com.idadedocachorro

import android.app.Activity
import android.content.Context
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
                calcularIdade(idade);
            } else {
                Toast.makeText(this, "Por favor informe a idade !", Toast.LENGTH_LONG).show();
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

    fun calcularIdade(idade: String) {
        val idade = idade.toInt();
        val idadeFinal = idade * 7;
        resultado.setText("A idade do seu cachorro é de " + idadeFinal.toString() + " anos.");
    }
}