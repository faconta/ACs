package faconta.fabio.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar_home)
        supportActionBar?.title = "Contatos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        familia.setOnClickListener{
            var intent = Intent(this, familia::class.java)
            startActivity(intent)
        }

        trabalho.setOnClickListener{
            var intent = Intent(this, trabalho::class.java)
            startActivity(intent)
        }

        pessoaldobar.setOnClickListener{
            var intent = Intent(this, pessoaldobar::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menutoolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.adicionar){
            var intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }else if (id == R.id.action_atualizar){
            progresso2.visibility = VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    progresso2.visibility = View.GONE
                }, 10000
            )

        } else if(id == R.id.config) {
            var intent = Intent(this, configuracao::class.java)
            startActivity(intent)
        }else if(id == R.id.sair){
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }


}