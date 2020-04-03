package br.com.idadedocachorro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_segunda.*

class SegundaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val dados:Bundle? = intent.extras;

        val idade = dados?.getString("idade")
        calcularIdade(idade.toString());
    }

    fun calcularIdade(idade: String) {
        val idade = idade.toInt();
        val idadeFinal = idade * 7;
        mostraIdade.setText("A idade do seu cachorro é de " + idadeFinal.toString() + " anos humanos.");
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
