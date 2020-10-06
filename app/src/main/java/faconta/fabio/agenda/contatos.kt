package faconta.fabio.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_contatos.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.toolbar.*

class contatos : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contatos)
        configuraMenuLateral()
    }
    override fun onNavigationItemSelected(item: MenuItem):Boolean{
        when(item.itemId){
            R.id.buscar -> {
                Toast.makeText(this, "busca", Toast.LENGTH_SHORT).show()
            }
            R.id.atualizar ->{
                Toast.makeText(this, "atualizando", Toast.LENGTH_SHORT).show()
            }
            R.id.configuracao -> {
                Toast.makeText(this, "config", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_ctto -> {
                Toast.makeText(this, "adicionando", Toast.LENGTH_SHORT).show()
            }
            R.id.saindo -> {
                Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show()

            }
        }



        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    private fun configuraMenuLateral(){
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar_home,
            R.string.navigation_drawer_open ,
            R.string.navigation_drawer_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }}
