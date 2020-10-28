package faconta.fabio.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        Prefs.setString("nome", "Novo nome da String")
        Prefs.setBoolean("professor", true)

        campousuario.setText(Prefs.getString("lembrarnome"))
        camposenha.setText(Prefs.getString("lembrarsenha"))

        checkBox.isChecked=Prefs.getBoolean("lembrar")

        botaoacessar.setOnClickListener{
            progresso.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    progresso.visibility = View.GONE
                    val nomeUsuario = campousuario.text.toString()
                    val camposenha =  camposenha.text.toString()

                    val lembrar = checkBox.isChecked
                    Prefs.setBoolean("lembrar",lembrar)
                    if (lembrar){
                        Prefs.setString("lembrarnome",nomeUsuario)
                        Prefs.setString("lembrarsenha",camposenha)

                    }else{
                        Prefs.setString("lembrarnome","")
                        Prefs.setString("lembrarsenha","")


                    }
                    if(nomeUsuario == "aluno" && camposenha == "impacta") {
                        var intent = Intent(this, home::class.java)

                        var params = Bundle()
                        params.putString("nome_usuario", nomeUsuario)
                        params.putInt("numero", 10)

                        intent.putExtras(params)
                        startActivity(intent)
                    }else{Toast.makeText( this, "Usuario Invalido ou Senha invalido", Toast.LENGTH_SHORT).show()}

                }, 100
            )


        }








    }
}