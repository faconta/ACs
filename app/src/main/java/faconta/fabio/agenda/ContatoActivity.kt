package faconta.fabio.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ContatoActivity : AppCompatActivity() {override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_contato)

    val disciplina = intent?.getSerializableExtra("contato")

    Toast.makeText(this, "Contato: $disciplina", Toast.LENGTH_LONG).show()
}

}