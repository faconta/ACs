package faconta.fabio.agenda


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_novo_contato.*

class NovoContato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_contato)

        botao_salvar.setOnClickListener{
            var d = Contato()
            d.nome = campo_nome.text.toString()
            d.email = campo_email.text.toString()
            d.foto =campo_imagem.text.toString()
            d.telefone= campo_tel.text.toString()
            Thread{
                ObejctService.saveDisciplina(d)
                runOnUiThread {
                    finish()
                }

            }.start()
        }
    }
}