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
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_contatos.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class home : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar_home)
        supportActionBar?.title = "Contatos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerContatos?.layoutManager = LinearLayoutManager(this)
        recyclerContatos?.itemAnimator = DefaultItemAnimator()
        recyclerContatos?.setHasFixedSize(true)



        familia.setOnClickListener{
            var intent = Intent(this, faculdade::class.java)
            startActivity(intent)
        }

        trampo.setOnClickListener{
            var intent = Intent(this, trabalho::class.java)
            startActivity(intent)
        }

        cachaca.setOnClickListener{
            var intent = Intent(this, pessoaldobar::class.java)
            startActivity(intent)
        }

    }


    override fun onResume() {
        super.onResume()
        taskcontatos()
    }

    private var contatos = listOf<Contato>()
    fun taskcontatos(){
        contatos = ObejctService.getContatos(this)
        recyclerContatos?.adapter = Contato_Adapter(contatos) {onClickContato(it)}

    }

    fun  onClickContato(contato: Contato){
        val it = Intent(this, ContatoActivity::class.java)
        it.putExtra("contato",contato)
        startActivity(it)

    }

    override fun onNavigationItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.buscar -> {
               Toast.makeText(this, "buscar", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,home::class.java)
                startActivity(intent)

            }
            R.id.atualizar ->{
                Toast.makeText(this, "atualizando", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,trabalho::class.java)
                startActivity(intent)
            }
            R.id.configuracao -> {
                Toast.makeText(this, "config", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,pessoaldobar::class.java)
                startActivity(intent)
            }
            R.id.nav_ctto -> {
                Toast.makeText(this, "adicionar", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,Cadastro::class.java)
                startActivity(intent)
            }
            R.id.saindo -> {
                Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }



        layMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }




    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layMenuLateral,
            toolbar_home,
            R.string.navigation_drawer_open ,
            R.string.navigation_drawer_close
        )
        layMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        lateral.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menutoolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar){
            Toast.makeText(this, "Botão buscar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_atualizar){

            Toast.makeText(this, "Botão Atualizar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_buscar){
            Toast.makeText(this, "Botão Config ",   Toast.LENGTH_SHORT).show()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }else if (id == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }


}